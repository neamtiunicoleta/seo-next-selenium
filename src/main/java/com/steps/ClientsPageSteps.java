package com.steps;

import java.util.Date;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;
import com.tools.DateUtils;

public class ClientsPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public ClientsPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void selectProfileType(String profile) {
		clientsPage().selectProfileType(profile);
	}

	@Step
	public void selectOffice(String offices) {
		clientsPage().selectOffice(offices);
	}

	@Step
	public void inputFamilyName(String name) {
		clientsPage().inputFamilyName(name);
	}

	@Step
	public void inputFirstName(String name) {
		clientsPage().inputFirstName(name);
	}

	@Step
	public void inputAdditionalName(String name) {
		clientsPage().inputAdditionalName(name);
	}

	@Step
	public void inputNicknameOrAbbreviation(String name) {
		clientsPage().inputNicknameOrAbbreviation(name);
	}

	@Step
	public void inputAlternativeSpelling(String spelling) {
		clientsPage().inputAlternativeSpelling(spelling);
	}

	@Step
	public void inputPlaceOfBirth(String place) {
		clientsPage().inputPlaceOfBirth(place);
	}

	@Step
	public void inputDateOfBirthOrIncorporation(String date) {
		clientsPage().inputDateOfBirthOrIncorporation(date);
	}

	@Step
	public void inputStreet(String street) {
		clientsPage().inputStreet(street);
	}

	@Step
	public void inputZIP(String zip) {
		clientsPage().inputZIP(zip);
	}

	@Step
	public void inputCity(String city) {
		clientsPage().inputCity(city);
	}

	@Step
	public void inputAdditionalStreet(String street) {
		clientsPage().inputAdditionalStreet(street);
	}

	@Step
	public void inputAdditionalZIP(String zip) {
		clientsPage().inputAdditionalZIP(zip);
	}

	@Step
	public void inputAdditionalCity(String city) {
		clientsPage().inputAdditionalCity(city);
	}

	@Step
	public void selectCountryOfDomicile(String country) {
		clientsPage().selectCountriesOfDomicile(country);
	}

	@Step
	public void selectNationality(String nationality) {
		clientsPage().selectNationality(nationality);
	}

	@Step
	public void inputPhone(String phone) {
		clientsPage().inputPhone(phone);
	}

	@Step
	public void inputEmail(String email) {
		clientsPage().inputEmail(email);
	}

	@Step
	public void clickOnUSPerson() {
		clientsPage().clickOnUSPerson();
	}

	@Step
	public void inputRemarks(String remarks) {
		clientsPage().inputRemarks(remarks);
	}

	@Step
	public void clickOnHighRisk() {
		clientsPage().clickOnHighRisk();
	}

	@Step
	public void clickOnPEP() {
		clientsPage().clickOnPEP();
	}

	@Step
	public void inputPepDetails(String details) {
		clientsPage().inputPepDetails(details);
	}

	@Step
	public void inputClientComments(String comment) {
		clientsPage().inputClientComments(comment);
	}

	@Step
	public void selectEmploymentState(String state) {
		clientsPage().selectEmploymentState(state);
	}

	@Step
	public void inputProfessionalActivity(String activity) {
		clientsPage().inputProfessionalActivity(activity);
	}

	@Step
	public void inputActualFunction(String function) {
		clientsPage().inputActualFunction(function);
	}

	@Step
	public void inputNameOfEmployer(String name) {
		clientsPage().inputNameOfEmployer(name);
	}

	@Step
	public void selectAnualIncome(String income) {
		clientsPage().selectAnualIncome(income);
	}

	@Step
	public void selectEstimatedWealth(String wealth) {
		clientsPage().selectEstimatedWealth(wealth);
	}

	@Step
	public void inputSourceOfWealth(String source) {
		clientsPage().inputSourceOfWealth(source);
	}

	@Step
	public void selectMaritalStatus(String status) {
		clientsPage().selectMaritalStatus(status);
	}

	@Step
	public void inputIdentificationMadeBy(String userName) {
		clientsPage().inputIdentificationMadeBy(userName);
	}

	@Step
	public void selectTypeOfID(String type) {
		clientsPage().selectTypeOfID(type);
	}

	@Step
	public void inputPassportNumber(String number) {
		clientsPage().inputPassportNumber(number);
	}

	@Step
	public void selectTypeOfProcedure(String type) {
		clientsPage().selectTypeOfProcedure(type);
	}

	@Step
	public void inputIdentificationDate(String days) {
		clientsPage().inputIdentificationDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void selectTypeOfCopy(String type) {
		clientsPage().selectTypeOfCopy(type);
	}

	@Step
	public void inputIDValidUntil(String days) {
		clientsPage().inputIDValidUntil(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void selectLocationOfID(String location) {
		clientsPage().selectLocationOfID(location);
	}

	@Step
	public void selectTypeOfShareholding(String type) {
		clientsPage().selectTypeOfShareholding(type);
	}

	@Step
	public void selectListedIn(String country) {
		clientsPage().selectListedIn(country);
	}

	@Step
	public void selectBusinessCode(String code) {
		clientsPage().selectBusinessCode(code);
	}

	@Step
	public void inputActualBusinessActivities(String activity) {
		clientsPage().inputActualBusinessActivities(activity);
	}

	@Step
	public void inputComments(String comment) {
		clientsPage().inputComments(comment);
	}

	@Step
	public void inputOther(String comment) {
		clientsPage().inputOther(comment);
	}

	@StepGroup
	public void createBasicStandardIndividualClient(String office,
			String familyName, String firstName) {
		clientsPage().selectOffice(office);
		clientsPage().inputFamilyName(familyName);
		clientsPage().inputFirstName(firstName);
		abstractPage().selectActionFromRibbon("Save");
	}

	@StepGroup
	public void createBasicStandardLegalClient(String office, String entityName) {
		clientsPage().selectOffice(office);
		clientsPage().inputFamilyName(entityName);
		abstractPage().selectActionFromRibbon("Save");
	}

	@Step
	public void checkIfEntityExists(String name) {
		Assert.assertTrue("The client is not present", clientsPage()
				.checkIfEntityExists(name));
	}

	@Step
	public void checkThatEntityDoesntExists(String name) {
		Assert.assertFalse("The client is present", clientsPage()
				.checkIfEntityExists(name));
	}

	@Step
	public void checkClientProfileType(String profileType) {
		clientsPage().checkClientProfileType(profileType);
	}

	@Step
	public void checkOffice(String office) {
		clientsPage().checkOffice(office);
	}

	@StepGroup
	public void checkIndividualClientInformation(String profileType,
			String office, String familyName, String firstName,
			String additionalName, String nickName, String alternativeSpelling,
			String street, String zip, String city, String country,
			String additionalStreet, String additionalZip,
			String additionalCity, String birthPlace, String dateBirth,
			String domicileCountry, String nationality, String phone,
			String email, String remarks, String comments, String state,
			String activity, String function, String employer, String income,
			String wealth, String wealthSource, String maritalStatus,
			String user, String typeId, String passportNumber,
			String typeOfProcedure, String daysNr, String typeCopy,
			String daysValid, String location) {
		clientsPage().checkClientProfileType(profileType);
		clientsPage().checkOffice(office);
		clientsPage().checkFamilyName(familyName);
		clientsPage().checkFirstName(firstName);
		clientsPage().checkAdditionalName(additionalName);
		clientsPage().checkNickName(nickName);
		clientsPage().checkAlternativeSpelling(alternativeSpelling);
		clientsPage().checkStreet(street);
		clientsPage().checkZip(zip);
		clientsPage().checkCity(city);
		clientsPage().checkCountry(country);
		clientsPage().checkAdditionalStreet(additionalStreet);
		clientsPage().checkAdditionalZip(additionalZip);
		clientsPage().checkAdditionalCity(additionalCity);
		clientsPage().checkPlaceOfBirth(birthPlace);
		clientsPage().checkDateOfBirthOrIncorporation(
				DateUtils.toString(
						DateUtils.addDays(new Date(),
								Integer.parseInt(dateBirth)), "dd/MM/yyyy"));
		clientsPage().checkCountryOfDomicile(domicileCountry);
		clientsPage().checkNationality(nationality);
		clientsPage().checkPhoneNumber(phone);
		clientsPage().checkEmail(email);
		clientsPage().checkRemarks(remarks);
		clientsPage().checkIfHighRiskIsChecked();
		clientsPage().checkIfPEPIsChecked();
		clientsPage().checkClientComments(comments);
		abstractPage().clickOnTab("Private Background");
		clientsPage().checkEmploymentState(state);
		clientsPage().checkProfessionalActivity(activity);
		clientsPage().checkActualFunction(function);
		clientsPage().checkNameOfEmployer(employer);
		clientsPage().checkAnnualIncome(income);
		clientsPage().checkEstimatedWealth(wealth);
		clientsPage().checkSourceOfWealth(wealthSource);
		clientsPage().checkMaritalStatus(maritalStatus);
		abstractPage().clickOnTab("Identification");
		clientsPage().checkIdentificationMadeBy(user);
		clientsPage().checkTypeOfId(typeId);
		clientsPage().checkPassportNumber(passportNumber);
		clientsPage().checkTypeOfProcedure(typeOfProcedure);
		clientsPage()
				.checkDate(
						DateUtils.toString(
								DateUtils.addDays(new Date(),
										Integer.parseInt(daysNr)), "dd/MM/yyyy"));
		clientsPage().checkTypeOfCopy(typeCopy);
		clientsPage().checkIdValidUntil(
				DateUtils.toString(
						DateUtils.addDays(new Date(),
								Integer.parseInt(daysValid)), "dd/MM/yyyy"));
		clientsPage().checkLocationOfOriginalId(location);

	}

	@StepGroup
	public void checkLegalClientInformation(String profileType, String office,
			String entityName, String abbreviation, String typeOfShareholding,
			String listedIn, String street, String zip, String city,
			String country, String incorporationDate, String remarks,
			String clientComments, String businessCode, String activity,
			String comments, String user, String typeId, String daysNr,
			String other) {
		clientsPage().checkClientProfileType(profileType);
		clientsPage().checkOffice(office);
		clientsPage().checkFamilyName(entityName);
		clientsPage().checkNickName(abbreviation);
		clientsPage().checkTypeOfShareholding(typeOfShareholding);
		clientsPage().checkListedIn(listedIn);
		clientsPage().checkStreet(street);
		clientsPage().checkZip(zip);
		clientsPage().checkCity(city);
		clientsPage().checkCountry(country);
		clientsPage().checkDateOfBirthOrIncorporation(
				DateUtils.toString(
						DateUtils.addDays(new Date(),
								Integer.parseInt(incorporationDate)),
						"dd/MM/yyyy"));
		clientsPage().checkRemarks(remarks);
		clientsPage().checkIfHighRiskIsChecked();
		clientsPage().checkIfPEPIsChecked();
		clientsPage().checkClientComments(clientComments);

		abstractPage().clickOnTab("Business Activities");
		clientsPage().checkBusinessCodes(businessCode);
		clientsPage().checkActualBusinessActivities(activity);
		clientsPage().checkComments(comments);

		abstractPage().clickOnTab("Identification");
		clientsPage().checkIdentificationMadeBy(user);
		clientsPage().checkTypeOfId(typeId);
		clientsPage()
				.checkDate(
						DateUtils.toString(
								DateUtils.addDays(new Date(),
										Integer.parseInt(daysNr)), "dd/MM/yyyy"));
		clientsPage().checkOther(other);
	}

	@Step
	public void changeType(String type) {
		abstractPage().switchToCreateIframe();
		clientsPage().changeProfileType(type);
	}

	@Step
	public void changeOffice(String office) {
		abstractPage().switchToCreateIframe();
		clientsPage().changeOffice(office);
	}

	@Step
	public void inputActualSituation(String situation) {
		abstractPage().switchToCreateIframe();
		clientsPage().inputActualSituation(situation);
	}

	@Step
	public void inputRiskForSituation(String risk) {
		clientsPage().inputRiskForSituation(risk);
	}

	@Step
	public void inputResolution(String resolution) {
		clientsPage().inputResolution(resolution);
	}

	@Step
	public void checkRiskForSituation(String title, String risk) {
		clientsPage().checkRiskForSituation(title, risk);
	}

	@Step
	public void checkResolution(String title, String resolution) {
		clientsPage().checkResolution(title, resolution);
	}
}