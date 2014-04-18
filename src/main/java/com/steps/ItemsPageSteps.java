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
	public void clickOnActiveCheckBox() {
		itemsPage().clickOnActiveCheckBox();
	}

	@Step
	public void checkDescriptionFromGrid(String id, String description) {
		itemsPage().checkDescriptionFromGrid(id, description);
	}

	@StepGroup
	public void createRiskCriteria(String key, String description,
			String riskCategory) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputDescriptionField(description);
		itemsPage().selectRisk(riskCategory);
		itemsPage().clickOnActiveCheckBox();
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createRiskCategoryOrAsset(String key, String description) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputDescriptionField(description);
		itemsPage().clickOnActiveCheckBox();
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
	public void checkTitleFromGrid(String id, String title) {
		itemsPage().checkTitleFromGrid(id, title);
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
	public void checkIfElementIsPresent(String... key) {
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
	public void clickOnHighImportanceCheckBox() {
		itemsPage().clickOnHighImportanceCheckBox();
	}

	@Step
	public void checkRoundingValueFromGrid(String id, String code) {
		itemsPage().checkRoundingValueFromGrid(id, code);
	}

	@Step
	public void checkCountryFromGrid(String id, String country) {
		itemsPage().checkCountryFromGrid(id, country);
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
		itemsPage().clickOnActiveCheckBox();
		itemsPage().clickOnHighImportanceCheckBox();
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
		itemsPage().clickOnYearToDateCheckBox();
		itemsPage().inputRate(rate);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkEndDateFromGrid(String startDate, String endDate) {
		itemsPage().checkEndDateFromGrid(startDate, endDate);
	}

	@Step
	public void checkRateFromGrid(String startDate, String rate) {
		itemsPage().checkRateFromGrid(startDate, rate);
	}

	@StepGroup
	public void createCountry(String name, String code, String risk) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputTitleField(name);
		itemsPage().inputCodeField(code);
//		itemsPage().selectRisk(risk);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkRiskCriteriaFromGrid(String id, String riskCriteria) {
		itemsPage().checkRiskCriteriaFromGrid(id, riskCriteria);
	}

	@Step
	public void checkKeyForRisksFromGrid(String id, String key) {
		itemsPage().checkKeyForRisksFromGrid(id, key);
	}

	@Step
	public void checkRiskCategoryForCriteriasFromGrid(String id, String risk) {
		itemsPage().checkRiskCategoryForCriteriasFromGrid(id, risk);
	}

	@Step
	public void checkKeyForCurrenciesFromGrid(String id, String key) {
		itemsPage().checkKeyForCurrenciesFromGrid(id, key);
	}

	@Step
	public void checkCodeFromGrid(String id, String code) {
		itemsPage().checkCodeFromGrid(id, code);
	}

	@Step
	public void checkNameForBusinessCodesFromGrid(String id, String name) {
		itemsPage().checkNameForBusinessCodesFromGrid(id, name);
	}

	@Step
	public void clickOnDeleteLogItemsButton() {
		itemsPage().clickOnDeleteLogItemsButton();
	}

	@Step
	public void checkIfActiveCheckBoxIsChecked(String id) {
		itemsPage().checkIfActiveCheckBoxIsChecked(id);
	}

	@Step
	public void checkIfActiveCheckBoxIsNotChecked(String id) {
		itemsPage().checkIfActiveCheckBoxIsNotChecked(id);
	}

	@Step
	public void checkIfHighImportanceCheckBoxIsChecked(String id) {
		itemsPage().checkIfHighImportanceCheckBoxIsChecked(id);
	}

	@Step
	public void checkIfHighImportanceCheckBoxIsNotChecked(String id) {
		itemsPage().checkIfHighImportanceCheckBoxIsNotChecked(id);
	}
}
