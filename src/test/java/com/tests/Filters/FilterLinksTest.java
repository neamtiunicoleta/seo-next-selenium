package com.tests.Filters;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ExportFiles;
import com.steps.FilterPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Filter.FilterLink.class)
@RunWith(ThucydidesRunner.class)
public class FilterLinksTest extends BaseTest {
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFiles exportFiles;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterLinks() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.deleteElementIfExists("Cl-cl Link9");
		abstractPageSteps.deleteElementIfExists("Md-md Link9");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client123-Client123");
		abstractPageSteps.deleteElementIfExists("Mandate233-Mandate233");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl120");
		abstractPageSteps.deleteElementIfExists("mandate-md200");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl120", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("mandate-md200", "Mandate",
				"Mandate", "Mandate-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client123-Client123", "client-cl120");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");

		linksPageSteps.createLinkType("Mandate233-Mandate233", "mandate-md200");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create links
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps
				.createInactiveLink("Cl-cl Link9", "Client", "Walters",
						"Client", "Muller", "Client123-Client123",
						"Client client link");
		itemsPageSteps.checkIfElementIsPresent("Cl-cl Link9");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createActiveLink("Md-md Link9", "Mandate", "TCMMandate",
				"Mandate", "PAEMandate", "Mandate233-Mandate233",
				"Mandate mandate link");
		itemsPageSteps.checkIfElementIsPresent("Md-md Link9");
		// filter by title
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.inputTitle("Cl-cl");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("Cl-cl Link9");
		itemsPageSteps.checkThatElementIsNotPresent("Md-md Link9");
		filterPageSteps.clickOnClearFiltersButton();
		// filter by active
		filterPageSteps.checkActiveCheckBox();
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkThatElementIsNotPresent("Cl-cl Link9");
		itemsPageSteps.checkIfElementIsPresent("Md-md Link9");
		filterPageSteps.clickOnClearFiltersButton();
		// filter by link type
		linksPageSteps.selectLinkType("Client123-Client123");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("Cl-cl Link9");
		itemsPageSteps.checkThatElementIsNotPresent("Md-md Link9");
		filterPageSteps.clickOnClearFiltersButton();
		// delte items
		abstractPageSteps.deleteElementIfExists("Cl-cl Link9");
		abstractPageSteps.deleteElementIfExists("Cl-md Link9");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client123-Client123");
		abstractPageSteps.deleteElementIfExists("Client233-Mandate233");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl120");
		abstractPageSteps.deleteElementIfExists("cl-md200");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
	}
}
