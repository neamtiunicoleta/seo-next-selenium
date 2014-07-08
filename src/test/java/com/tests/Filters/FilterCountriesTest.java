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

@Story(Application.Filter.FilterCountries.class)
@RunWith(ThucydidesRunner.class)
public class FilterCountriesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterCountries() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("abd(*)");
		abstractPageSteps.deleteElementIfExists("aaf4");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("754");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("754", "Risk", "B (Category B)");
		// create countries
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithRisk("abd", "NC", "754");
		itemsPageSteps.checkIfElementIsPresent("abd");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("aaf4", "CF");
		itemsPageSteps.checkIfElementIsPresent("aaf4");

		// filter by code
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputCountryCode("NC");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("abd");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by title
		filterPageSteps.inputCountryTitle("abd");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("abd");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by risk
		filterPageSteps.checkRiskyCheckBox();
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("abd");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		filterPageSteps.clickOnClearFiltersButton();

		// delete items
		abstractPageSteps.deleteElementIfExists("abd(*)");
		itemsPageSteps.checkThatElementIsNotPresent("abd(*)");
		abstractPageSteps.deleteElementIfExists("aaf4");
		itemsPageSteps.checkThatElementIsNotPresent("aaf4");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("754");
	}
}
