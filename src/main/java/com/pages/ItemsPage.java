package com.pages;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class ItemsPage extends AbstractPage {

	public ItemsPage(WebDriver driver) {
		super(driver);
	}

	public void inputKeyField(String key) {
		WebElement keyField = returnField("input", "Key");
		element(keyField).clear();
		element(keyField).type(key);
	}

	public void inputDescriptionField(String description) {
		WebElement descriptionField = returnField("textarea", "idDescription");
		element(descriptionField).clear();
		element(descriptionField).type(description);

	}

	public void selectRisk(String category) {
		getDriver().findElement(By.cssSelector("div[id*='Risk']")).click();
		List<WebElement> riskCategoryList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;
		for (WebElement riskCategory : riskCategoryList) {
			if (riskCategory.getText().equals(category)) {
				foundOption = true;
				riskCategory.click();
				break;
			}
		}
		Assert.assertTrue("The category was not found!", foundOption);

	}

	public void selectCountry(String countryName) {
		getDriver().findElement(By.cssSelector("div[id*='ddlCountry']"))
				.click();
		List<WebElement> countriesList = getDriver().findElements(
				By.cssSelector("select[id*='ddlCountry'] option"));
		boolean foundOption = false;
		for (WebElement country : countriesList) {
			if (country.getText().equals(countryName)) {
				foundOption = true;
				country.click();
				break;
			}
		}
		Assert.assertTrue("The country was not found!", foundOption);

	}

	public boolean checkIfCategoryExists(String id) {
		getDriver().findElement(By.cssSelector("div[id*='Risk']")).click();
		List<WebElement> gridList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		for (WebElement item : gridList) {
			if (item.getText().contains(id)) {
				item.click();
				return true;
			}

		}
		return false;
	}

	public void clickOnActiveCheckBox() {
		WebElement activeCheckBox = returnField("input", "Active");
		element(activeCheckBox).click();
	}

	public void checkDescriptionFromGrid(String id, String description) {
		checkTextFromField("td.gridDescriptionColumn", id, description);
	}

	public void inputCodeField(String code) {
		WebElement codeField = returnField("input", "Code");
		element(codeField).clear();
		element(codeField).type(code);
	}

	public void inputTitleField(String title) {
		WebElement titleField = returnField("input", "Title");
		element(titleField).clear();
		element(titleField).type(title);
	}

	public void checkTitleFromGrid(String id, String title) {
		checkTextFromField("td:nth-child(4)", id, title);
	}

	public void checkKeyForRisksFromGrid(String id, String key) {
		checkTextFromField("td.ms-vb-title", id, key);
	}

	public void checkKeyForCurrenciesFromGrid(String id, String key) {
		checkTextFromField("td:nth-child(2)", id, key);
	}

	public void checkRiskCategoryForCriteriasFromGrid(String id, String risk) {
		checkTextFromField("td:nth-child(4)", id, risk);
	}

	public void checkCodeFromGrid(String id, String code) {
		checkTextFromField("td:nth-child(3)", id, code);
	}

	public void checkCountryFromGrid(String id, String country) {
		checkTextFromField("td:nth-child(5)", id, country);
	}

	public void clickOnHighImportanceCheckBox() {
		WebElement highImportanceCheckbox = returnField("input",
				"HighImportance");
		element(highImportanceCheckbox).click();
	}

	public void inputStartDate(String startDate) {
		WebElement date = returnField("input", "StartDateDate");
		element(date).clear();
		element(date).type(startDate);
	}

	public void inputRate(String rate) {
		WebElement exchangeRate = returnField("input", "idRate");
		element(exchangeRate).clear();
		element(exchangeRate).type(rate);
	}

	public void checkRateFromGrid(String startDate, String rate) {
		checkTextFromField("td:nth-child(3)", startDate, rate);
	}

	public void checkNameForBusinessCodesFromGrid(String id, String name) {
		checkTextFromField("td:nth-child(3)", id, name);
	}

	public void checkRiskCriteriaFromGrid(String id, String riskCriteria) {
		checkTextFromField("td:nth-child(4)", id, riskCriteria);
	}

	public void clickOnDeleteLogItemsButton() {
		WebElement deleteLogItemsButton = returnField("input", "deleteLog");
		element(deleteLogItemsButton).click();
	}

	public void clickOnViewDetailsButton() {
		WebElement viewDetailsButton = returnField("div", "viewitem");
		element(viewDetailsButton).click();
	}

	public void checkIfActiveCheckBoxIsChecked(String id) {
		Assert.assertTrue("The checkbox is not checked",
				checkCheckBox("input[id*='active']", id));
	}

	public void checkIfActiveCheckBoxIsNotChecked(String id) {
		Assert.assertFalse("The checkbox is checked",
				checkCheckBox("input[id*='active']", id));
	}

	public void checkIfHighImportanceCheckBoxIsChecked(String id) {
		Assert.assertTrue("The checkbox is not checked",
				checkCheckBox("input[id*='highImportance']", id));
	}

	public void checkIfHighImportanceCheckBoxIsNotChecked(String id) {
		Assert.assertFalse("The checkbox is checked",
				checkCheckBox("input[id*='highImportance']", id));
	}

	public void inputActualSituationForDocSituation(String situation) {
		WebElement actualSituationField = returnField("textarea",
				"ActualSituation");
		element(actualSituationField).clear();
		element(actualSituationField).type(situation);
	}

	public void inputRiskForDocSituation(String risk) {
		WebElement riskField = returnField("input", "Risk");
		element(riskField).clear();
		element(riskField).type(risk);
	}

	public void inputResolutionForDocSituation(String resolution) {
		WebElement resolutionField = returnField("textarea", "Resolution");
		element(resolutionField).clear();
		element(resolutionField).type(resolution);
	}

	public void checkRiskForDocSituation(String title, String risk) {
		checkTextFromField("td:nth-child(4)", title, risk);
	}

	public void checkResolutionForDocSituation(String title, String risk) {
		checkTextFromField("th:nth-child(5)", title, risk);
	}

	public void inputOrganizationUnit(String unit) {
		WebElement organizationUnitField = returnField("input", "OU");
		element(organizationUnitField).clear();
		element(organizationUnitField).type(unit);
	}

	public void inputPopBox(String popBox) {
		WebElement popBoxField = returnField("input", "POBox");
		element(popBoxField).clear();
		element(popBoxField).type(popBox);
	}

	public void inputEmployees(String userName) {
		WebElement identificationMadeByField = getDriver().findElement(
				By.cssSelector("input[id*='usersEditor_TopSpan_EditorInput']"));
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

	public void checkOrganizationUnit(String name, String unit) {
		checkTextFromField("td:nth-child(3)", name, unit);
	}

	public void selectMandateServiceType(String type) {
		getDriver().findElement(By.cssSelector("div[id*='ddlServiceType']"))
				.click();
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[id*='ddlServiceType'] option"));
		boolean foundOption = false;
		for (WebElement country : typesList) {
			if (country.getText().equals(type)) {
				foundOption = true;
				country.click();
				break;
			}
		}
		Assert.assertTrue("The type was not found!", foundOption);

	}

	public void checkTypeFromGrid(String id, String type) {
		checkTextFromField("td:nth-child(4)", id, type);
	}

	public void inputServiceDescription(String description) {
		WebElement descriptionField = returnField("input", "Description");
		element(descriptionField).clear();
		element(descriptionField).type(description);

	}

	public void selectTaskTypeForDeficienct(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TaskType']")).click();
		List<WebElement> taskTypeList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;
		for (WebElement item : taskTypeList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The task type was not found!", foundOption);

	}
}