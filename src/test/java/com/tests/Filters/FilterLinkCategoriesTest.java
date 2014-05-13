package com.tests.Filters;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.FilterPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Filter.FilterLinkCategory.class)
@RunWith(ThucydidesRunner.class)
public class FilterLinkCategoriesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterLinkCategories() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		 abstractPageSteps.deleteElementIfExists("cl-cl1");
		 abstractPageSteps.deleteElementIfExists("cl-md1");
		 abstractPageSteps.deleteElementIfExists("md-md1");
		 abstractPageSteps.deleteElementIfExists("md-cl1");
		
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkCategory("cl-cl1", "Client", "Client",
		 "Client-Client");
		 itemsPageSteps.checkIfElementIsPresent("cl-cl1");
		
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkCategory("cl-md1", "Client", "Mandate",
		 "Client-Mandate");
		 itemsPageSteps.checkIfElementIsPresent("cl-md1");
		
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkCategory("md-md1", "Mandate", "Mandate",
		 "Mandate-Mandate");
		 itemsPageSteps.checkIfElementIsPresent("md-md1");
		
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkCategory("md-cl1", "Mandate", "Client",
		 "Mandate-Client");
		 itemsPageSteps.checkIfElementIsPresent("md-cl1");

		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputTitle("cl-cl1");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-cl1");
		itemsPageSteps.checkThatElementIsNotPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.clickOnFilterDropdownList();
		linksPageSteps.selectSourceObjectType("Client");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-cl1");
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.clickOnFilterDropdownList();
		linksPageSteps.selectTargetObject("Mandate");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkThatElementIsNotPresent("cl-cl1");
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		itemsPageSteps.checkIfElementIsPresent("md-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputRelations("Client-Client");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-cl1");
		itemsPageSteps.checkThatElementIsNotPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		 abstractPageSteps.deleteElementIfExists("cl-cl1");
		 itemsPageSteps.checkThatElementIsNotPresent("cl-cl1");
		 abstractPageSteps.deleteElementIfExists("cl-md1");
		 itemsPageSteps.checkThatElementIsNotPresent("cl-md1");
		 abstractPageSteps.deleteElementIfExists("md-md1");
		 itemsPageSteps.checkThatElementIsNotPresent("md-md1");
		 abstractPageSteps.deleteElementIfExists("md-cl1");
		 itemsPageSteps.checkThatElementIsNotPresent("md-cl1");

	}
}
