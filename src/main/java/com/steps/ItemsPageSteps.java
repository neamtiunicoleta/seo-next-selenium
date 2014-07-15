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
	public void inputKeyFieldTaskType(String key) {
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
		abstractPage().pressEscape();
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
	public void checkThatElementIsNotPresent(String... key) {
		Assert.assertFalse("The element is present", itemsPage()
				.checkIfElementIsPresent(key));
		waitABit(2000);
	}

	@Step
	public void selectCountry(String countryName) {
		itemsPage().selectCountry(countryName);
	}

	@Step
	public void clickOnHighImportanceCheckBox() {
		itemsPage().clickOnHighImportanceCheckBox();
	}

	@Step
	public void checkCountryFromGrid(String id, String country) {
		itemsPage().checkCountryFromGrid(id, country);
	}

	@StepGroup
	public void createActiveCurrency(String key, String code, String title,
			String country, String value) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputCodeField(code);
		itemsPage().inputTitleField(title);
		itemsPage().selectCountry(country);
		itemsPage().clickOnActiveCheckBox();
		itemsPage().clickOnHighImportanceCheckBox();
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createInactiveCurrency(String key, String code, String title,
			String country, String value) {
		itemsPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputCodeField(code);
		itemsPage().inputTitleField(title);
		itemsPage().selectCountry(country);
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

	@Step
	public void checkRateFromGrid(String startDate, String rate) {
		itemsPage().checkRateFromGrid(startDate, rate);
	}

	@StepGroup
	public void createCountryWithRisk(String name, String code, String risk) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputTitleField(name);
		itemsPage().inputCodeField(code);
		itemsPage().selectRisk(risk);
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createCountryWithoutRisk(String name, String code) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputTitleField(name);
		itemsPage().inputCodeField(code);
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

	@Step
	public void inputActualSituationForDocSituation(String situation) {
		abstractPage().switchToCreateIframe();
		itemsPage().inputActualSituationForDocSituation(situation);
	}

	@Step
	public void inputRiskForDocSituation(String risk) {
		itemsPage().inputRiskForDocSituation(risk);
	}

	@Step
	public void inputResolutionForDocSituation(String resolution) {
		itemsPage().inputResolutionForDocSituation(resolution);
	}

	@Step
	public void checkRiskForDocSituation(String title, String risk) {
		itemsPage().checkRiskForDocSituation(title, risk);
	}

	@Step
	public void checkResolutionForDocSituation(String title, String resolution) {
		itemsPage().checkResolutionForDocSituation(title, resolution);
	}

	@Step
	public void inputOrganizationUnit(String unit) {
		itemsPage().inputOrganizationUnit(unit);
	}

	@Step
	public void inputPopBox(String popBox) {
		itemsPage().inputPopBox(popBox);
	}

	@Step
	public void inputEmployees(String userName) {
		itemsPage().inputEmployees(userName);
	}

	@StepGroup
	public void createOfficeIfNotExists(String name, String unit,
			String street, String zip, String city, String country,
			String popBox, String userName) {
		if (!itemsPage().checkIfElementIsPresent(name)) {
			abstractPage().selectActionFromRibbon("Create");
			abstractPage().switchToCreateIframe();
			itemsPage().inputTitleField(name);
			itemsPage().inputOrganizationUnit(unit);
			clientsPage().inputStreet(street);
			clientsPage().inputZIP(zip);
			clientsPage().inputCity(city);
			itemsPage().selectCountry(country);
			itemsPage().inputPopBox(popBox);
			itemsPage().inputEmployees(userName);
			abstractPage().selectActionFromRibbon("Save");
		}
	}

	@StepGroup
	public void createBasicOfficeIfNotExists(String name, String unit) {
		if (!itemsPage().checkIfElementIsPresent(name)) {
			abstractPage().selectActionFromRibbon("Create");
			abstractPage().switchToCreateIframe();
			itemsPage().inputTitleField(name);
			itemsPage().inputOrganizationUnit(unit);
			abstractPage().selectActionFromRibbon("Save");
		}
	}

	@Step
	public void checkOrganizationunit(String name, String unit) {
		itemsPage().checkOrganizationUnit(name, unit);
	}

	@Step
	public void selectMandateServiceType(String type) {
		itemsPage().selectMandateServiceType(type);
	}

	@Step
	public void checkTypeFromGrid(String id, String type) {
		itemsPage().checkTypeFromGrid(id, type);
	}

	@Step
	public void inputServiceDescription(String description) {
		itemsPage().inputServiceDescription(description);
	}

	@Step
	public void selectTaskTypeForDeficienct(String type) {
		itemsPage().selectTaskTypeForDeficienct(type);
	}
}
