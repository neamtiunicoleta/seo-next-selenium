package com.tests.Links.LinkCategory;

import org.junit.Test;
import org.junit.runner.RunWith;

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

	@Test
	public void createLinkCategoryTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("cl-cl1");
		abstractPageSteps.deleteElementIfExists("cl-md1");
		abstractPageSteps.deleteElementIfExists("md-md1");
		abstractPageSteps.deleteElementIfExists("md-cl1");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-cl1", "Client", "Client",
				"Client-Client");
		itemsPageSteps.checkIfElementIsPresent("cl-cl1");
		linksPageSteps.checkSource("cl-cl1", "Client");
		linksPageSteps.checkTarget("cl-cl1", "Client");
		linksPageSteps.checkRelations("cl-cl1", "Client-Client");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md1", "Client", "Mandate",
				"Client-Mandate");
		itemsPageSteps.checkIfElementIsPresent("cl-md1");
		linksPageSteps.checkSource("cl-md1", "Client");
		linksPageSteps.checkTarget("cl-md1", "Mandate");
		linksPageSteps.checkRelations("cl-md1", "Client-Mandate");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md-md1", "Mandate", "Mandate",
				"Mandate-Mandate");
		itemsPageSteps.checkIfElementIsPresent("md-md1");
		linksPageSteps.checkSource("md-md1", "Mandate");
		linksPageSteps.checkTarget("md-md1", "Mandate");
		linksPageSteps.checkRelations("md-md1", "Mandate-Mandate");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("md-cl1", "Mandate", "Client",
				"Mandate-Client");
		itemsPageSteps.checkIfElementIsPresent("md-cl1");
		linksPageSteps.checkSource("md-cl1", "Mandate");
		linksPageSteps.checkTarget("md-cl1", "Client");
		linksPageSteps.checkRelations("md-cl1", "Mandate-Client");

		abstractPageSteps.deleteElementIfExists("cl-cl1");
		itemsPageSteps.checkThatElementIsNotPresent("cl-cl1");
		abstractPageSteps.deleteElementIfExists("cl-md1");
		itemsPageSteps.checkThatElementIsNotPresent("cl-md1");
		abstractPageSteps.deleteElementIfExists("md-md1");
		itemsPageSteps.checkThatElementIsNotPresent("md-md1");
		abstractPageSteps.deleteElementIfExists("md-cl1");
		itemsPageSteps.checkThatElementIsNotPresent("md-cl1");
	}
}
