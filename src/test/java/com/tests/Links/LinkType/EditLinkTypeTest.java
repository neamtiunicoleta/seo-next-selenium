package com.tests.Links.LinkType;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
import com.steps.HitLogPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditLinkType.class)
@RunWith(ThucydidesRunner.class)
public class EditLinkTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void editLinkTypeTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Cris");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		abstractPageSteps.selectActionFromManagePagesRibbon("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client11-Mandate11");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-md11");
		abstractPageSteps.deleteElementIfExists("mandate-cl11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-md11", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("mandate-cl11", "Mandate", "Client",
				"Mandate-Client");
		itemsPageSteps.checkIfElementIsPresent("mandate-cl11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client11-Mandate11", "client-md11");
		abstractPageSteps.selectItemFromGrid("Client11-Mandate11");
		// edit link type
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		linksPageSteps.inputTitle("Mandate11-Client11");
		linksPageSteps.selectLinkCategory("mandate-cl11");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("Mandate11-Client11");
		linksPageSteps.checkLinkCategory("Mandate11-Client11", "mandate-cl11");
		// delete items
		abstractPageSteps.deleteElementIfExists("Mandate11-Client11");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate11-Client11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-md11");
		abstractPageSteps.deleteElementIfExists("mandate-cl11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Mandate11-Client11 from LinkTypes was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Title: Mandate11-Client11 from LinkTypes was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "Client11-Mandate11",
				"Mandate11-Client11");
		hitLogPageSteps.checkIfChangesArePresent("LinkCategory", "client-md11",
				"mandate-cl11");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Title: Client11-Mandate11 from LinkTypes was Accessed");
	}
}
