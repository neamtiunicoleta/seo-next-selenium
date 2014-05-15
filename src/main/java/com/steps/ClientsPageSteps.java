package com.steps;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;
import com.tools.DateUtils;

public class ClientsPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public ClientsPageSteps(Pages pages) {
		super(pages);
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
	public void inputNickname(String name) {
		clientsPage().inputNickname(name);
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
	public void inputDateOfBirth(String date) {
		clientsPage().inputDateOfBirth(date);
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
}