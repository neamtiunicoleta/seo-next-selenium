package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;

public class LinksPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public LinksPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void inputTitle(String title) {
		linksPage().switchToCreateIframe();
		linksPage().inputTitle(title);
	}

	@Step
	public void selectSourceObject(String source) {
		linksPage().selectSourceObject(source);
	}

	@Step
	public void selectTargetObject(String target) {
		linksPage().selectTargetObject(target);
	}

	@Step
	public void inputRelations(String relation) {
		linksPage().inputRelations(relation);
	}

	@Step
	public void checkSourceForLinkCategories(String id, String source) {
		linksPage().checkSourceForLinkCategories(id, source);
	}

	@Step
	public void checkTargetForLinkCategories(String id, String target) {
		linksPage().checkTargetForLinkCategories(id, target);
	}

	@Step
	public void checkRelations(String id, String relation) {
		linksPage().checkRelations(id, relation);
	}

	@StepGroup
	public void createLinkCategory(String title, String source, String target,
			String relation) {
		linksPage().switchToCreateIframe();
		linksPage().inputTitle(title);
		linksPage().selectSourceObject(source);
		linksPage().selectTargetObject(target);
		linksPage().inputRelations(relation);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void selectLinkCategory(String category) {
		linksPage().selectLinkCategory(category);
	}

	@StepGroup
	public void createLinkType(String title, String category) {
		linksPage().switchToCreateIframe();
		linksPage().inputTitle(title);
		linksPage().selectLinkCategory(category);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkLinkCategory(String id, String linkCategory) {
		linksPage().checkLinkCategory(id, linkCategory);
	}
}
