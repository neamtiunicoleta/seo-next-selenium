package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class MandatesPage extends AbstractPage {

	public MandatesPage(WebDriver driver) {
		super(driver);
	}

	public void selectMandateType(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfMandate']"))
				.click();
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[name*='TypeOfMandate'] option"));
		boolean foundOption = false;
		for (WebElement item : typesList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void selectServiceType(String... type) {
		List<WebElement> serviceTypeList = getDriver()
				.findElements(
						By.cssSelector("div#divMandateProfile >table:nth-of-type(1) > tbody > tr> td:first-child tbody tr td label"));
		for (WebElement serviceType : serviceTypeList) {
			for (String term : type) {
				if (serviceType.getText().contentEquals(term)) {
					serviceType.click();
					break;
				}
			}
		}
	}

	public void checkDescription(String id, String description) {
		checkTextFromField("td:nth-child(3)", id, description);
	}

	public void checkServiceType(String id, String type) {
		checkTextFromField("td:nth-child(4)", id, type);
	}

	public void inputOfficeFileNumber(String number) {
		WebElement officeFileNumberField = returnField("input",
				"OfficeFileNumber");
		element(officeFileNumberField).clear();
		element(officeFileNumberField).type(number);
	}

	public void inputFullName(String name) {
		WebElement fullNameField = returnField("input", "FullName");
		element(fullNameField).clear();
		element(fullNameField).type(name);
	}

	public void inputPOPBox(String pop) {
		WebElement popBox = returnField("input", "POBox");
		element(popBox).clear();
		element(popBox).type(pop);
	}

	public void inputAccountManager(String userName) {
		WebElement identificationMadeByField = getDriver()
				.findElement(
						By.cssSelector("input[id*='UserAccountManager_TopSpan_EditorInput']"));
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

	public void inputCompanyType(String type) {
		WebElement companyTypeField = returnField("input", "CompanyType");
		element(companyTypeField).clear();
		element(companyTypeField).type(type);
	}

	public void selectOffice(String offices) {
		getDriver().findElement(By.cssSelector("div[id*='Office']")).click();
		List<WebElement> officesList = getDriver().findElements(
				By.cssSelector("select[name*='Office'] option"));
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

	public void selectOfficeLink(String officeLink) {
		getDriver().findElement(By.cssSelector("tr[id*='OfficeLink']")).click();
		List<WebElement> officeLinkList = getDriver().findElements(
				By.cssSelector("select[name*='OfficeLink'] option"));
		boolean foundOption = false;

		for (WebElement item : officeLinkList) {
			if (item.getText().contentEquals(officeLink)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputPurpose(String purpose) {
		WebElement purposeField = returnField("textarea", "Purpose");
		element(purposeField).clear();
		element(purposeField).type(purpose);
	}

	public void inputAgreementDate(String date) {
		WebElement dateField = returnField("input", "AgreementDateDate");
		element(dateField).clear();
		element(dateField).type(date);
	}

	public void clickOnAddContact() {
		getDriver().findElement(By.cssSelector("div#contactsDiv a")).click();
	}

	public void inputContactUser(String userName) {
		WebElement contactField = getDriver().findElement(
				By.cssSelector("input[id*='UserContact_TopSpan_EditorInput']"));
		element(contactField).clear();
		element(contactField).type(userName);
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

	public void inputContactLabel(String label) {
		WebElement labelField = returnField("input", "ContactLabel");
		element(labelField).clear();
		element(labelField).type(label);
	}

	public void inputActualBusinessActivities(String activity) {
		WebElement activityField = returnField("textarea",
				"ActualBusinessActivities");
		element(activityField).clear();
		element(activityField).type(activity);
	}

	public void inputValuationOfTheLegalEntityAmount(String valuation) {
		WebElement valuationField = returnField("input",
				"ValuationOfTheLegalEntityAmount");
		element(valuationField).clear();
		element(valuationField).type(valuation);
	}

	public void inputYearlyTurnoverAmount(String amount) {
		WebElement turnoverAmountField = returnField("input",
				"YearlyTurnoverAmount");
		element(turnoverAmountField).clear();
		element(turnoverAmountField).type(amount);
	}

	public void inputYearlyNetProfitAmount(String amount) {
		WebElement profitAmountField = returnField("input",
				"YearlyNetProfitAmount");
		element(profitAmountField).clear();
		element(profitAmountField).type(amount);
	}

	public void selectValuationOfTheLegalEntityCurrency(String currency) {
		getDriver().findElement(
				By.cssSelector("div[id*='ValuationOfTheLegalEntityCurrency']"))
				.click();
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='ddlValuationOfTheLegalEntityCurrency'] option"));
		boolean foundOption = false;

		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectYearlyTurnoverCurrency(String currency) {
		getDriver().findElement(
				By.cssSelector("div[id*='ddlYearlyTurnoverCurrency']")).click();
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='ddlYearlyTurnoverCurrency'] option"));
		boolean foundOption = false;

		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectYearlyNetProfitCurrency(String currency) {
		getDriver().findElement(
				By.cssSelector("div[id*='ddlYearlyNetProfitCurrency']"))
				.click();
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='ddlYearlyNetProfitCurrency'] option"));
		boolean foundOption = false;

		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputNumberOfStaff(String number) {
		WebElement staffField = returnField("input", "NumberOfStaff");
		element(staffField).clear();
		element(staffField).type(number);
	}

	public void inputBusinessActivitiesComments(String comment) {
		WebElement commentField = returnField("textarea",
				"BusinessActivitiesComments");
		element(commentField).clear();
		element(commentField).type(comment);
	}

	public void inputFinancialYear(String year) {
		WebElement yearField = returnField("input", "FinancialYear");
		element(yearField).clear();
		element(yearField).type(year);
	}

	public void inputCorporateCapitalAmount(String amount) {
		WebElement capitalAmountField = returnField("input",
				"CorporateCapitalAmount");
		element(capitalAmountField).clear();
		element(capitalAmountField).type(amount);
	}

	public void selectCorporateCapitalCurrency(String currency) {
		getDriver().findElement(
				By.cssSelector("div[id*='ddlCorporateCapitalCurrency']"))
				.click();
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='ddlCorporateCapitalCurrency'] option"));
		boolean foundOption = false;

		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputAuditor(String auditor) {
		WebElement auditorField = returnField("input", "Auditor");
		element(auditorField).clear();
		element(auditorField).type(auditor);
	}

	public void clickOnAddBankableAsset() {
		getDriver().findElement(By.cssSelector("div#bankableAssetsDiv a"))
				.click();
	}

	public void inputBankOfOrigin(String bank) {
		WebElement bankField = returnField("input", "BankOfOrigin");
		element(bankField).clear();
		element(bankField).type(bank);
	}

	public void inputAproxAmount(String amount) {
		WebElement amountField = returnField("input", "AproxAmount");
		element(amountField).clear();
		element(amountField).type(amount);
	}

	public void selectAproxAmountCurrency(String currency) {
		getDriver().findElement(
				By.cssSelector("div[id*='ddlAproxAmountCurrency']")).click();
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='ddlAproxAmountCurrency'] option"));
		boolean foundOption = false;

		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void clickOnAddParticipation() {
		getDriver().findElement(By.cssSelector("div#divParticipations a"))
				.click();
	}

	public void inputName(String name) {
		WebElement nameField = returnField("input", "txtName");
		element(nameField).clear();
		element(nameField).type(name);
	}

	public void inputEstimatedValue(String value) {
		WebElement valueField = returnField("input", "EstimatedValue");
		element(valueField).clear();
		element(valueField).type(value);
	}

	public void selectCurrency(String currency) {
		getDriver().findElement(By.cssSelector("div[id*='ddlCurrency']"))
				.click();
		List<WebElement> currenciesList = getDriver().findElements(
				By.cssSelector("select[name*='ddlCurrency'] option"));
		boolean foundOption = false;

		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputActivity(String activity) {
		WebElement activityField = returnField("input", "Activity");
		element(activityField).clear();
		element(activityField).type(activity);
	}

	public void inputPercentage(String percentage) {
		WebElement percentageField = returnField("input", "Percentage");
		element(percentageField).clear();
		element(percentageField).type(percentage);
	}

	public void inputComments(String comment) {
		WebElement commentsField = returnField("textarea", "txtPartComments");
		element(commentsField).clear();
		element(commentsField).type(comment);
	}

	public void clickOnAddRealEstate() {
		getDriver().findElement(By.cssSelector("div#divRealEstates a")).click();
	}

	public void inputDescription(String description) {
		WebElement descriptionField = returnField("input", "Description");
		element(descriptionField).clear();
		element(descriptionField).type(description);
	}

	public void clickOnAddOtherInformation() {
		getDriver().findElement(
				By.cssSelector("div#divOtherMandateInformation a")).click();
	}

	public void inputPlace(String place) {
		WebElement placeField = returnField("input", "txtPlace");
		element(placeField).clear();
		element(placeField).type(place);
	}

	public void inputTypeOfTransaction(String type) {
		WebElement typeOfTransactionField = returnField("input",
				"TypeOfTransactions");
		element(typeOfTransactionField).clear();
		element(typeOfTransactionField).type(type);
	}

	public void selectDomicileOfCounterParties(String country) {
		getDriver().findElement(
				By.cssSelector("div[id*='ddlDomicileOfCounterParties']"))
				.click();
		List<WebElement> countriesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='ddlDomicileOfCounterParties'] option"));
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

	public void inputTransactionComments(String comment) {
		WebElement transactionCommentsField = returnField("textarea",
				"TransactionsComments");
		element(transactionCommentsField).clear();
		element(transactionCommentsField).type(comment);
	}

	public void clickOnFFICheckbox() {
		getDriver().findElement(By.cssSelector("input[id*='cbxFFI']")).click();
	}

	public void clickOnNFFICheckbox() {
		getDriver().findElement(By.cssSelector("input[id*='cbxNFFI']")).click();
	}

	public void inputTINNumber(String number) {
		WebElement tinNumberField = returnField("input", "TINNumber");
		element(tinNumberField).clear();
		element(tinNumberField).type(number);
	}

	public void inputRegistrationDate(String date) {
		WebElement dateField = returnField("input", "RegistrationDateDate");
		element(dateField).clear();
		element(dateField).type(date);
	}
}
