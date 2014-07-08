package com.tests.Filters;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.FilterPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Filter.FilterCurrencies.class)
@RunWith(ThucydidesRunner.class)
public class FilterCurrenciesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterCurrencies() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g59k");
		abstractPageSteps.deleteElementIfExists("g60k");

		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("acd");
		abstractPageSteps.deleteElementIfExists("bcd");
		abstractPageSteps.deleteElementIfExists("dcd");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("acd", "CD");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("bcd", "BD");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("dcd", "DD");
		// create currencies
		abstractPageSteps.selectActionFromLeftMenu("Currencies");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createActiveCurrency("384", "g59k", "USD", "bcd", "985");
		itemsPageSteps.checkIfElementIsPresent("g59k");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createInactiveCurrency("385", "g60k", "EUR", "dcd",
				"985");
		itemsPageSteps.checkIfElementIsPresent("g60k");

		// filter by country code
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputCountryCode("bcd");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by iso code
		filterPageSteps.inputISOCode("g59k");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by active
		filterPageSteps.checkActiveCheckBox();
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		filterPageSteps.clickOnClearFiltersButton();

		// delete items
		abstractPageSteps.deleteElementIfExists("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g59k");
		abstractPageSteps.deleteElementIfExists("g60k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("acd");
		abstractPageSteps.deleteElementIfExists("bcd");
	}
}
