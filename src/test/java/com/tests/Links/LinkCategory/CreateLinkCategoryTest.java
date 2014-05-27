package com.tests.Links.LinkCategory;

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

@Story(Application.Create.CreateLinkCategory.class)
@RunWith(ThucydidesRunner.class)
public class CreateLinkCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void createLinkCategoryTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Jane");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		abstractPageSteps.selectActionFromManagePagesRibbon("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("cl-md1");
		abstractPageSteps.deleteElementIfExists("md-cl1");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md1", "Client", "Mandate",
				"Client-Mandate");
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		linksPageSteps.checkSource("cl-md1", "Client");
		linksPageSteps.checkTarget("cl-md1", "Mandate");
		linksPageSteps.checkRelations("cl-md1", "Client-Mandate");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md-cl1", "Mandate", "Client",
				"Mandate-Client");
		itemsPageSteps.checkIfElementIsPresent("md-cl1");
		linksPageSteps.checkSource("md-cl1", "Mandate");
		linksPageSteps.checkTarget("md-cl1", "Client");
		linksPageSteps.checkRelations("md-cl1", "Mandate-Client");
		// delete items
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
