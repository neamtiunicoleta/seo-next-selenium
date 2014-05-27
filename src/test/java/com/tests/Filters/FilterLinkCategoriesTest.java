package com.tests.Filters;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
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
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void filterLinkCategories() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Jane");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		abstractPageSteps.selectActionFromManagePagesRibbon("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("cl-md1");
		abstractPageSteps.deleteElementIfExists("md-cl1");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md1", "Client", "Mandate",
				"Client-Mandate");
		itemsPageSteps.checkIfElementIsPresent("cl-md1");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md-cl1", "Mandate", "Client",
				"Mandate-Client");
		itemsPageSteps.checkIfElementIsPresent("md-cl1");

		// filter by title
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputTitle("cl-md1");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by source object
		filterPageSteps.clickOnFilterDropdownList();
		linksPageSteps.selectSourceObjectType("Client");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by target object
		filterPageSteps.clickOnFilterDropdownList();
		linksPageSteps.selectTargetObjectType("Mandate");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		// filter by relations
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputRelations("Client-Mandate");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		filterPageSteps.clickOnClearFiltersButton();

		// delete items
		abstractPageSteps.deleteElementIfExists("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("cl-md1");
		abstractPageSteps.deleteElementIfExists("md-cl1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();

	}
}
