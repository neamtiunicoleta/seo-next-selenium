package com.tests.Links.LinkCategory;

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

@Story(Application.Edit.EditLinkCategory.class)
@RunWith(ThucydidesRunner.class)
public class EditLinkCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void editLinkCategoryTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Jane");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		abstractPageSteps.selectActionFromManagePagesRibbon("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-md1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-md1", "Client", "Mandate",
				"Client-Mandate");
		itemsPageSteps.checkIfElementIsPresent("client-md1");
		abstractPageSteps.selectItemFromGrid("client-md1");
		// edit
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");

		linksPageSteps.inputTitle("mandate-cl2");
		linksPageSteps.selectSourceObjectType("Mandate");
		linksPageSteps.selectTargetObjectType("Client");
		linksPageSteps.inputRelations("Mandate-Client");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("mandate-cl2");
		linksPageSteps.checkSource("mandate-cl2", "Mandate");
		linksPageSteps.checkTarget("mandate-cl2", "Client");
		linksPageSteps.checkRelations("mandate-cl2", "Mandate-Client");
		// delete items
		abstractPageSteps.deleteElementIfExists("mandate-cl2");
		itemsPageSteps.checkThatElementIsNotPresent("mandate-cl2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps
				.checkIfElementIsPresent("Title: mandate-cl2 from LinkCategories was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Title: mandate-cl2 from LinkCategories was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "client-md1",
				"mandate-cl2");
		hitLogPageSteps.checkIfChangesArePresent("SourceObject", "Client",
				"Mandate");
		hitLogPageSteps.checkIfChangesArePresent("TargetObject", "Mandate",
				"Client");
		hitLogPageSteps.checkIfChangesArePresent("Relations", "Client-Mandate",
				"Mandate-Client");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Title: client-md1 from LinkCategories was Accessed");
	}
}
