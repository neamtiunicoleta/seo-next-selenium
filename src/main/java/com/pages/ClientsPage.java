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

	public void selectOffice(String offices) {
		List<WebElement> officesList = getDriver().findElements(
				By.cssSelector("div[id*='divcbxOffices'] tr td"));
		boolean foundOption = false;

		for (WebElement item : officesList) {
			System.out.println("!!!!!!!!!!!!" + item.getText());
			if (item.getText().contentEquals(offices)) {
				foundOption = true;
				item.findElement(By.cssSelector("td input")).click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectCountriesOfDomicile(String country) {
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("div[id*='divCheckBoxDomicile'] tr td"));
		boolean foundOption = false;

		for (WebElement item : countriesList) {
			System.out.println("!!!!!!!!!!!!" + item.getText());
			if (item.getText().contentEquals(country)) {
				foundOption = true;
				item.findElement(By.cssSelector("td input")).click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectNationality(String nationality) {
		List<WebElement> nationalitiesList = getDriver().findElements(
				By.cssSelector("div[id*='divNationalities'] tr td"));
		boolean foundOption = false;

		for (WebElement item : nationalitiesList) {
			System.out.println("!!!!!!!!!!!!" + item.getText());
			if (item.getText().contentEquals(nationality)) {
				foundOption = true;
				item.findElement(By.cssSelector("td input")).click();
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

	public void inputNickname(String name) {
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

	public void inputDateOfBirth(String date) {
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
				By.cssSelector("input[name*='ClientProfileComments']"));
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
		element(sourceOfWealthField).click();
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
}
