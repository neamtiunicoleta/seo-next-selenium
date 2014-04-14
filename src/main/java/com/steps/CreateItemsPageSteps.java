package com.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;

public class CreateItemsPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public CreateItemsPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void inputKeyField(String key) {
		createItemsPage().switchToCreateIframe();
		createItemsPage().inputKeyField(key);
	}

	@Step
	public void inputDescriptionField(String description) {
		createItemsPage().inputDescriptionField(description);
	}

	@Step
	public void selectRisk(String riskCategory) {
		createItemsPage().selectRisk(riskCategory);
	}

	@Step
	public void checkActive() {
		createItemsPage().checkActive();
	}

	@Step
	public void checkDescription(String id, String description) {
		createItemsPage().checkDescription(id, description);
	}

	@StepGroup
	public void createRiskCriteria(String key, String description,
			String riskCategory) {
		createItemsPage().switchToCreateIframe();
		createItemsPage().inputKeyField(key);
		createItemsPage().inputDescriptionField(description);
		createItemsPage().selectRisk(riskCategory);
		createItemsPage().checkActive();
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createRiskCategoryOrAsset(String key, String description) {
		createItemsPage().switchToCreateIframe();
		createItemsPage().inputKeyField(key);
		createItemsPage().inputDescriptionField(description);
		createItemsPage().checkActive();
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkThatCategoryExists(String id) {
		abstractPage().switchToCreateIframe();
		Assert.assertTrue("The category shouln't be displayed!",
				createItemsPage().checkIfCategoryExists(id));
	}

	@Step
	public void checkThatCategoryDoesntExist(String id) {
		abstractPage().switchToCreateIframe();
		Assert.assertFalse("The category shouln't be displayed!",
				createItemsPage().checkIfCategoryExists(id));
	}

	@Step
	public void inputCodeField(String code) {
		abstractPage().switchToCreateIframe();
		createItemsPage().inputCodeField(code);
	}

	@Step
	public void inputTitleField(String title) {
		createItemsPage().inputTitleField(title);
	}

	@Step
	public void checkTitle(String id, String title) {
		createItemsPage().checkTitle(id, title);
	}

	@StepGroup
	public void createBusinessCode(String code, String title, String risk) {
		createItemsPage().switchToCreateIframe();
		createItemsPage().inputCodeField(code);
		createItemsPage().inputTitleField(title);
		createItemsPage().selectRisk(risk);
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon("Save");
	}

}
