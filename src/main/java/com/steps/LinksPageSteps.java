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
	public void selectSourceObjectType(String source) {
		linksPage().selectSourceObjectType(source);
	}

	@Step
	public void selectTargetObjectType(String target) {
		linksPage().selectTargetObjectType(target);
	}

	@Step
	public void inputRelations(String relation) {
		linksPage().inputRelations(relation);
	}

	@Step
	public void checkSource(String id, String source) {
		linksPage().checkSource(id, source);
	}

	@Step
	public void checkTarget(String id, String target) {
		linksPage().checkTarget(id, target);
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
		linksPage().selectSourceObjectType(source);
		linksPage().selectTargetObjectType(target);
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

	@StepGroup
	public void createActiveLink(String title, String sourceType,
			String sourceObject, String targetType, String targetObject,
			String linkType, String comment) {
		linksPage().switchToCreateIframe();
		linksPage().inputTitle(title);
		linksPage().selectSourceObjectType(sourceType);
		linksPage().selectSourceObject(sourceObject);
		linksPage().selectTargetObjectType(targetType);
		linksPage().selectTargetObject(targetObject);
		linksPage().selectLinkType(linkType);
		linksPage().clickOnActiveCheckBox();
		linksPage().inputComments(comment);
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createInactiveLink(String title, String sourceType,
			String sourceObject, String targetType, String targetObject,
			String linkType, String comment) {
		linksPage().switchToCreateIframe();
		linksPage().inputTitle(title);
		linksPage().selectSourceObjectType(sourceType);
		linksPage().selectSourceObject(sourceObject);
		linksPage().selectTargetObjectType(targetType);
		linksPage().selectTargetObject(targetObject);
		linksPage().selectLinkType(linkType);
		linksPage().inputComments(comment);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void selectSourceObject(String source) {
		linksPage().selectSourceObject(source);
	}

	@Step
	public void selectTargetObject(String source) {
		linksPage().selectTargetObject(source);
	}

	@Step
	public void selectLinkType(String linkType) {
		linksPage().selectLinkType(linkType);
	}

	@Step
	public void inputComments(String comment) {
		linksPage().inputComments(comment);
	}

	@Step
	public void clickOnActiveCheckBox() {
		linksPage().clickOnActiveCheckBox();
	}

	@Step
	public void checkLinkType(String id, String linkType) {
		linksPage().checkLinkType(id, linkType);
	}

	@Step
	public void checkIfActiveCheckBoxIsChecked(String id) {
		linksPage().checkIfActiveCheckBoxIsChecked(id);
	}

	@Step
	public void checkIfActiveCheckBoxIsNotChecked(String id) {
		linksPage().checkIfActiveCheckBoxIsNotChecked(id);
	}
}
