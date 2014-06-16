package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class ClientsPage extends AbstractPage {

	public ClientsPage(WebDriver driver) {
		super(driver);
	}

	public void selectProfileType(String profile) {
		getDriver().findElement(
				By.cssSelector("div[id*='ddlClientProfileType']")).click();
		List<WebElement> profileTypeList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;
		for (WebElement type : profileTypeList) {
			if (type.getText().contains(profile)) {
				foundOption = true;
				type.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);
	}

	public void selectOffice(String offices) {
		getDriver().findElement(By.cssSelector("div[id*='cbxOffices']"))
				.click();
		List<WebElement> officesList = getDriver().findElements(
				By.cssSelector("select[id*='cbxOffices'] option"));
		boolean foundOption = false;

		for (WebElement item : officesList) {
			if (item.getText().contentEquals(offices)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectCountriesOfDomicile(String country) {
		getDriver().findElement(
				By.cssSelector("div[id*='CountriesOfDomicile']")).click();
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("select[name*='CountriesOfDomicile'] option"));
		boolean foundOption = false;

		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectNationality(String nationality) {
		getDriver().findElement(By.cssSelector("div[id*='Nationalities']"))
				.click();
		List<WebElement> nationalitiesList = getDriver().findElements(
				By.cssSelector("select[name*='Nationalities'] option"));
		boolean foundOption = false;

		for (WebElement item : nationalitiesList) {
			if (item.getText().contentEquals(nationality)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputFamilyName(String name) {
		WebElement familyNameField = getDriver().findElement(
				By.cssSelector("input[name*='FamilyName']"));
		element(familyNameField).clear();
		element(familyNameField).type(name);
	}

	public void inputFirstName(String name) {
		WebElement firstNameField = getDriver().findElement(
				By.cssSelector("input[name*='FirstNames']"));
		element(firstNameField).clear();
		element(firstNameField).type(name);
	}

	public void inputAdditionalName(String name) {
		WebElement additionalNameField = getDriver().findElement(
				By.cssSelector("input[name*='AdditionalNames']"));
		element(additionalNameField).clear();
		element(additionalNameField).type(name);
	}

	public void inputNicknameOrAbbreviation(String name) {
		WebElement nicknameField = getDriver().findElement(
				By.cssSelector("input[name*='Nickname']"));
		element(nicknameField).clear();
		element(nicknameField).type(name);
	}

	public void inputAlternativeSpelling(String spelling) {
		WebElement alternativeSpellingField = getDriver().findElement(
				By.cssSelector("input[name*='AlternativeSpellings']"));
		element(alternativeSpellingField).clear();
		element(alternativeSpellingField).type(spelling);
	}

	public void inputPlaceOfBirth(String place) {
		WebElement placeOfBirthField = getDriver().findElement(
				By.cssSelector("input[name*='BirthPlace']"));
		element(placeOfBirthField).clear();
		element(placeOfBirthField).type(place);
	}

	public void inputDateOfBirthOrIncorporation(String date) {
		WebElement dateOfBirthField = getDriver().findElement(
				By.cssSelector("input[name*='DateOfBirthDate']"));
		element(dateOfBirthField).clear();
		element(dateOfBirthField).type(date);
	}

	public void inputStreet(String street) {
		WebElement streetField = getDriver().findElement(
				By.cssSelector("input[name*='StreetNumber']"));
		element(streetField).clear();
		element(streetField).type(street);
	}

	public void inputZIP(String zip) {
		WebElement ZIPField = getDriver().findElement(
				By.cssSelector("input[name*='ZIP']"));
		element(ZIPField).clear();
		element(ZIPField).type(zip);
	}

	public void inputCity(String city) {
		WebElement cityField = getDriver().findElement(
				By.cssSelector("input[name*='City']"));
		element(cityField).clear();
		element(cityField).type(city);
	}

	public void inputAdditionalStreet(String street) {
		WebElement streetField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='additionalAddressRow'] input[name*='StreetNumber']"));
		element(streetField).clear();
		element(streetField).type(street);
	}

	public void inputAdditionalZIP(String zip) {
		WebElement ZIPField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='additionalAddressRow'] input[name*='ZIP']"));
		element(ZIPField).clear();
		element(ZIPField).type(zip);
	}

	public void inputAdditionalCity(String city) {
		WebElement cityField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='additionalAddressRow'] input[name*='City']"));
		element(cityField).clear();
		element(cityField).type(city);
	}

	public void inputPhone(String phone) {
		WebElement phoneNumberField = getDriver().findElement(
				By.cssSelector("input[name*='PhoneNumber']"));
		element(phoneNumberField).clear();
		element(phoneNumberField).type(phone);
	}

	public void inputEmail(String email) {
		WebElement emailField = getDriver().findElement(
				By.cssSelector("input[name*='EmailAddress']"));
		element(emailField).clear();
		element(emailField).type(email);
	}

	public void clickOnUSPerson() {
		WebElement usPersonCheckbox = getDriver().findElement(
				By.cssSelector("input[name*='USPerson']"));
		element(usPersonCheckbox).click();
	}

	public void inputRemarks(String remarks) {
		WebElement remarksField = getDriver().findElement(
				By.cssSelector("input[name*='Remarks']"));
		element(remarksField).clear();
		element(remarksField).type(remarks);
	}

	public void clickOnHighRisk() {
		WebElement highRiskCheckbox = getDriver().findElement(
				By.cssSelector("input[name*='HighRisk']"));
		element(highRiskCheckbox).click();
	}

	public void clickOnPEP() {
		WebElement politicalActivitiesCheckbox = getDriver().findElement(
				By.cssSelector("input[name*='PoliticalActivities']"));
		element(politicalActivitiesCheckbox).click();
	}

	public void inputPepDetails(String details) {
		WebElement pepDetailsField = getDriver().findElement(
				By.cssSelector("input[name*='HighRiskPepDetails']"));
		element(pepDetailsField).clear();
		element(pepDetailsField).type(details);
	}

	public void inputClientComments(String comment) {
		WebElement clientProfileCommentsField = getDriver().findElement(
				By.cssSelector("textarea[name*='ClientProfileComments']"));
		element(clientProfileCommentsField).clear();
		element(clientProfileCommentsField).type(comment);
	}

	public void selectEmploymentState(String state) {
		getDriver()
				.findElement(By.cssSelector("div[id*='ddlEmploymentState']"))
				.click();
		List<WebElement> statesList = getDriver().findElements(
				By.cssSelector("select[id*='ddlEmploymentState'] option"));
		boolean foundOption = false;
		for (WebElement item : statesList) {
			if (item.getText().equals(state)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The state was not found!", foundOption);

	}

	public void inputProfessionalActivity(String activity) {
		WebElement professionalActivityField = getDriver().findElement(
				By.cssSelector("input[name*='ProfessionalActivity']"));
		element(professionalActivityField).clear();
		element(professionalActivityField).type(activity);
	}

	public void inputActualFunction(String function) {
		WebElement actualFunctionField = getDriver().findElement(
				By.cssSelector("input[name*='EmployedFunction']"));
		element(actualFunctionField).clear();
		element(actualFunctionField).type(function);
	}

	public void inputNameOfEmployer(String name) {
		WebElement nameOfEmployerField = getDriver().findElement(
				By.cssSelector("input[name*='EmployedEmployeer']"));
		element(nameOfEmployerField).clear();
		element(nameOfEmployerField).type(name);
	}

	public void selectAnualIncome(String income) {
		getDriver().findElement(By.cssSelector("div[id*='AnnualIncome']"))
				.click();
		List<WebElement> incomeList = getDriver().findElements(
				By.cssSelector("select[id*='AnnualIncome'] option"));
		boolean foundOption = false;
		for (WebElement item : incomeList) {
			if (item.getText().equals(income)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void selectEstimatedWealth(String wealth) {
		getDriver().findElement(By.cssSelector("div[id*='EstimatedWealth']"))
				.click();
		List<WebElement> wealthList = getDriver().findElements(
				By.cssSelector("select[id*='EstimatedWealth'] option"));
		boolean foundOption = false;
		for (WebElement item : wealthList) {
			if (item.getText().equals(wealth)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputSourceOfWealth(String source) {
		WebElement sourceOfWealthField = getDriver().findElement(
				By.cssSelector("input[name*='SourceOfWealth']"));
		element(sourceOfWealthField).clear();
		element(sourceOfWealthField).type(source);
	}

	public void selectMaritalStatus(String status) {
		getDriver().findElement(By.cssSelector("div[id*='MaritalStatus']"))
				.click();
		List<WebElement> statusList = getDriver().findElements(
				By.cssSelector("select[id*='MaritalStatus'] option"));
		boolean foundOption = false;
		for (WebElement item : statusList) {
			if (item.getText().equals(status)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputIdentificationMadeBy(String userName) {
		WebElement identificationMadeByField = getDriver().findElement(
				By.cssSelector("input[id*='EditorInput']"));
		element(identificationMadeByField).clear();
		element(identificationMadeByField).type(userName);
		List<WebElement> usersList = getDriver().findElements(
				By.cssSelector("div[id*='AutoFillDiv'] ul li"));

		boolean foundOption = false;
		for (WebElement item : usersList) {
			if (item.getText().contentEquals(userName)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);
	}

	public void selectTypeOfID(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfID']")).click();
		List<WebElement> typeList = getDriver().findElements(
				By.cssSelector("select[id*='TypeOfID'] option"));
		boolean foundOption = false;
		for (WebElement item : typeList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputPassportNumber(String number) {
		WebElement passportNumberField = getDriver().findElement(
				By.cssSelector("input[name*='PassportNumber']"));
		element(passportNumberField).clear();
		element(passportNumberField).type(number);
	}

	public void selectTypeOfProcedure(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfIDProcedure']"))
				.click();
		List<WebElement> typeList = getDriver().findElements(
				By.cssSelector("select[id*='TypeOfIDProcedure'] option"));
		boolean foundOption = false;
		for (WebElement item : typeList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputIdentificationDate(String date) {
		WebElement dateField = getDriver().findElement(
				By.cssSelector("input[name*='IdentificationDateDate']"));
		element(dateField).clear();
		element(dateField).type(date);
	}

	public void selectTypeOfCopy(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfCopy']"))
				.click();
		List<WebElement> typeList = getDriver().findElements(
				By.cssSelector("select[id*='TypeOfCopy'] option"));
		boolean foundOption = false;
		for (WebElement item : typeList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputIDValidUntil(String date) {
		WebElement idValidUntilField = getDriver().findElement(
				By.cssSelector("input[name*='IDValidUntilDate']"));
		element(idValidUntilField).clear();
		element(idValidUntilField).type(date);
	}

	public void selectLocationOfID(String location) {
		getDriver().findElement(
				By.cssSelector("div[id*='LocationOfOriginalID']")).click();
		List<WebElement> locationsList = getDriver().findElements(
				By.cssSelector("select[id*='LocationOfOriginalID'] option"));
		boolean foundOption = false;
		for (WebElement item : locationsList) {
			if (item.getText().equals(location)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void selectTypeOfShareholding(String type) {
		getDriver()
				.findElement(By.cssSelector("div[id*='TypeOfShareHolding']"))
				.click();
		List<WebElement> typeList = getDriver().findElements(
				By.cssSelector("select[id*='TypeOfShareHolding'] option"));
		boolean foundOption = false;
		for (WebElement item : typeList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void selectListedIn(String country) {
		getDriver().findElement(By.cssSelector("div[id*='ListedIn']")).click();
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("select[id*='ListedIn'] option"));
		boolean foundOption = false;
		for (WebElement item : countriesList) {
			if (item.getText().equals(country)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void selectBusinessCode(String code) {
		getDriver().findElement(By.cssSelector("div[id*='BusinessCode']"))
				.click();
		List<WebElement> codesList = getDriver().findElements(
				By.cssSelector("select[id*='BusinessCode'] option"));
		boolean foundOption = false;
		for (WebElement item : codesList) {
			if (item.getText().equals(code)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputActualBusinessActivities(String activity) {
		WebElement actualBusinessActivityField = getDriver().findElement(
				By.cssSelector("textarea[name*='ActualBusinessActivities']"));
		element(actualBusinessActivityField).clear();
		element(actualBusinessActivityField).type(activity);
	}

	public void inputComments(String comment) {
		WebElement commentsField = getDriver().findElement(
				By.cssSelector("textarea[name*='txtComments']"));
		element(commentsField).clear();
		element(commentsField).type(comment);

	}

	public void inputOther(String comment) {
		WebElement otherField = getDriver().findElement(
				By.cssSelector("textarea[name*='Other']"));
		element(otherField).clear();
		element(otherField).type(comment);
	}

	public boolean checkIfClientExists(String terms) {
		List<WebElement> clientsList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridView'] table.ms-listviewtable > tbody > tr td:first-child"));
		for (WebElement item : clientsList) {
			if (item.getText().contains(terms)) {
				return true;

			}
		}
		return false;

	}

	public void checkClientProfileType(String profile) {
		List<WebElement> profileTypeList = getDriver().findElements(
				By.cssSelector("tr[id*='trClientProfileType'] select option"));
		for (WebElement item : profileTypeList) {
			if (item.getText().contentEquals(profile)) {

				Assert.assertTrue("Type is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkOffice(String office) {
		List<WebElement> officeList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='InputformsectionOfficesTR'] select option"));
		for (WebElement item : officeList) {
			if (item.getText().contentEquals(office)) {

				Assert.assertTrue("Office is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkFamilyName(String name) {
		String familyName = getDriver().findElement(
				By.cssSelector("tr[id*='FamilyName'] input")).getAttribute(
				"value");
		Assert.assertTrue("Family name is not correct",
				familyName.contentEquals(name));
	}

	public void checkFirstName(String name) {
		String firstName = getDriver().findElement(
				By.cssSelector("tr[id*='FirstNames'] input")).getAttribute(
				"value");
		Assert.assertTrue("First name is not correct",
				firstName.contentEquals(name));
	}

	public void checkAdditionalName(String name) {
		String additionalName = getDriver().findElement(
				By.cssSelector("tr[id*='AdditionalNames'] input"))
				.getAttribute("value");
		Assert.assertTrue("Additional name is not correct",
				additionalName.contentEquals(name));
	}

	public void checkNickName(String name) {
		String additionalName = getDriver().findElement(
				By.cssSelector("tr[id*='Nickname'] input")).getAttribute(
				"value");
		Assert.assertTrue("Nickname is not correct",
				additionalName.contentEquals(name));
	}

	public void checkAlternativeSpelling(String name) {
		String alternativeSpelling = getDriver().findElement(
				By.cssSelector("tr[id*='AlternativeSpellings'] input"))
				.getAttribute("value");
		Assert.assertTrue("Alternative spelling is not correct",
				alternativeSpelling.contentEquals(name));
	}

	public void checkStreet(String street) {
		String streetField = getDriver().findElement(
				By.cssSelector("tr[id*='Tr1'] tbody tr:first-child input"))
				.getAttribute("value");
		Assert.assertTrue("Street is not correct",
				streetField.contentEquals(street));
	}

	public void checkZip(String zip) {
		String zipField = getDriver().findElement(
				By.cssSelector("tr[id*='Tr1'] tbody tr:nth-child(2) input"))
				.getAttribute("value");
		Assert.assertTrue("ZIP is not correct", zipField.contentEquals(zip));
	}

	public void checkCity(String city) {
		String cityField = getDriver().findElement(
				By.cssSelector("tr[id*='Tr1'] tbody tr:nth-child(3) input"))
				.getAttribute("value");
		Assert.assertTrue("City is not correct", cityField.contentEquals(city));
	}

	public void checkAdditionalStreet(String street) {
		String streetField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='additionalAddressRow'] tbody tr:first-child input"))
				.getAttribute("value");
		Assert.assertTrue("Street is not correct",
				streetField.contentEquals(street));
	}

	public void checkAdditionalZip(String zip) {
		String zipField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='additionalAddressRow'] tbody tr:nth-child(2) input"))
				.getAttribute("value");
		Assert.assertTrue("ZIP is not correct", zipField.contentEquals(zip));
	}

	public void checkAdditionalCity(String city) {
		String cityField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='additionalAddressRow'] tbody tr:nth-child(3) input"))
				.getAttribute("value");
		Assert.assertTrue("City is not correct", cityField.contentEquals(city));
	}

	public void checkCountry(String country) {
		List<WebElement> countriesList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='Tr1'] tbody tr:nth-child(4) select option"));
		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {

				Assert.assertTrue("Country is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkPlaceOfBirth(String place) {
		String placeOfBirth = getDriver().findElement(
				By.cssSelector("tr[id*='BirthPlaceTR'] input")).getAttribute(
				"value");
		Assert.assertTrue("Place of birth is not correct",
				placeOfBirth.contentEquals(place));
	}

	public void checkDateOfBirthOrIncorporation(String date) {
		String dateOfBirth = getDriver().findElement(
				By.cssSelector("tr[id*='DateOfBirthTR'] input")).getAttribute(
				"value");
		Assert.assertTrue("Date of birth is not correct",
				dateOfBirth.contentEquals(date));
	}

	public void checkCountryOfDomicile(String country) {
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("tr[id*='CountriesOfDomicileTR'] li div"));
		boolean foundItem = false;
		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {
				foundItem = true;
				break;
			}
		}
		Assert.assertTrue("Country is not correct", foundItem);
	}

	public void checkNationality(String nationality) {
		List<WebElement> nationalitiesList = getDriver().findElements(
				By.cssSelector("tr[id*='NationalitiesTR'] li div"));
		boolean foundItem = false;
		for (WebElement item : nationalitiesList) {
			if (item.getText().contentEquals(nationality)) {
				foundItem = true;
				break;
			}
		}
		Assert.assertTrue("nationality is not correct", foundItem);
	}

	public void checkPhoneNumber(String phone) {
		String phoneNumber = getDriver().findElement(
				By.cssSelector("tr[id*='honeNumberTR'] input")).getAttribute(
				"value");
		Assert.assertTrue("Phone number is not correct",
				phoneNumber.contentEquals(phone));
	}

	public void checkEmail(String email) {
		String emailAddress = getDriver().findElement(
				By.cssSelector("tr[id*='EmailAddressTR'] input")).getAttribute(
				"value");
		Assert.assertTrue("Email is not correct",
				emailAddress.contentEquals(email));
	}

	public void checkRemarks(String remarks) {
		String remarksField = getDriver().findElement(
				By.cssSelector("tr[id*='RemarksTR'] input")).getAttribute(
				"value");
		Assert.assertTrue("Remarks are not correct",
				remarksField.contentEquals(remarks));
	}

	public void checkIfHighRiskIsChecked() {
		WebElement highRisk = getDriver().findElement(
				By.cssSelector("tr[id*='HighRiskTR'] input"));
		Assert.assertTrue("High risk is not checked",
				isAttributePresent(highRisk, "checked"));
	}

	public void checkIfPEPIsChecked() {
		WebElement pep = getDriver().findElement(
				By.cssSelector("tr[id*='PoliticalActivitiesTR'] input"));
		Assert.assertTrue("Political Activities is not checked",
				isAttributePresent(pep, "checked"));
	}

	public void checkClientComments(String comment) {
		String commentField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='InputformsectionClientProfileCommentsTR'] textarea"))
				.getText();
		Assert.assertTrue("Client comments are not correct",
				commentField.contains(comment));
	}

	public void checkIdentificationMadeBy(String user) {
		WebElement indentificationMadeByField = getDriver().findElement(
				By.cssSelector("span[id*='UserDisplay']"));
		Assert.assertTrue("Client comments are not correct",
				indentificationMadeByField.getText().contentEquals(user));
	}

	public void checkTypeOfId(String type) {
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("tr[id*='TypeOfIDTR'] select option"));
		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {

				Assert.assertTrue("Type of ID is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkPassportNumber(String number) {
		String passportNumber = getDriver().findElement(
				By.cssSelector("tr[id*='PassportNumberTR'] input"))
				.getAttribute("value");
		Assert.assertTrue("Passport Number is not correct",
				passportNumber.contentEquals(number));
	}

	public void checkTypeOfProcedure(String type) {
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("tr[id*='TypeOfIDProcedureTR'] select option"));
		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {

				Assert.assertTrue("Type of procedure is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkDate(String date) {
		String identificationDate = getDriver().findElement(
				By.cssSelector("tr[id*='IdentificationDateTR'] input"))
				.getAttribute("value");
		Assert.assertTrue("Passport Number is not correct",
				identificationDate.contentEquals(date));
	}

	public void checkTypeOfCopy(String type) {
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("tr[id*='TypeOfCopyTR'] select option"));
		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {

				Assert.assertTrue("Type of copy is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkIdValidUntil(String date) {
		String idValidUntilField = getDriver().findElement(
				By.cssSelector("tr[id*='IDValidUntilTR'] input")).getAttribute(
				"value");
		Assert.assertTrue("Id Valid Until is not correct",
				idValidUntilField.contentEquals(date));
	}

	public void checkLocationOfOriginalId(String location) {
		List<WebElement> locationsList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='LocationOfOriginalIDTR'] select option"));
		for (WebElement item : locationsList) {
			if (item.getText().contentEquals(location)) {

				Assert.assertTrue("Location is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkEmploymentState(String state) {
		List<WebElement> statesList = getDriver().findElements(
				By.cssSelector("tr[id*='EmploymentStateTR'] select option"));
		for (WebElement item : statesList) {
			if (item.getText().contentEquals(state)) {

				Assert.assertTrue("Employment state is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkProfessionalActivity(String activity) {
		String professionalActivityField = getDriver().findElement(
				By.cssSelector("tr[id*='ProfessionalActivityTR'] input"))
				.getAttribute("value");
		Assert.assertTrue("Professional activity is not correct",
				professionalActivityField.contentEquals(activity));
	}

	public void checkActualFunction(String function) {
		String actualFunctionField = getDriver().findElement(
				By.cssSelector("tr[id*='EmployedFunctionTR'] input"))
				.getAttribute("value");
		Assert.assertTrue("Actual function is not correct",
				actualFunctionField.contentEquals(function));
	}

	public void checkNameOfEmployer(String name) {
		String nameOfEMployerField = getDriver().findElement(
				By.cssSelector("tr[id*='EmployedEmployeerTR'] input"))
				.getAttribute("value");
		Assert.assertTrue("Actual function is not correct",
				nameOfEMployerField.contentEquals(name));
	}

	public void checkAnnualIncome(String income) {
		List<WebElement> incomesList = getDriver().findElements(
				By.cssSelector("tr[id*='AnnualIncomeTR'] select option"));
		for (WebElement item : incomesList) {
			if (item.getText().contentEquals(income)) {

				Assert.assertTrue("Annual income is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkEstimatedWealth(String wealth) {
		List<WebElement> wealthList = getDriver().findElements(
				By.cssSelector("tr[id*='EstimatedWealthTR'] select option"));
		for (WebElement item : wealthList) {
			if (item.getText().contentEquals(wealth)) {

				Assert.assertTrue("Estimated wealth is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkSourceOfWealth(String source) {
		String sourceOfWealthField = getDriver().findElement(
				By.cssSelector("tr[id*='SourceOfWealthTR'] input"))
				.getAttribute("value");
		Assert.assertTrue("Source of wealth is not correct",
				sourceOfWealthField.contentEquals(source));
	}

	public void checkMaritalStatus(String status) {
		List<WebElement> statusList = getDriver().findElements(
				By.cssSelector("tr[id*='MaritalStatusTR'] select option"));
		for (WebElement item : statusList) {
			if (item.getText().contentEquals(status)) {

				Assert.assertTrue("Marital status is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void changeProfileType(String profile) {
		getDriver().findElement(By.cssSelector("div[id*='ddlType']")).click();
		List<WebElement> profileTypeList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;
		for (WebElement type : profileTypeList) {
			if (type.getText().contains(profile)) {
				foundOption = true;
				type.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);
	}

	public void changeOffice(String office) {
		getDriver().findElement(By.cssSelector("div[id*='listOffices']"))
				.click();

		WebElement officeBox = getDriver().findElement(
				By.cssSelector("div[id*='listOffices'] input"));
		element(officeBox).type(office);
		List<WebElement> officesList = getDriver().findElements(
				By.cssSelector("select[id*='listOffices'] option"));
		boolean foundOption = false;

		for (WebElement item : officesList) {
			if (item.getText().contentEquals(office)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputActualSituation(String situation) {
		WebElement actualSituationField = returnField("textarea",
				"ActualSituation");
		element(actualSituationField).clear();
		element(actualSituationField).type(situation);
	}

	public void inputRiskForSituation(String risk) {
		WebElement riskField = returnField("input", "Risk");
		element(riskField).clear();
		element(riskField).type(risk);
	}

	public void inputResolution(String resolution) {
		WebElement resolutionField = returnField("textarea", "Resolution");
		element(resolutionField).clear();
		element(resolutionField).type(resolution);
	}

	public void checkRiskForSituation(String title, String risk) {
		checkTextFromGrid("td:nth-child(3)", title, risk);
	}

	public void checkResolution(String title, String resolution) {
		checkTextFromGrid("td:nth-child(4)", title, resolution);
	}

	public void checkTypeOfShareholding(String type) {
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("tr[id*='TypeOfShareHoldingTR'] select option"));
		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {

				Assert.assertTrue("Type of shareholding is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkListedIn(String country) {
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("tr[id*='ListedInTR'] select option"));
		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {

				Assert.assertTrue("Listed In is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkBusinessCodes(String code) {
		List<WebElement> codesList = getDriver().findElements(
				By.cssSelector("tr[id*='BusinessCodeTR'] select option"));
		for (WebElement item : codesList) {
			if (item.getText().contentEquals(code)) {

				Assert.assertTrue("Business Code is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkActualBusinessActivities(String activity) {
		String actualBusinessActivityField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='ActualBusinessActivitiesTR'] textarea"))
				.getText();
		Assert.assertTrue("Source of wealth is not correct",
				actualBusinessActivityField.contentEquals(activity));
	}

	public void checkComments(String activity) {
		String commentsField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='InputformsectionCommentsTR'] textarea"))
				.getText();
		Assert.assertTrue("Comments are not correct",
				commentsField.contentEquals(activity));
	}

	public void checkOther(String other) {
		String otherField = getDriver().findElement(
				By.cssSelector("tr[id*='OtherTR'] textarea")).getText();
		Assert.assertTrue("Source of wealth is not correct",
				otherField.contentEquals(other));
	}

}
