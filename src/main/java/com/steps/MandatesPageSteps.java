package com.steps;

import java.util.Date;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;
import com.tools.DateUtils;

public class MandatesPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public MandatesPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void selectServiceType(String... type) {
		mandatesPage().selectServiceType(type);
	}

	@Step
	public void checkDescription(String id, String description) {
		mandatesPage().checkDescription(id, description);
	}

	@Step
	public void checkServiceType(String id, String type) {
		mandatesPage().checkServiceType(id, type);
	}

	@Step
	public void selectMandateType(String type) {
		mandatesPage().selectMandateType(type);
	}

	@Step
	public void inputOfficeFileNumber(String number) {
		mandatesPage().inputOfficeFileNumber(number);
	}

	@Step
	public void inputFullName(String name) {
		mandatesPage().inputFullName(name);
	}

	@Step
	public void inputPOPBox(String pop) {
		mandatesPage().inputPOPBox(pop);
	}

	@Step
	public void inputAccountManager(String userName) {
		mandatesPage().inputAccountManager(userName);
	}

	@Step
	public void inputCompanyType(String type) {
		mandatesPage().inputCompanyType(type);
	}

	@Step
	public void selectOffice(String office) {
		mandatesPage().selectOffice(office);

	}

	@Step
	public void selectOfficeLink(String officeLink) {
		mandatesPage().selectOfficeLink(officeLink);
	}

	@Step
	public void inputPurpose(String purpose) {
		mandatesPage().inputPurpose(purpose);
	}

	@Step
	public void inputAgreementDate(String days) {
		mandatesPage().inputAgreementDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@StepGroup
	public void addNewContact(String user, String label) {
		mandatesPage().clickOnAddContact();
		abstractPage().switchToCreateIframe();
		mandatesPage().inputContactUser(user);
		mandatesPage().inputContactLabel(label);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void inputActualBusinessActivities(String activity) {
		mandatesPage().inputActualBusinessActivities(activity);
	}

	@Step
	public void inputValuationOfTheLegalEntityAmount(String valuation) {
		mandatesPage().inputValuationOfTheLegalEntityAmount(valuation);
	}

	@Step
	public void inputYearlyTurnoverAmount(String amount) {
		mandatesPage().inputYearlyTurnoverAmount(amount);
	}

	@Step
	public void inputYearlyNetProfitAmount(String amount) {
		mandatesPage().inputYearlyNetProfitAmount(amount);
	}

	@Step
	public void selectValuationOfTheLegalEntityCurrency(String currency) {
		mandatesPage().selectValuationOfTheLegalEntityCurrency(currency);
	}

	@Step
	public void selectYearlyTurnoverCurrency(String currency) {
		mandatesPage().selectYearlyTurnoverCurrency(currency);
	}

	@Step
	public void selectYearlyNetProfitCurrency(String currency) {
		mandatesPage().selectYearlyNetProfitCurrency(currency);
	}

	@Step
	public void inputNumberOfStaff(String number) {
		mandatesPage().inputNumberOfStaff(number);
	}

	@Step
	public void inputBusinessActivitiesComments(String comment) {
		mandatesPage().inputBusinessActivitiesComments(comment);
	}

	@Step
	public void inputFinancialYear(String year) {
		mandatesPage().inputFinancialYear(year);
	}

	@Step
	public void inputCorporateCapitalAmount(String amount) {
		mandatesPage().inputCorporateCapitalAmount(amount);
	}

	@Step
	public void selectCorporateCapitalCurrency(String currency) {
		mandatesPage().selectCorporateCapitalCurrency(currency);
	}

	@Step
	public void inputAuditor(String auditor) {
		mandatesPage().inputAuditor(auditor);
	}

	@StepGroup
	public void addBankableAsset(String bank, String amount, String currency,
			String comment) {
		mandatesPage().clickOnAddBankableAsset();
		abstractPage().switchToCreateIframe();
		mandatesPage().inputBankOfOrigin(bank);
		mandatesPage().inputAproxAmount(amount);
		mandatesPage().selectAproxAmountCurrency(currency);
		clientsPage().inputComments(comment);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@StepGroup
	public void addParticipation(String name, String value, String currency,
			String street, String code, String city, String country,
			String activity, String percentage, String comment) {
		mandatesPage().clickOnAddParticipation();
		abstractPage().switchToCreateIframe();
		mandatesPage().inputName(name);
		mandatesPage().inputEstimatedValue(value);
		mandatesPage().selectCurrency(currency);
		clientsPage().inputStreet(street);
		clientsPage().inputZIP(code);
		clientsPage().inputCity(city);
		itemsPage().selectCountry(country);
		mandatesPage().inputActivity(activity);
		mandatesPage().inputPercentage(percentage);
		mandatesPage().inputComments(comment);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@StepGroup
	public void addRealEstate(String description, String value,
			String currency, String street, String code, String city,
			String country, String comment) {
		mandatesPage().clickOnAddRealEstate();
		abstractPage().switchToCreateIframe();
		mandatesPage().inputDescription(description);
		mandatesPage().inputEstimatedValue(value);
		mandatesPage().selectCurrency(currency);
		clientsPage().inputStreet(street);
		clientsPage().inputZIP(code);
		clientsPage().inputCity(city);
		itemsPage().selectCountry(country);
		mandatesPage().inputComments(comment);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@StepGroup
	public void addOtherInformation(String value, String currency,
			String place, String comment) {
		mandatesPage().clickOnAddOtherInformation();
		abstractPage().switchToCreateIframe();
		mandatesPage().inputEstimatedValue(value);
		mandatesPage().selectCurrency(currency);
		mandatesPage().inputPlace(place);
		mandatesPage().inputComments(comment);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void inputTypeOfTransaction(String type) {
		mandatesPage().inputTypeOfTransaction(type);
	}

	@Step
	public void selectDomicileOfCounterParties(String country) {
		mandatesPage().selectDomicileOfCounterParties(country);
	}

	@Step
	public void inputTransactionComments(String comment) {
		mandatesPage().inputTransactionComments(comment);
	}

	@Step
	public void clickOnFFICheckbox() {
		mandatesPage().clickOnFFICheckbox();
	}

	@Step
	public void clickOnNFFICheckbox() {
		mandatesPage().clickOnNFFICheckbox();
	}

	@Step
	public void inputTINNumber(String number) {
		mandatesPage().inputTINNumber(number);
	}

	@Step
	public void inputRegistrationDate(String days) {
		mandatesPage().inputRegistrationDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}
}
