package com.tests.Links;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
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
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void createLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create mandate

		// create client
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.deleteElementIfExists("Doe Joe");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("Light","Argentina", "Doe", "Joe");
		abstractPageSteps.selectActionFromRibbon("Save");
		abstractPageSteps.selectActionFromRibbon("Links");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		// create linkCategories
		abstractPageSteps.selectActionFromRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("cl-md29");
		abstractPageSteps.deleteElementIfExists("md1-cl29");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md29", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkCategory("md1-cl29", "Mandate", "Client",
				"Mandate-Client");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create linkTypes
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkType("Client2-Mandate2", "cl-md29");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkType("Mandate4-Client4", "md1-cl29");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create links

		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createActiveLink("Cl-md Link", "Client", "Walters",
				"Mandate", "PAEMandate", "Client2-Mandate2",
				"Client mandate link");
		itemsPageSteps.checkIfElementIsPresent("Cl-md Link");
		linksPageSteps.checkSource("Cl-cmd Link", "Client Walters");
		linksPageSteps.checkTarget("Cl-md Link", "Mandate PAEMandate");
		linksPageSteps.checkLinkType("Cl-md Link", "Client2-Mandate2");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-md Link");

		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createActiveLink("Md-cl Link", "Mandate", "MTPMandate",
				"Client", "Muller", "Mandate4-Client4", "Mandate client link");
		itemsPageSteps.checkIfElementIsPresent("Md-cl Link");
		linksPageSteps.checkSource("Md-cl Link", "Mandate MTPMandate");
		linksPageSteps.checkTarget("Md-cl Link", "Client Muller");
		linksPageSteps.checkLinkType("Md-cl Link", "Mandate4-Client4");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Md-cl Link");

		// activate links

		abstractPageSteps.selectItemFromGrid("Cl-md Link");
		abstractPageSteps.selectItemFromGrid("Md-cl Link");
		abstractPageSteps.selectActionFromRibbon("Activate");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Cl-md Link");
		linksPageSteps.checkIfActiveCheckBoxIsChecked("Md-cl Link");

		// deactivate links
		abstractPageSteps.selectItemFromGrid("Cl-md Link");
		abstractPageSteps.selectItemFromGrid("Md-cl Link");
		abstractPageSteps.selectActionFromRibbon("Deactivate");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Cl-md Link");
		linksPageSteps.checkIfActiveCheckBoxIsNotChecked("Md-cl Link");

		// delete items
		abstractPageSteps.deleteElementIfExists("Cl-md Link");
		abstractPageSteps.deleteElementIfExists("Md-cl Link");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client2-Mandate2");
		abstractPageSteps.deleteElementIfExists("Mandate4-Client4");
		abstractPageSteps.selectActionFromRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("cl-md29");
		abstractPageSteps.deleteElementIfExists("md1-cl29");
	}
}
