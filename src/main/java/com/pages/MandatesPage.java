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
		waitABit(3000);
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
		waitABit(2000);
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
		waitABit(2000);
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
		waitABit(2000);
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
				By.cssSelector("div[id*='DomicileOfCounterParties']")).click();
		List<WebElement> countriesList = getDriver()
				.findElements(
						By.cssSelector("select[name*='DomicileOfCounterParties'] option"));
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

	public void checkServiceType(String... type) {
		List<WebElement> serviceTypeList = getDriver()
				.findElements(
						By.cssSelector("div#checkBoxListNAMLServicesDiv tbody > tr td"));
		for (WebElement serviceType : serviceTypeList) {
			for (String term : type) {
				WebElement serviceName = serviceType.findElement(By
						.cssSelector("label"));
				if (serviceName.getText().contentEquals(term)) {
					Assert.assertTrue(
							"The service is not checked",
							isAttributePresent(serviceType.findElement(By
									.cssSelector("input")), "checked"));
					break;
				}
			}
		}

	}

	public void checkThatServiceTypeIsNotChecked(String... type) {
		List<WebElement> serviceTypeList = getDriver()
				.findElements(
						By.cssSelector("div#checkBoxListNAMLServicesDiv tbody > tr td"));
		for (WebElement serviceType : serviceTypeList) {
			for (String term : type) {
				WebElement serviceName = serviceType.findElement(By
						.cssSelector("label"));
				if (serviceName.getText().contentEquals(term)) {
					Assert.assertFalse(
							"The service is not checked",
							isAttributePresent(serviceType.findElement(By
									.cssSelector("input")), "checked"));
					break;
				}
			}
		}

	}

	public void checkOfficeFileNumber(String fileNumber) {
		String officeFileNumber = getDriver().findElement(
				By.cssSelector("tr[id*='OfficeFileNumber'] input"))
				.getAttribute("value");
		Assert.assertTrue("Office file number is not correct",
				officeFileNumber.contentEquals(fileNumber));
	}

	public void checkFullName(String name) {
		String nameField = getDriver().findElement(
				By.cssSelector("tr[id*='Name'] input")).getAttribute("value");
		Assert.assertTrue("Full name is not correct",
				nameField.contentEquals(name));
	}

	public void checkStreet(String street) {
		String streetField = getDriver().findElement(
				By.cssSelector("div#divAddress tr:first-child input"))
				.getAttribute("value");
		Assert.assertTrue("Full name is not correct",
				streetField.contentEquals(street));
	}

	public void checkZipCode(String code) {
		String zipCodeField = getDriver().findElement(
				By.cssSelector("div#divAddress tr:nth-child(2) input"))
				.getAttribute("value");
		Assert.assertTrue("Zip Codeis not correct",
				zipCodeField.contentEquals(code));
	}

	public void checkCity(String city) {
		String cityField = getDriver().findElement(
				By.cssSelector("div#divAddress tr:nth-child(3) input"))
				.getAttribute("value");
		Assert.assertTrue("City is not correct", cityField.contentEquals(city));
	}

	public void checkCountry(String country) {
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("div#divAddress tr:nth-child(4) select option"));
		boolean selected = false;
		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {
				if (isAttributePresent(item, "selected"))
					selected = true;
				break;

			}
		}
		Assert.assertTrue("Country is not correct", selected);
	}

	public void checkPoBox(String poBox) {
		String poBoxField = getDriver().findElement(
				By.cssSelector("div#divAddress tr:nth-child(5) input"))
				.getAttribute("value");
		Assert.assertTrue("Po Box is not correct",
				poBoxField.contentEquals(poBox));
	}

	public void checkAccountManager(String name) {
		WebElement accountManagerField = getDriver()
				.findElement(
						By.cssSelector("span[id*='UserAccountManager'] > span:nth-child(2)"));
		Assert.assertTrue("Account Manager is not correct", accountManagerField
				.getText().contentEquals(name));
	}

	public void checkOfficeLink(String link) {
		List<WebElement> officeLinkList = getDriver().findElements(
				By.cssSelector("tr[id*='ddlOfficeLink'] select option"));
		for (WebElement item : officeLinkList) {
			if (item.getText().contentEquals(link)) {

				Assert.assertTrue("Office link is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkCompanyType(String type) {
		String companyTypeField = getDriver().findElement(
				By.cssSelector("tr[id*='CompanyType'] input")).getAttribute(
				"value");
		Assert.assertTrue("Company type is not correct",
				companyTypeField.contentEquals(type));
	}

	public void checkPurpose(String purpose) {
		String purposeField = getDriver().findElement(
				By.cssSelector("tr[id*='Purpose'] textarea")).getText();
		Assert.assertTrue("Purpose is not correct",
				purposeField.contentEquals(purpose));
	}

	public void checkAgreementDate(String date) {
		String agreementDate = getDriver().findElement(
				By.cssSelector("tr[id*='AgreementDate'] input")).getAttribute(
				"value");
		Assert.assertTrue("Agreement date is not correct",
				agreementDate.contentEquals(date));
	}

	public void checkIfContactIsPresent(String... key) {
		boolean foundContact = false;
		foundContact = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[id*='seoGridContacts'] > table > tbody > tr td[class*='title']"),
				true, false, key);
		Assert.assertTrue("The contact is not present", foundContact);
	}

	public void checkUserFromContacts(String label, String user) {
		List<WebElement> contactsList = getDriver().findElements(
				By.cssSelector("div[id*='seoGridContacts'] > table > tbody"));

		for (WebElement item : contactsList) {
			if (item.findElement(By.cssSelector("tr td[class*='title']"))
					.getText().contentEquals(label)) {
				WebElement contactUser = item.findElement(By
						.cssSelector("tr td:nth-child(3"));
				Assert.assertTrue("Contact User is not correct", contactUser
						.getText().contentEquals(user));

			}
		}
	}

	public void checkValuationOfTheLegalEntityAmount(String amount) {
		String valuationField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='ValuationOfTheLegalEntityAmount'] input"))
				.getAttribute("value");
		Assert.assertTrue(
				"Valuation of the legal entity amount is not correct",
				valuationField.contentEquals(amount));
	}

	public void checkValuationOfTheLegalEntityCurrency(String currency) {
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='ValuationOfTheLegalEntityCurrency'] select option"));
		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {

				Assert.assertTrue(
						"Valuation of the legal entity currency is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkYearlyTurnoverAmount(String amount) {
		String netProfitField = getDriver().findElement(
				By.cssSelector("tr[id*='YearlyTurnoverAmount'] input"))
				.getAttribute("value");
		Assert.assertTrue("Yearly turnover amount is not correct",
				netProfitField.contentEquals(amount));
	}

	public void checkYearlyTurnoverCurrency(String currency) {
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='YearlyTurnoverCurrency'] select option"));
		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {

				Assert.assertTrue("Yearly turnover currency is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkStaffNumber(String number) {
		String staffNumberField = getDriver().findElement(
				By.cssSelector("tr[id*='NumberOfStaff'] input")).getAttribute(
				"value");
		Assert.assertTrue("Number of staff is not correct",
				staffNumberField.contentEquals(number));
	}

	public void checkBusinessActivitiesComments(String comment) {
		String commentsField = getDriver()
				.findElement(
						By.cssSelector("tr[id*='BusinessActivitiesComments'] textarea"))
				.getText();
		Assert.assertTrue("Business Activities comments is not correct",
				commentsField.contentEquals(comment));
	}

	public void checkFinanciarYear(String year) {
		String financiarYearField = getDriver().findElement(
				By.cssSelector("tr[id*='FinancialYear'] input")).getAttribute(
				"value");
		Assert.assertTrue("Financiar year is not correct",
				financiarYearField.contentEquals(year));
	}

	public void checkCorporateCapitalAmount(String amount) {
		String corporateCapitalField = getDriver().findElement(
				By.cssSelector("tr[id*='CorporateCapitalAmount'] input"))
				.getAttribute("value");
		Assert.assertTrue("Corporate Capital Amount is not correct",
				corporateCapitalField.contentEquals(amount));
	}

	public void checkCorporateCapitalCurrency(String currency) {
		List<WebElement> currenciesList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='CorporateCapitalCurrency'] select option"));
		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {

				Assert.assertTrue("Corporate Capital currency is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkAuditor(String auditor) {
		String auditorField = getDriver().findElement(
				By.cssSelector("tr[id*='Auditor'] input"))
				.getAttribute("value");
		Assert.assertTrue("Corporate Capital Amount is not correct",
				auditorField.contentEquals(auditor));
	}

	public void checkIfBankableAssetIsPresent(String... key) {
		boolean foundAsset = false;
		foundAsset = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[id*='seoGridBankableAssets'] > table > tbody > tr td[class*='title']"),
				true, false, key);
		Assert.assertTrue("The bankable asset is not present", foundAsset);
	}

	public void checkInformationFromBankableAssets(String bank, String amount,
			String currency, String comments) {
		List<WebElement> assetsList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridBankableAssets'] > table > tbody"));

		for (WebElement item : assetsList) {
			if (item.findElement(By.cssSelector("tr td[class*='title']"))
					.getText().contentEquals(bank)) {
				WebElement assetAmount = item.findElement(By
						.cssSelector("tr td:nth-child(3)"));
				WebElement assetCurrency = item.findElement(By
						.cssSelector("tr td:nth-child(4)"));
				WebElement assetComments = item.findElement(By
						.cssSelector("tr td:nth-child(5)"));

				Assert.assertTrue("Bankable Asset Amount is not correct",
						assetAmount.getText().contentEquals(amount));
				Assert.assertTrue("Bankable Assets Currency is not correct",
						assetCurrency.getText().contentEquals(currency));
				Assert.assertTrue("Bankable Asset Comments is not correct",
						assetComments.getText().contentEquals(comments));

			}
		}
	}

	public void checkIfParticipationIsPresent(String... key) {
		boolean foundParticipation = false;
		foundParticipation = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[id*='seoGridParticipations'] > table > tbody > tr td[class*='title']"),
				true, false, key);
		Assert.assertTrue("The participation is not present",
				foundParticipation);
	}

	public void checkInformationFromParticipation(String name, String value,
			String currency, String activity, String percentage,
			String comments, String country) {
		List<WebElement> participationList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridParticipations'] > table > tbody"));

		for (WebElement item : participationList) {
			if (item.findElement(By.cssSelector("tr td[class*='title']"))
					.getText().contentEquals(name)) {
				WebElement participationValue = item.findElement(By
						.cssSelector("tr td:nth-child(3)"));
				WebElement participationCurrency = item.findElement(By
						.cssSelector("tr td:nth-child(4)"));
				WebElement participationActivity = item.findElement(By
						.cssSelector("tr td:nth-child(5)"));
				WebElement participationPercentage = item.findElement(By
						.cssSelector("tr td:nth-child(6)"));
				WebElement participationComments = item.findElement(By
						.cssSelector("tr td:nth-child(7)"));
				WebElement participationCountry = item.findElement(By
						.cssSelector("tr td:nth-child(8)"));

				Assert.assertTrue("Participation Value is not correct",
						participationValue.getText().contentEquals(value));
				Assert.assertTrue("Participation Currency is not correct",
						participationCurrency.getText().contentEquals(currency));
				Assert.assertTrue("Participation Activity is not correct",
						participationActivity.getText().contentEquals(activity));
				Assert.assertTrue(
						"Participation Percentage is not correct",
						participationPercentage.getText().contentEquals(
								percentage));
				Assert.assertTrue("Participation Comments is not correct",
						participationComments.getText().contentEquals(comments));
				Assert.assertTrue("Participation Country is not correct",
						participationCountry.getText().contentEquals(country));

			}
		}
	}

	public void checkIfRealEstateIsPresent(String... key) {
		boolean foundEstate = false;
		foundEstate = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[id*='seoGridRealEstates'] > table > tbody > tr td[class*='title']"),
				true, false, key);
		Assert.assertTrue("The real estate is not present", foundEstate);
	}

	public void checkInformationFromRealEstate(String description,
			String value, String currency, String comments, String country) {
		List<WebElement> realEstatesList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridRealEstates'] > table > tbody"));

		for (WebElement item : realEstatesList) {
			if (item.findElement(By.cssSelector("tr td[class*='title']"))
					.getText().contentEquals(description)) {
				WebElement estateValue = item.findElement(By
						.cssSelector("tr td:nth-child(3)"));
				WebElement estateCurrency = item.findElement(By
						.cssSelector("tr td:nth-child(4)"));
				WebElement estateComments = item.findElement(By
						.cssSelector("tr td:nth-child(5)"));
				WebElement estateCountry = item.findElement(By
						.cssSelector("tr td:nth-child(6)"));

				Assert.assertTrue("Real Estate Value is not correct",
						estateValue.getText().contentEquals(value));
				Assert.assertTrue("Real Estate Currency is not correct",
						estateCurrency.getText().contentEquals(currency));
				Assert.assertTrue("Real Estate Comments is not correct",
						estateComments.getText().contentEquals(comments));
				Assert.assertTrue("Real Estate Country is not correct",
						estateCountry.getText().contentEquals(country));

			}
		}
	}

	public void checkIfOtherInformationIsPresent(String... key) {
		boolean foundInformation = false;
		foundInformation = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[id*='seoGridOtherMandateInfo'] > table > tbody > tr td[class*='title']"),
				true, false, key);
		Assert.assertTrue("The real estate is not present", foundInformation);
	}

	public void checkInformationFromOtherInformation(String value,
			String currency, String place, String comments) {
		List<WebElement> OtherInfList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridOtherMandateInfo'] > table > tbody"));

		for (WebElement item : OtherInfList) {
			if (item.findElement(By.cssSelector("tr td[class*='title']"))
					.getText().contentEquals(value)) {

				WebElement otherCurrency = item.findElement(By
						.cssSelector("tr td:nth-child(3)"));
				WebElement otherPlace = item.findElement(By
						.cssSelector("tr td:nth-child(4)"));
				WebElement otherComments = item.findElement(By
						.cssSelector("tr td:nth-child(4)"));

				Assert.assertTrue("Other Inf Currency is not correct",
						otherCurrency.getText().contentEquals(currency));
				Assert.assertTrue("Other Inf Place is not correct", otherPlace
						.getText().contentEquals(place));
				Assert.assertTrue("Other Inf Comments is not correct",
						otherComments.getText().contentEquals(comments));

			}
		}
	}

	public void checkTypeOfTransaction(String type) {
		String typeField = getDriver().findElement(
				By.cssSelector("tr[id*='TypeOfTransaction'] input"))
				.getAttribute("value");
		Assert.assertTrue("Type of Transaction is not correct",
				typeField.contentEquals(type));
	}

	public void checkDomicileOfCounterParties(String country) {
		List<WebElement> countriesList = getDriver()
				.findElements(
						By.cssSelector("tr[id*='DomicileOfCounterParties'] select option"));
		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {

				Assert.assertTrue("Domicile of counter parties is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkTransactionComments(String comment) {
		String commentField = getDriver().findElement(
				By.cssSelector("tr[id*='TransactionsComments'] textarea"))
				.getText();
		Assert.assertTrue("Transaction comments is not correct",
				commentField.contentEquals(comment));
	}

	public void checkIfFFIIsChecked() {
		WebElement FFICheckbox = getDriver().findElement(
				By.cssSelector("tr[id*='FFI'] input"));
		Assert.assertTrue("FFI is not checked",
				isAttributePresent(FFICheckbox, "checked"));
	}

	public void checkIfNFFIIsChecked() {
		WebElement NFFICheckbox = getDriver().findElement(
				By.cssSelector("tr[id*='NFFI'] input"));
		Assert.assertTrue("NFFI is not checked",
				isAttributePresent(NFFICheckbox, "checked"));
	}

	public void checkTINNumber(String number) {
		String TINNumberField = getDriver().findElement(
				By.cssSelector("tr[id*='TINNumber'] input")).getAttribute(
				"value");
		Assert.assertTrue("TIN Number is not correct",
				TINNumberField.contentEquals(number));
	}

	public void checkRegistrationDate(String date) {
		String dateField = getDriver().findElement(
				By.cssSelector("tr[id*='RegistrationDate'] input"))
				.getAttribute("value");
		Assert.assertTrue("Registration date is not correct",
				dateField.contentEquals(date));
	}

	public void checkMandateProfileType(String profile) {
		List<WebElement> profileTypeList = getDriver().findElements(
				By.cssSelector("tr[id*='TypeOfMandate'] select option"));
		for (WebElement item : profileTypeList) {
			if (item.getText().contentEquals(profile)) {

				Assert.assertTrue("Type is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void inputUser(String userName) {
		WebElement identificationMadeByField = getDriver()
				.findElement(
						By.cssSelector("div[id*='usersEditor'] > input[id*='usersEditor_TopSpan']:nth-of-type(2)"));
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

	public void clickOnGetMandatesButton() {
		getDriver().findElement(
				By.cssSelector("input[name*='ApplyFiltersButton']")).click();
	}

	public boolean checkIfMandateIsPresent(String name) {
		boolean foundDocument = false;
		foundDocument = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[id*='seoGridView'] tr td:nth-child(2)"),
				true, false, name);
		return foundDocument;
	}

	public void selectTypeOfIssue(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfIssue']"))
				.click();
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[name*='TypeOfIssue'] option"));
		boolean foundOption = false;

		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void selectTaskType(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TaskType']")).click();
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[name*='TaskType'] option"));
		boolean foundOption = false;

		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputDeadlineDate(String date) {
		WebElement deadlineField = returnField("input", "DeadlineDate");
		element(deadlineField).clear();
		element(deadlineField).type(date);
	}

	public void selectTypeOfDeficiency(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfDeficiency']"))
				.click();
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[name*='TypeOfDeficiency'] option"));
		boolean foundOption = false;

		for (WebElement item : typesList) {
			if (item.getText().contentEquals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}

	public void inputFindings(String findings) {
		WebElement findingsField = returnField("input", "Findings");
		element(findingsField).clear();
		element(findingsField).type(findings);
	}

	public void inputAddionalRemarks(String remarks) {
		WebElement remarksField = returnField("input", "AddionalRemarks");
		element(remarksField).clear();
		element(remarksField).type(remarks);
	}

	public void checkCreatedOnForOpenIssues(String id, String date) {
		checkTextFromMandateSection("td:nth-child(3)", id, date);
	}

	public void checkDeadlineForOpenIssues(String id, String date) {
		checkTextFromMandateSection("td:nth-child(4)", id, date);
	}

	public void checkTypeOfIssue(String id, String type) {
		checkTextFromMandateSection("td:nth-child(5)", id, type);
	}

	public void checkTypeOfDeficiency(String id, String type) {
		checkTextFromMandateSection("td:nth-child(6)", id, type);
	}

	public void selectPayment(String payment) {
		getDriver().findElement(By.cssSelector("div[id*='ddlPayment']"))
				.click();
		List<WebElement> paymentList = getDriver().findElements(
				By.cssSelector("select[name*='ddlPayment'] option"));
		boolean foundOption = false;

		for (WebElement item : paymentList) {
			if (item.getText().contentEquals(payment)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The payment was not found!", foundOption);
	}

	public void selectDirection(String direction) {
		getDriver().findElement(By.cssSelector("div[id*='ddlDirection']"))
				.click();
		List<WebElement> directionList = getDriver().findElements(
				By.cssSelector("select[name*='ddlDirection'] option"));
		boolean foundOption = false;

		for (WebElement item : directionList) {
			if (item.getText().contentEquals(direction)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The direction was not found!", foundOption);
	}

	public void inputDateOfTransaction(String date) {
		WebElement transactionDateField = returnField("input",
				"dateOfTransactionDate");
		element(transactionDateField).clear();
		element(transactionDateField).type(date);
	}

	public void inputAmountFX(String amount) {
		WebElement amountFXField = returnField("input", "amountFX");
		element(amountFXField).clear();
		element(amountFXField).type(amount);
	}

	public void inputRelationWithMandate(String relation) {
		WebElement relationField = returnField("input", "relation");
		element(relationField).clear();
		element(relationField).type(relation);
	}

	public void inputSenderOrRecipient(String text) {
		WebElement senderOrReceipientField = returnField("input",
				"senderOrRecipient");
		element(senderOrReceipientField).clear();
		element(senderOrReceipientField).type(text);
	}

	public void selectOriginOfFunds(String country) {
		getDriver().findElement(By.cssSelector("div[id*='ddlOriginOfFunds']"))
				.click();
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("select[name*='ddlOriginOfFunds'] option"));
		boolean foundOption = false;

		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The country was not found!", foundOption);
	}

	public void inputNameOfBank(String name) {
		WebElement nameOfBankField = returnField("input", "newBank");
		element(nameOfBankField).type(name);
	}

	public void inputPlausability(String plausability) {
		WebElement plausabilityField = returnField("textarea", "plausability");
		element(plausabilityField).clear();
		element(plausabilityField).type(plausability);
	}

	public boolean checkItemByDate(String date) {
		List<WebElement> itemsList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridView'] table.ms-listviewtable > tbody > tr td:nth-child(2)"));
		for (WebElement item : itemsList) {
			if (item.getText().contains(date)) {
				return true;

			}
		}
		return false;

	}

	public void selectTransactionFromGrid(String date) {
		List<WebElement> gridList = getDriver()
				.findElements(
						By.cssSelector("div[id*='DeltaPlaceHolderMain'] > div:nth-of-type(2) tbody > tr"));
		gridList.remove(0);
		for (WebElement elemNow : gridList) {
			String elemId = elemNow.findElement(By.cssSelector("a")).getText();
			elemId = elemId.replace("\n", "");
			elemId = elemId.replace(
					"Use SHIFT+ENTER to open the menu (new window).", "");
			if (elemId != null && date.contentEquals(elemId)) {
				elemNow.findElement(By.cssSelector("input")).click();
				break;
			}
		}
	}

	public void checkPayment(String payment) {
		List<WebElement> paymentList = getDriver().findElements(
				By.cssSelector("tr[id*='Payment'] select option"));
		for (WebElement item : paymentList) {
			if (item.getText().contentEquals(payment)) {

				Assert.assertTrue("Payment is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkDirection(String direction) {
		List<WebElement> directionList = getDriver().findElements(
				By.cssSelector("tr[id*='Direction'] select option"));
		for (WebElement item : directionList) {
			if (item.getText().contentEquals(direction)) {

				Assert.assertTrue("Direction is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkTransactionDate(String date) {
		String transcationDate = getDriver().findElement(
				By.cssSelector("tr[id*='DateOfTransacrionRow'] input"))
				.getAttribute("value");
		Assert.assertTrue("Transcation date is not correct",
				transcationDate.contentEquals(date));
	}

	public void checkCurrency(String currency) {
		List<WebElement> currenciesList = getDriver().findElements(
				By.cssSelector("tr[id*='Currency'] select option"));
		for (WebElement item : currenciesList) {
			if (item.getText().contentEquals(currency)) {

				Assert.assertTrue("Currency is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkAmountFx(String amount) {
		String amountFXField = getDriver().findElement(
				By.cssSelector("tr[id*='AmountFX'] input")).getAttribute(
				"value");
		Assert.assertTrue("Amount FX is not correct",
				amountFXField.contentEquals(amount));
	}

	public void checkAmountInEuro(String amount) {
		String amountEuroField = getDriver().findElement(
				By.cssSelector("tr[id*='AmontEURORow'] span")).getText();
		Assert.assertTrue("Amount EURO is not correct",
				amountEuroField.contentEquals(amount));
	}

	public void checkSenderOrRecipient(String name) {
		String senderOrRecipientField = getDriver().findElement(
				By.cssSelector("tr[id*='Tr1'] input")).getAttribute("value");
		Assert.assertTrue("Sender is not correct",
				senderOrRecipientField.contentEquals(name));
	}

	public void checkRelation(String relation) {
		String relationWithMandateField = getDriver().findElement(
				By.cssSelector("tr[id*='LinkRelation'] input")).getAttribute(
				"value");
		Assert.assertTrue("Relation with the mandate is not correct",
				relationWithMandateField.contentEquals(relation));
	}

	public void checkOriginOfFunds(String country) {
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("tr[id*='Tr4'] select option"));
		for (WebElement item : countriesList) {
			if (item.getText().contentEquals(country)) {

				Assert.assertTrue("Origin of funds is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkNameOfBank(String bank) {
		List<WebElement> bankList = getDriver().findElements(
				By.cssSelector("tr[id*='Tr5'] select option"));
		for (WebElement item : bankList) {
			if (item.getText().contentEquals(bank)) {

				Assert.assertTrue("OName of Bank is not correct",
						isAttributePresent(item, "selected"));
			}
		}
	}

	public void checkPlausability(String plausability) {
		String plausabilityField = getDriver().findElement(
				By.cssSelector("tr[id*='Tr7'] textarea")).getAttribute("value");
		Assert.assertTrue("Plausability is not correct",
				plausabilityField.contentEquals(plausability));
	}
}
