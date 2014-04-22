package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class FilterPage extends AbstractPage {

	public FilterPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnFilterDropdownList() {
		WebElement dropdownFilter = getDriver().findElement(
				By.cssSelector("div#filter"));
		element(dropdownFilter).click();
	}

	public void selectTypeFilter(String filter) {
		List<WebElement> filtersList = getDriver().findElements(
				By.cssSelector(("select[id*='typeFilter'] > option")));
		boolean foundOption = false;
		for (WebElement option : filtersList) {
			if (option.getText().contentEquals(filter)) {
				foundOption = true;
				option.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);
	}

	public void clickOnFilterButton() {
		WebElement filterButton = returnField("input", "ApplyFiltersButton");
		element(filterButton).click();
	}

	public void inputUsername(String user) {
		WebElement userField = getDriver().findElement(
				By.cssSelector("div[id*='upLevelDiv']"));
		element(userField).clear();
		element(userField).type(user);
	}

	public void clickOnClearFiltersButton() {
		WebElement clearFiltersButton = returnField("input",
				"ClearFiltersButton");
		element(clearFiltersButton).click();
	}

	public void clickOnFilterByDateCheckBox() {
		WebElement dateIntervalCheckBox = returnField("input", "dateInterval");
		element(dateIntervalCheckBox).click();
	}

	public void inputFromDateField(String date) {
		WebElement fromDateField = returnField("input", "fromDateFilterDate");
		element(fromDateField).clear();
		element(fromDateField).type(date);
	}

	public void inputToDateField(String date) {
		WebElement toDateField = returnField("input", "toDateFilterDate");
		element(toDateField).clear();
		element(toDateField).type(date);
	}
}
