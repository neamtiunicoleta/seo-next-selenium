package com.steps;

import java.util.Date;

import org.junit.Assert;

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
	public void inputValuationOfTheLegalEntityAmount(String valuation) {
		mandatesPage().inputValuationOfTheLegalEntityAmount(valuation);
	}

	@Step
	public void inputYearlyTurnoverAmount(String amount) {
		mandatesPage().inputYearlyTurnoverAmount(amount);
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

	@Step
	public void selectCurrency(String currency) {
		mandatesPage().selectCurrency(currency);
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

	@StepGroup
	public void checkMandateInformation(String type1, String type2,
			String fileNumber, String name, String street, String zip,
			String city, String country, String poBox, String office,
			String user, String officeLink, String companyType, String purpose,
			String days, String contactLabel, String contactUser,
			String activity, String businessCode, String valuationAmount,
			String valuationCurrency, String yearlyTurnoverAmount,
			String yearlyTurnoverCurrency, String staffNr,
			String businessComments, String year, String corporateAmount,
			String corporateCurrency, String auditor, String bank,
			String bankAmount, String bankCurrency, String bankComments,
			String participationName, String participationValue,
			String participationCurrency, String participationActivity,
			String participationPercentage, String participationComments,
			String participationCountry, String estateDescription,
			String estateValue, String estateCurrency, String estateComments,
			String estateCountry, String otherValue, String otherCurrency,
			String otherPlace, String otherComments, String transactionType,
			String domicileCountry, String transactionComments,
			String tinNumber, String registrationDays) {
		mandatesPage().checkServiceType(type1);
		mandatesPage().checkServiceType(type2);
		mandatesPage().checkOfficeFileNumber(fileNumber);
		mandatesPage().checkFullName(name);
		mandatesPage().checkStreet(street);
		mandatesPage().checkZipCode(zip);
		mandatesPage().checkCity(city);
		mandatesPage().checkCountry(country);
		mandatesPage().checkPoBox(poBox);
		clientsPage().checkOffice(office);
		mandatesPage().checkAccountManager(user);
		mandatesPage().checkOfficeLink(officeLink);
		mandatesPage().checkCompanyType(companyType);
		mandatesPage().checkPurpose(purpose);
		mandatesPage().checkAgreementDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
		mandatesPage().checkIfContactIsPresent();
		checkContactInformation(contactLabel, contactUser);
		abstractPage().clickOnTab("Business Activities");
		clientsPage().checkActualBusinessActivities(activity);
		clientsPage().checkBusinessCodes(businessCode);
		mandatesPage().checkValuationOfTheLegalEntityAmount(valuationAmount);
		mandatesPage()
				.checkValuationOfTheLegalEntityCurrency(valuationCurrency);
		mandatesPage().checkYearlyTurnoverAmount(yearlyTurnoverAmount);
		mandatesPage().checkYearlyTurnoverCurrency(yearlyTurnoverCurrency);
		mandatesPage().checkStaffNumber(staffNr);
		mandatesPage().checkBusinessActivitiesComments(businessComments);
		abstractPage().clickOnTab("Economic Background");
		mandatesPage().checkFinanciarYear(year);
		mandatesPage().checkCorporateCapitalAmount(corporateAmount);
		mandatesPage().checkCorporateCapitalCurrency(corporateCurrency);
		mandatesPage().checkAuditor(auditor);
		checkBankableAssetInformation(bank, bankAmount, bankCurrency,
				bankComments);
		checkParticipationInformation(participationName, participationValue,
				participationCurrency, participationActivity,
				participationPercentage, participationComments,
				participationCountry);
		checkRealEstateInformation(estateDescription, estateValue,
				estateCurrency, estateComments, estateCountry);
		checkOtherInformation(otherValue, otherCurrency, otherPlace,
				otherComments);
		abstractPage().clickOnTab("Transactions");
		mandatesPage().checkTypeOfTransaction(transactionType);
		mandatesPage().checkDomicileOfCounterParties(domicileCountry);
		mandatesPage().checkTransactionComments(transactionComments);
		abstractPage().clickOnTab("FATCA");
		mandatesPage().checkIfFFIIsChecked();
		mandatesPage().checkIfNFFIIsChecked();
		mandatesPage().checkTINNumber(tinNumber);
		mandatesPage().checkRegistrationDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(),
								Integer.parseInt(registrationDays)),
						"dd/MM/yyyy"));
	}

	@StepGroup
	public void checkContactInformation(String label, String user) {
		mandatesPage().checkIfContactIsPresent(label);
		mandatesPage().checkUserFromContacts(label, user);
	}

	@StepGroup
	public void checkBankableAssetInformation(String bank, String amount,
			String currency, String comments) {
		mandatesPage().checkIfBankableAssetIsPresent(bank);
		mandatesPage().checkInformationFromBankableAssets(bank, amount,
				currency, comments);
	}

	@StepGroup
	public void checkParticipationInformation(String name, String value,
			String currency, String activity, String percentage,
			String comments, String country) {
		mandatesPage().checkIfParticipationIsPresent(name);
		mandatesPage().checkInformationFromParticipation(name, value, currency,
				activity, percentage, comments, country);
	}

	@StepGroup
	public void checkRealEstateInformation(String description, String value,
			String currency, String comments, String country) {
		mandatesPage().checkIfRealEstateIsPresent(description);
		mandatesPage().checkInformationFromRealEstate(description, value,
				currency, comments, country);
	}

	@StepGroup
	public void checkOtherInformation(String value, String currency,
			String place, String comments) {
		mandatesPage().checkIfOtherInformationIsPresent(value);
		mandatesPage().checkInformationFromOtherInformation(value, currency,
				place, comments);
	}

	@Step
	public void checkMandateProfileType(String type) {
		mandatesPage().checkMandateProfileType(type);
	}

	@Step
	public void checkThatServiceTypeIsNotChecked(String... type) {
		mandatesPage().checkThatServiceTypeIsNotChecked(type);
	}

	@StepGroup
	public void createBasicMandate(String service, String name, String office,
			String manager) {
		abstractPage().selectActionFromRibbon("Create");
		mandatesPage().selectServiceType(service);
		mandatesPage().inputFullName(name);
		mandatesPage().selectOffice(office);
		mandatesPage().inputAccountManager(manager);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void inputUser(String userName) {
		mandatesPage().inputUser(userName);
	}

	@Step
	public void clickOnGetMandatesButton() {
		mandatesPage().clickOnGetMandatesButton();
	}

	@Step
	public void checkIfMandateIsPresent(String name) {
		Assert.assertTrue("The mandate is not displayed", mandatesPage()
				.checkIfMandateIsPresent(name));
	}

	@Step
	public void checkThatMandateIsNotPresent(String name) {
		Assert.assertFalse("The mandate is displayed", mandatesPage()
				.checkIfMandateIsPresent(name));
	}

	@Step
	public void changeAccountManager(String name) {
		abstractPage().switchToCreateIframe();
		mandatesPage().inputUser(name);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@StepGroup
	public void createTasktype(String key, String title) {
		abstractPage().selectActionFromRibbon("Create");
		abstractPage().switchToCreateIframe();
		itemsPage().inputKeyField(key);
		itemsPage().inputTitleField(title);
		abstractPage().selectActionFromRibbon("Save");
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void selectTypeOfIssue(String type) {
		mandatesPage().selectTypeOfIssue(type);
	}

	@Step
	public void selectTaskType(String type) {
		mandatesPage().selectTaskType(type);
	}

	@Step
	public void inputKeyField(String key) {
		itemsPage().inputKeyField(key);
	}

	@Step
	public void inputDeadlineDate(String days) {
		mandatesPage().inputDeadlineDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void selectTypeOfDeficiency(String type) {
		mandatesPage().selectTypeOfDeficiency(type);
	}

	@Step
	public void inputFindings(String findings) {
		mandatesPage().inputFindings(findings);
	}

	@Step
	public void inputAddionalRemarks(String remarks) {
		mandatesPage().inputAddionalRemarks(remarks);
	}

	@Step
	public void checkCreatedOnForOpenIssues(String id, String days) {
		mandatesPage().checkCreatedOnForOpenIssues(
				id,
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void checkDeadlineForOpenIssues(String id, String days) {
		mandatesPage().checkDeadlineForOpenIssues(
				id,
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void checkTypeOfIssue(String id, String type) {
		mandatesPage().checkTypeOfIssue(id, type);
	}

	@Step
	public void checkTypeOfDeficiency(String id, String type) {
		mandatesPage().checkTypeOfDeficiency(id, type);
	}

	@Step
	public void selectItemFromMandateSection(String itemId) {
		abstractPage().selectItemFromMandateSection(itemId);
	}

	@Step
	public void selectPayment(String payment) {
		mandatesPage().selectPayment(payment);
	}

	@Step
	public void selectDirection(String direction) {
		mandatesPage().selectDirection(direction);
	}

	@Step
	public void inputDateOfTransaction(String days) {
		mandatesPage().inputDateOfTransaction(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void inputAmountFX(String amount) {
		mandatesPage().inputAmountFX(amount);
	}

	@Step
	public void inputRelationWithMandate(String relation) {
		mandatesPage().inputRelationWithMandate(relation);
	}

	@Step
	public void inputSenderOrRecipient(String text) {
		mandatesPage().inputSenderOrRecipient(text);
	}

	@Step
	public void selectOriginOfFunds(String country) {
		mandatesPage().selectOriginOfFunds(country);
	}

	@Step
	public void inputNameOfBank(String name) {
		mandatesPage().inputNameOfBank(name);
	}

	@Step
	public void inputPlausability(String plausability) {
		mandatesPage().inputPlausability(plausability);
	}

	@Step
	public void checkIfTransactionExists(String days) {
		Assert.assertTrue(
				"The transaction doesn't exist!",
				mandatesPage().checkItemByDate(
						DateUtils.toString(

						DateUtils.addDays(new Date(), Integer.parseInt(days)),
								"dd/MM/yyyy")));
	}

	@Step
	public void checkThatTransactionDoesntExists(String days) {
		Assert.assertFalse(
				"The transaction is present!",
				mandatesPage().checkItemByDate(
						DateUtils.toString(

						DateUtils.addDays(new Date(), Integer.parseInt(days)),
								"dd/MM/yyyy")));
	}

	@Step
	public void selectTransactionFromGrid(String days) {
		mandatesPage().selectTransactionFromGrid(DateUtils.toString(

		DateUtils.addDays(new Date(), Integer.parseInt(days)), "dd/MM/yyyy"));
	}

	@StepGroup
	public void checkTransactionInformation(String payment, String direction,
			String days, String currency, String amountFx, String amountEuro,
			String name, String relation, String country, String bank,
			String plausability) {
		abstractPage().switchToCreateIframe();
		mandatesPage().checkPayment(payment);
		mandatesPage().checkDirection(direction);
		mandatesPage().checkTransactionDate(DateUtils.toString(

		DateUtils.addDays(new Date(), Integer.parseInt(days)), "dd/MM/yyyy"));
		mandatesPage().checkCurrency(currency);
		mandatesPage().checkAmountFx(amountFx);
		mandatesPage().checkAmountInEuro(amountEuro);
		mandatesPage().checkSenderOrRecipient(name);
		mandatesPage().checkRelation(relation);
		mandatesPage().checkOriginOfFunds(country);
		mandatesPage().checkPlausability(plausability);
	}
}
