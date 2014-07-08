package com.tests.Links;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Pending;
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

	@Pending
	@Test
	public void editLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		// create mandate

		// create client

		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.deleteElementIfExists("Cl-cl Link1");
		abstractPageSteps.deleteElementIfExists("Cl-md Link1");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client12-Client12");
		abstractPageSteps.deleteElementIfExists("Client23-Mandate23");
		// create link categories
		abstractPageSteps.selectActionFromRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl20");
		abstractPageSteps.deleteElementIfExists("cl-md20");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl20", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md20", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkType("Client1-Client1", "client-cl19");
		abstractPageSteps.selectActionFromRibbon("Create");

		linksPageSteps.createLinkType("Client2-Mandate2", "cl-md29");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create link
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createActiveLink("Cl-cl Link1", "Client", "Walters",
				"Client", "Muller", "Client1-Client1", "Client client link");
		// edit link
		abstractPageSteps.selectItemFromGrid("Cl-cl Link1");
		abstractPageSteps.selectActionFromRibbon("Edit");

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
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client12-Client12");
		abstractPageSteps.deleteElementIfExists("Client23-Mandate23");
		abstractPageSteps.selectActionFromRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl20");
		abstractPageSteps.deleteElementIfExists("cl-md20");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Close");
	}
}
