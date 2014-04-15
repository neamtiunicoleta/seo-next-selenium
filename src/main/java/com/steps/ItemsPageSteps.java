package com.steps;

import java.util.Date;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;
import com.tools.DateUtils;

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
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createRiskCategoryOrAsset(String key, String description) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputDescriptionField(description);
		itemsPage().checkActive();
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkThatCategoryExists(String id) {
		abstractPage().switchToCreateIframe();
		Assert.assertTrue("The category shouldn't be displayed!", itemsPage()
				.checkIfCategoryExists(id));
	}

	@Step
	public void checkThatCategoryDoesntExist(String id) {
		abstractPage().switchToCreateIframe();
		Assert.assertFalse("The category shouldn't be displayed!", itemsPage()
				.checkIfCategoryExists(id));
	}

	@Step
	public void inputCodeField(String code) {
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
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkIfElementIsPresent(String key) {
		Assert.assertTrue("The element is not present", itemsPage()
				.checkIfElementIsPresent(key));
		waitABit(2000);
	}

	@Step
	public void selectCountry(String countryName) {
		itemsPage().selectCountry(countryName);
	}

	@Step
	public void inputRoundingValue(String value) {
		itemsPage().inputRoundingValue(value);
	}

	@Step
	public void checkHighImportance() {
		itemsPage().checkHighImportance();
	}

	@Step
	public void checkRoundingValue(String id, String code) {
		itemsPage().checkRoundingValue(id, code);
	}

	@Step
	public void checkCountry(String id, String country) {
		itemsPage().checkCountry(id, country);
	}

	@StepGroup
	public void createCurrency(String key, String code, String title,
			String country, String value) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputCodeField(code);
		itemsPage().inputTitleField(title);
		itemsPage().selectCountry(country);
		itemsPage().inputRoundingValue(value);
		itemsPage().checkActive();
		itemsPage().checkHighImportance();
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void inputStartDate(String startDate) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputStartDate(startDate);
	}

	@Step
	public void inputRate(String rate) {
		itemsPage().inputRate(rate);
	}

	@StepGroup
	public void createExchangeRateWithStartDate(String daysInFuture, String rate) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputStartDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(),
								Integer.parseInt(daysInFuture)), "dd/MM/yyyy"));
		itemsPage().inputRate(rate);
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createExchangeRateWithYearToDate(String rate) {
		abstractPage().switchToCreateIframe();
		itemsPage().checkYearToDate();
		itemsPage().inputRate(rate);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkEndDate(String startDate, String endDate) {
		itemsPage().checkEndDate(startDate, endDate);
	}

	@Step
	public void checkRate(String startDate, String rate) {
		itemsPage().checkRate(startDate, rate);
	}
}
