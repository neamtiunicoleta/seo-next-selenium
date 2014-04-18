package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;
import com.tools.Delay;

public class ItemsPage extends AbstractPage {

	public ItemsPage(WebDriver driver) {
		super(driver);
	}

	public void inputKeyField(String key) {
		WebElement keyField = returnField("input", "idKey");
		element(keyField).clear();
		element(keyField).type(key);
	}

	public void inputDescriptionField(String description) {
		WebElement descriptionField = returnField("textarea", "idDescription");
		element(descriptionField).clear();
		element(descriptionField).type(description);

	}

	public void selectRisk(String category) {
		getDriver().findElement(By.cssSelector("select[id*='Risk']")).click();
		List<WebElement> riskCategoryList = getDriver().findElements(
				By.cssSelector("select[id*='ddlRisk'] option"));
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
		getDriver().findElement(By.cssSelector("select[id*='ddlCountry']"))
				.click();
		List<WebElement> CountriesList = getDriver().findElements(
				By.cssSelector("select[id*='ddlCountry'] option"));
		boolean foundOption = false;
		for (WebElement country : CountriesList) {
			if (country.getText().equals(countryName)) {
				foundOption = true;
				country.click();
				break;
			}
		}
		Assert.assertTrue("The country was not found!", foundOption);

	}

	public boolean checkIfCategoryExists(String id) {
		getDriver().findElement(By.cssSelector("select[id*='ddlRisk']"))
				.click();
		List<WebElement> gridList = getDriver().findElements(
				By.cssSelector("select[id*='ddlRisk'] option"));
		for (WebElement item : gridList) {
			if (item.getText().contains(id)) {
				return true;
			}

		}
		return false;
	}

	public void clickOnActiveCheckBox() {
		WebElement activeCheckBox = returnField("input", "idFormSectionActive");
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

	public void checkRoundingValueFromGrid(String id, String value) {
		checkTextFromField("td:nth-child(6)", id, value);
	}

	public void checkCountryFromGrid(String id, String country) {
		checkTextFromField("td:nth-child(5)", id, country);
	}

	public boolean checkIfElementIsPresent(String... key) {
		boolean hasMorePages = true;
		boolean foundDocument = false;
		while (hasMorePages && !foundDocument) {
			foundDocument = checkIfElementWithSpecifiedTextExistsInList(
					By.cssSelector("div[id*='seoGridView'] > table > tbody > tr td[class*='title']"),
					true, false, key);
			WebElement nextPageButton = getElementIfExists(
					By.cssSelector("a[id*='btn_Next']"), Delay.SMALL,
					TimeUnit.SECONDS);
			if (nextPageButton == null) {
				hasMorePages = false;
			} else if (!foundDocument) {
				nextPageButton.click();
			}
		}
		return foundDocument;
	}

	public void inputRoundingValue(String roundingValue) {
		WebElement value = returnField("input", "idRoundingValue");
		element(value).clear();
		element(value).type(roundingValue);
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

	public void clickOnYearToDateCheckBox() {
		WebElement yearToDateCheckbox = returnField("input", "YTD");
		element(yearToDateCheckbox).click();
	}

	public void checkEndDateFromGrid(String startDate, String endDate) {
		checkTextFromField("td:nth-child(3)", startDate, endDate);
	}

	public void checkRateFromGrid(String startDate, String rate) {
		checkTextFromField("td:nth-child(4)", startDate, rate);
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
}