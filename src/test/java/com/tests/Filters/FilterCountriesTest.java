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
		abstractPageSteps.deleteElementIfExists("754");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("91");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("91", "Edit Risk1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		itemsPageSteps.createRiskCriteria("754", "Risk", "91");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("abd");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithRisk("abd", "NC", "754");
		itemsPageSteps.checkIfElementIsPresent("abd");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("aaf4", "CF");
		itemsPageSteps.checkIfElementIsPresent("aaf4");

		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputCountryCode("NC");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("abd");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.inputCountryTitle("abd");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("abd");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.checkRiskyCheckBox();
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("abd");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		abstractPageSteps.deleteElementIfExists("abd");
		itemsPageSteps.checkThatElementIsNotPresent("abd");
		abstractPageSteps.deleteElementIfExists("aaf4");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("754");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("91");
	}
}
