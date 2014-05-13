package com.tests.Links.Link;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateLink.class)
@RunWith(ThucydidesRunner.class)
public class CreateLinkTest extends BaseTest {

	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// CREATE CLIENTS AND MANDATES FIRST!!!!!!
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.deleteElementIfExists("Cl-cl Link");
		abstractPageSteps.deleteElementIfExists("Cl-md Link");
		abstractPageSteps.deleteElementIfExists("Md-cl Link");
		abstractPageSteps.deleteElementIfExists("Md-md Link");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client1-Client1");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate3-Mandate3");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		// create linkCategories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl19");
		abstractPageSteps.deleteElementIfExists("mandate-md19");
		abstractPageSteps.deleteElementIfExists("cl-md29");
		abstractPageSteps.deleteElementIfExists("md1-cl29");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl19", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("mandate-md19", "Mandate", "Mandate",
				"Mandate-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md29", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md1-cl29", "Mandate", "Client",
				"Mandate-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create linkTypes
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client1-Client1", "client-cl19");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client2-Mandate2", "cl-md29");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Mandate3-Mandate3", "mandate-md19");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Mandate4-Client4", "md1-cl29");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create links
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createActiveLink("Cl-cl Link", "Client", "Walters",
				"Client", "Muller", "Client1-Client1", "Client client link");
		itemsPageSteps.checkIfElementIsPresent("Cl-cl Link");
		linksPageSteps.checkSource("Cl-cl Link", "Client Walters");
		linksPageSteps.checkTarget("Cl-cl Link", "Client Muller");
		linksPageSteps.checkLinkType("Cl-cl Link", "Client1-Client1");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-cl Link");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createActiveLink("Cl-md Link", "Client", "Walters",
				"Mandate", "PAEMandate", "Client2-Mandate2",
				"Client mandate link");
		itemsPageSteps.checkIfElementIsPresent("Cl-md Link");
		linksPageSteps.checkSource("Cl-cmd Link", "Client Walters");
		linksPageSteps.checkTarget("Cl-md Link", "Mandate PAEMandate");
		linksPageSteps.checkLinkType("Cl-md Link", "Client2-Mandate2");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-md Link");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createActiveLink("Md-cl Link", "Mandate", "MTPMandate",
				"Client", "Muller", "Mandate4-Client4", "Mandate client link");
		itemsPageSteps.checkIfElementIsPresent("Md-cl Link");
		linksPageSteps.checkSource("Md-cl Link", "Mandate MTPMandate");
		linksPageSteps.checkTarget("Md-cl Link", "Client Muller");
		linksPageSteps.checkLinkType("Md-cl Link", "Mandate4-Client4");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Md-cl Link");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createActiveLink("Md-md Link", "Mandate", "MTPMandate",
				"Mandate", "PAEMandate", "Mandate3-Mandate3",
				"Mandate mandate link");
		itemsPageSteps.checkIfElementIsPresent("Md-md Link");
		linksPageSteps.checkSource("Md-md Link", "Mandate MTPMandate");
		linksPageSteps.checkTarget("Md-md Link", "Mandate PAEMandate");
		linksPageSteps.checkLinkType("Md-md Link", "Mandate3-Mandate3");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("md-md Link");

		// activate links

		abstractPageSteps.selectItemFromGrid("Cl-cl Link");
		abstractPageSteps.selectItemFromGrid("Cl-md Link");
		abstractPageSteps.selectItemFromGrid("Md-cl Link");
		abstractPageSteps.selectActionFromManagePagesRibbon("Activate");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-cl Link");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-md Link");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Md-cl Link");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Md-md Link");

		// deactivate links
		abstractPageSteps.selectItemFromGrid("Cl-md Link");
		abstractPageSteps.selectItemFromGrid("Md-cl Link");
		abstractPageSteps.selectItemFromGrid("Md-md Link");
		abstractPageSteps.selectActionFromManagePagesRibbon("Deactivate");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-cl Link");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Cl-md Link");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Md-cl Link");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Md-md Link");

		// delete items
		abstractPageSteps.deleteElementIfExists("Cl-cl Link");
		abstractPageSteps.deleteElementIfExists("Cl-md Link");
		abstractPageSteps.deleteElementIfExists("Md-cl Link");
		abstractPageSteps.deleteElementIfExists("Md-md Link");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client1-Client1");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate3-Mandate3");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl19");
		abstractPageSteps.deleteElementIfExists("mandate-md19");
		abstractPageSteps.deleteElementIfExists("cl-md29");
		abstractPageSteps.deleteElementIfExists("md1-cl29");
	}
}
