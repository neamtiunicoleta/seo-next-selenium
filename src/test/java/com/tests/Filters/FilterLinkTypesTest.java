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

@Story(Application.Filter.FilterLinkType.class)
@RunWith(ThucydidesRunner.class)
public class FilterLinkTypesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterLinkTypes() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client1-Client1");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate3-Mandate3");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		abstractPageSteps.deleteElementIfExists("mandate-md1");
		abstractPageSteps.deleteElementIfExists("cl-md2");
		abstractPageSteps.deleteElementIfExists("md1-cl2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl1", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("mandate-md1", "Mandate", "Mandate",
				"Mandate-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md2", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md1-cl2", "Mandate", "Client",
				"Mandate-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client1-Client1", "client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client2-Mandate2", "cl-md2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Mandate3-Mandate3", "mandate-md1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Mandate4-Client4", "md1-cl2");
		// filter by title
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputTitle("Client");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("Client1-Client1");
		itemsPageSteps.checkIfElementIsPresent("Client2-Mandate2");
		itemsPageSteps.checkIfElementIsPresent("Mandate4-Client4");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate3-Mandate3");
		filterPageSteps.clickOnClearFiltersButton();
		// filter by link category
		linksPageSteps.selectLinkCategory("client-cl1");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("Client1-Client1");
		itemsPageSteps.checkThatElementIsNotPresent("Client2-Mandate2");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate4-Client4");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate3-Mandate3");
		filterPageSteps.clickOnClearFiltersButton();
		// delete items
		abstractPageSteps.deleteElementIfExists("Client1-Client1");
		itemsPageSteps.checkThatElementIsNotPresent("Client1-Client1");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		itemsPageSteps.checkThatElementIsNotPresent("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate4-Client4");
		abstractPageSteps.deleteElementIfExists("Mandate3-Mandate3");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate3-Mandate3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		abstractPageSteps.deleteElementIfExists("mandate-md1");
		abstractPageSteps.deleteElementIfExists("cl-md2");
		abstractPageSteps.deleteElementIfExists("md1-cl2");

	}
}
