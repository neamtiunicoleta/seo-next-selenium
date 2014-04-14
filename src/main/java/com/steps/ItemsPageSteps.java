package com.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;

public class ItemsPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public ItemsPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void inputKeyField(String key) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
	}

	@Step
	public void inputDescriptionField(String description) {
		itemsPage().inputDescriptionField(description);
	}

	@Step
	public void selectRisk(String riskCategory) {
		itemsPage().selectRisk(riskCategory);
	}

	@Step
	public void checkActive() {
		itemsPage().checkActive();
	}

	@Step
	public void checkDescription(String id, String description) {
		itemsPage().checkDescription(id, description);
	}

	@StepGroup
	public void createRiskCriteria(String key, String description,
			String riskCategory) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputDescriptionField(description);
		itemsPage().selectRisk(riskCategory);
		itemsPage().checkActive();
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createRiskCategoryOrAsset(String key, String description) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputDescriptionField(description);
		itemsPage().checkActive();
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkThatCategoryExists(String id) {
		abstractPage().switchToCreateIframe();
		Assert.assertTrue("The category shouln't be displayed!", itemsPage()
				.checkIfCategoryExists(id));
	}

	@Step
	public void checkThatCategoryDoesntExist(String id) {
		abstractPage().switchToCreateIframe();
		Assert.assertFalse("The category shouln't be displayed!", itemsPage()
				.checkIfCategoryExists(id));
	}

	@Step
	public void inputCodeField(String code) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputCodeField(code);
	}

	@Step
	public void inputTitleField(String title) {
		itemsPage().inputTitleField(title);
	}

	@Step
	public void checkTitle(String id, String title) {
		itemsPage().checkTitle(id, title);
	}

	@StepGroup
	public void createBusinessCode(String code, String title, String risk) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputCodeField(code);
		itemsPage().inputTitleField(title);
		itemsPage().selectRisk(risk);
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkIfElementIsPresent(String key) {
		itemsPage().checkIfElementIsPresent(key);
	}

}
