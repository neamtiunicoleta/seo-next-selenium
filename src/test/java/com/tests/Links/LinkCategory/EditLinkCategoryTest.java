package com.tests.Links.LinkCategory;

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

@Story(Application.Edit.EditLinkCategory.class)
@RunWith(ThucydidesRunner.class)
public class EditLinkCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editLinkCategoryTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl1", "Client", "Client",
				"Client-Client");
		itemsPageSteps.checkIfElementIsPresent("client-cl1");
		abstractPageSteps.selectItemFromGrid("client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");

		linksPageSteps.inputTitle("mandate-md2");
		linksPageSteps.selectSourceObject("Mandate");
		linksPageSteps.selectTargetObject("Mandate");
		linksPageSteps.inputRelations("Mandate-Mandate");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("mandate-md2");
		linksPageSteps.checkSourceForLinkCategories("mandate-md2", "Mandate");
		linksPageSteps.checkTargetForLinkCategories("mandate-md2", "Mandate");
		linksPageSteps.checkRelations("mandate-md2", "Mandate-Mandate");

		abstractPageSteps.deleteElementIfExists("mandate-md2");
		itemsPageSteps.checkThatElementIsNotPresent("mandate-cl2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");

		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("LinkCategories", "accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Title: client-cl1 from LinkCategories was Added");
		itemsPageSteps
				.checkIfElementIsPresent("Title: mandate-md2 from LinkCategories was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Title: mandate-md2 from LinkCategories was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Title: mandate-md2 from LinkCategories was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "client-cl1",
				"mandate-md2");
		hitLogPageSteps.checkIfChangesArePresent("SourceObject", "Client",
				"Mandate");
		hitLogPageSteps.checkIfChangesArePresent("TargetObject", "Client",
				"Mandate");
		hitLogPageSteps.checkIfChangesArePresent("Relations", "Client-Client",
				"Mandate-Mandate");
	}
}
