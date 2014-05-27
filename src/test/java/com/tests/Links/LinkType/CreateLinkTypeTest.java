package com.tests.Links.LinkType;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateLinkType.class)
@RunWith(ThucydidesRunner.class)
public class CreateLinkTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void createLinkTypeTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Cris");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		abstractPageSteps.selectActionFromManagePagesRibbon("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client-Mandate1");
		abstractPageSteps.deleteElementIfExists("Mandate-Client1");
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
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client-Mandate1", "cl-md1");
		itemsPageSteps.checkIfElementIsPresent("Client-Mandate1");
		linksPageSteps.checkLinkCategory("Client-Mandate1", "cl-md1");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Mandate-Client1", "md-cl1");
		itemsPageSteps.checkIfElementIsPresent("Mandate-Client1");
		linksPageSteps.checkLinkCategory("Mandate-Client1", "md-cl1");
		// delete items
		abstractPageSteps.deleteElementIfExists("Client-Mandate1");
		itemsPageSteps.checkThatElementIsNotPresent("Client-Mandate1");
		abstractPageSteps.deleteElementIfExists("Mandate-Client1");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate-Client1");

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
