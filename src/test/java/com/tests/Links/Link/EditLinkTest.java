package com.tests.Links.Link;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.HitLogPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditLink.class)
@RunWith(ThucydidesRunner.class)
public class EditLinkTest extends BaseTest {

	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.deleteElementIfExists("Cl-cl Link1");
		abstractPageSteps.deleteElementIfExists("Cl-md Link1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client12-Client12");
		abstractPageSteps.deleteElementIfExists("Client23-Mandate23");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl20");
		abstractPageSteps.deleteElementIfExists("cl-md20");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl20", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md20", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client1-Client1", "client-cl19");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");

		linksPageSteps.createLinkType("Client2-Mandate2", "cl-md29");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createActiveLink("Cl-cl Link1", "Client", "Walters",
				"Client", "Muller", "Client1-Client1", "Client client link");
		// edit link
		abstractPageSteps.selectItemFromGrid("Cl-cl Link1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");

		linksPageSteps.createActiveLink("Cl-md Link1", "Client", "Muller",
				"Mandate", "PAEMandate", "Client23-Mandate23",
				"Client mandate link");
		itemsPageSteps.checkIfElementIsPresent("Cl-md Link1");
		linksPageSteps.checkSource("Cl-cmd Link1", "Client Muller");
		linksPageSteps.checkTarget("Cl-md Link1", "Mandate PAEMandate");
		linksPageSteps.checkLinkType("Cl-md Link1", "Client2-Mandate2");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Cl-md Link1");
		// delete items
		abstractPageSteps.deleteElementIfExists("Cl-cl Link1");
		abstractPageSteps.deleteElementIfExists("Cl-md Link1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client12-Client12");
		abstractPageSteps.deleteElementIfExists("Client23-Mandate23");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl20");
		abstractPageSteps.deleteElementIfExists("cl-md20");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Links", "accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Cl-md Link1 from Links was Deleted");

		itemsPageSteps
				.checkIfElementIsPresent("Title: Cl-md Link1 from Links was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Title: Cl-md Link1 from Links was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "Cl-cl Link1",
				"Cl-md Link1");
		hitLogPageSteps.checkIfChangesArePresent("SourceClient", "Walters",
				"Muller");
		hitLogPageSteps.checkIfChangesArePresent("TargetClient", "Muller", "");
		hitLogPageSteps.checkIfChangesArePresent("TargetMandate", "",
				"PAEMandate");
		hitLogPageSteps.checkIfChangesArePresent("TargetMandate", "",
				"PAEMandate");
		hitLogPageSteps.checkIfChangesArePresent("LinkType",
				"Client12-Client12", "Client23-Mandate23");
		hitLogPageSteps.checkIfChangesArePresent("Active", "True", "False");
		hitLogPageSteps.checkIfChangesArePresent("Comment",
				"Client client link", "Client mandate link");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Title: Cl-cl Link1 from LinkCategories was Added");
	}
}
