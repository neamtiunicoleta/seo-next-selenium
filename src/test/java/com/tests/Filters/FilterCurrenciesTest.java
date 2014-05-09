package com.tests.Filters;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.FilterPageSteps;
import com.steps.HitLogPageSteps;
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
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterCurrencies() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g59k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createActiveCurrency("384", "g59k", "USD", "AUSTRIA",
				"985");
		itemsPageSteps.checkIfElementIsPresent("g59k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createInactiveCurrency("385", "g60k", "EUR", "ANGOLA",
				"985");
		itemsPageSteps.checkIfElementIsPresent("g60k");

		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputCountryCode("AUSTRIA");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.inputISOCode("g59k");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.checkActiveCheckBox();
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		filterPageSteps.clickOnClearFiltersButton();

		abstractPageSteps.deleteElementIfExists("g59k");
		itemsPageSteps.checkThatElementIsNotPresent("g59k");
		abstractPageSteps.deleteElementIfExists("g60k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
	}
}
