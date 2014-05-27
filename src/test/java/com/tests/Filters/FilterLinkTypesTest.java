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

@Story(Application.Filter.FilterLinkType.class)
@RunWith(ThucydidesRunner.class)
public class FilterLinkTypesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void filterLinkTypes() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Ana");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		abstractPageSteps.selectActionFromManagePagesRibbon("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("cl-md2");
		abstractPageSteps.deleteElementIfExists("md1-cl2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md2", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md1-cl2", "Mandate", "Client",
				"Mandate-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client2-Mandate2", "cl-md2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Mandate4-Client4", "md1-cl2");
		// filter by title
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputTitle("Client");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("Client2-Mandate2");
		itemsPageSteps.checkIfElementIsPresent("Mandate4-Client4");
		filterPageSteps.clickOnClearFiltersButton();
		// filter by link category
		linksPageSteps.selectLinkCategory("cl-md2");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("Client2-Mandate2");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate4-Client4");
		filterPageSteps.clickOnClearFiltersButton();
		// delete items
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		itemsPageSteps.checkThatElementIsNotPresent("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate4-Client4");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
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
