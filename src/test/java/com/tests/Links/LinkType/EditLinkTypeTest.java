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
		 abstractPageSteps.deleteElementIfExists("Client1-Client1");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		 abstractPageSteps.deleteElementIfExists("client-cl1");
		 abstractPageSteps.deleteElementIfExists("mandate-md1");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkCategory("client-cl1", "Client", "Client",
		 "Client-Client");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkCategory("mandate-md1", "Mandate",
		 "Mandate",
		 "Mandate-Mandate");
		 itemsPageSteps.checkIfElementIsPresent("mandate-md1");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		
		 abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		 linksPageSteps.createLinkType("Client1-Client1", "client-cl1");
		 abstractPageSteps.selectItemFromGrid("Client1-Client1");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		
		 linksPageSteps.inputTitle("Mandate1-Mandate1");
		 linksPageSteps.selectLinkCategory("mandate-md1");
		 abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		 itemsPageSteps.checkIfElementIsPresent("Mandate1-Mandate1");
		 linksPageSteps.checkLinkCategory("Mandate1-Mandate1", "mandate-md1");
		
		 abstractPageSteps.deleteElementIfExists("Mandate1-Mandate1");
		 itemsPageSteps.checkThatElementIsNotPresent("Mandate1-Mandate1");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		 abstractPageSteps.selectActionFromManagePagesRibbon("Close");

		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("LinkTypes", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Client1-Client1 from LinkTypes was Added");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Mandate1-Mandate1 from LinkTypes was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Title: Mandate1-Mandate1 from LinkTypes was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Title: Mandate1-Mandate1 from LinkTypes was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "Client1-Client1",
				"Mandate1-Mandate1");
		hitLogPageSteps.checkIfChangesArePresent("LinkCategory", "client-cl1",
				"mandate-md1");
	}
}
