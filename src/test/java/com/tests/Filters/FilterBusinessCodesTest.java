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

@Story(Application.Filter.FilterBusinessCodes.class)
@RunWith(ThucydidesRunner.class)
public class FilterBusinessCodesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterBusinessCodes() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.deleteElementIfExists("595");
		abstractPageSteps.selectActionFromLeftMenu("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.deleteElementIfExists("894");
		// create risk categories
		abstractPageSteps.selectActionFromLeftMenu("Categories");
		abstractPageSteps.deleteElementIfExists("78");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("78", "Edit Risk");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("893", "Edit Risk", "78");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("894", "Edit Risk", "78");
		// create business codes
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("594", "Kenya", "893");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("595", "Germany", "894");

		// filter by code
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputBussinessCode("594");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("594");
		itemsPageSteps.checkThatElementIsNotPresent("595");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by name
		filterPageSteps.inputName("Germany");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("595");
		itemsPageSteps.checkThatElementIsNotPresent("594");
		filterPageSteps.clickOnClearFiltersButton();

		// delete items
		abstractPageSteps.deleteElementIfExists("595");
		itemsPageSteps.checkThatElementIsNotPresent("595");
		abstractPageSteps.deleteElementIfExists("594");
		itemsPageSteps.checkThatElementIsNotPresent("594");
		abstractPageSteps.selectActionFromLeftMenu("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.deleteElementIfExists("894");
		itemsPageSteps.checkThatElementIsNotPresent("893");
		itemsPageSteps.checkThatElementIsNotPresent("894");
		abstractPageSteps.selectActionFromLeftMenu("Categories");
		abstractPageSteps.deleteElementIfExists("78");
		itemsPageSteps.checkThatElementIsNotPresent("78");

	}
}
