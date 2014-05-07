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

@Story(Application.Filter.FilterCountries.class)
@RunWith(ThucydidesRunner.class)
public class FilterCountriesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterCountries() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("132", "Edit Risk1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithRisk("aaf3", "NC", "132");
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("aaf4", "CF");
		itemsPageSteps.checkIfElementIsPresent("aaf4");

		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputCountryCode("NC");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.inputCountryTitle("aaf3");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.checkRiskyCheckBox();
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		abstractPageSteps.deleteElementIfExists("aaf3");
		itemsPageSteps.checkThatElementIsNotPresent("aaf3");
		abstractPageSteps.deleteElementIfExists("aaf4");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
	}
}
