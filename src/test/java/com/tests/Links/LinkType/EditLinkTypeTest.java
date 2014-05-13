package com.tests.Links.LinkType;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

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

	@Test
	public void editLinkTypeTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// abstractPageSteps.selectMenuOption("Hitlog");
		// itemsPageSteps.clickOnDeleteLogItemsButton();
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client11-Client11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl11");
		abstractPageSteps.deleteElementIfExists("mandate-md11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl11", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("mandate-md11", "Mandate", "Mandate",
				"Mandate-Mandate");
		itemsPageSteps.checkIfElementIsPresent("mandate-md11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client11-Client11", "client-cl11");
		abstractPageSteps.selectItemFromGrid("Client11-Client11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");

		linksPageSteps.inputTitle("Mandate11-Mandate11");
		linksPageSteps.selectLinkCategory("mandate-md11");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("Mandate11-Mandate11");
		linksPageSteps.checkLinkCategory("Mandate11-Mandate11", "mandate-md11");

		abstractPageSteps.deleteElementIfExists("Mandate11-Mandate11");
		itemsPageSteps.checkThatElementIsNotPresent("Mandate11-Mandate11");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");

		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("LinkTypes", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Client11-Client11 from LinkTypes was Added");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Mandate11-Mandate11 from LinkTypes was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Mandate11-Mandate11 from LinkTypes was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Title: Mandate11-Mandate11 from LinkTypes was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "Client11-Client11",
				"Mandate11-Mandate11");
		hitLogPageSteps.checkIfChangesArePresent("LinkCategory", "client-cl11",
				"mandate-md11");
	}
}
