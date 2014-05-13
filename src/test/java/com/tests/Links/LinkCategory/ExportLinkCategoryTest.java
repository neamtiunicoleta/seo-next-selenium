package com.tests.Links.LinkCategory;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFiles;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Export.ExportLinkCategory.class)
@RunWith(ThucydidesRunner.class)
public class ExportLinkCategoryTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;

	@Test
	public void exportLinkCategories() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// abstractPageSteps.selectMenuOption("Hitlog");
		// itemsPageSteps.clickOnDeleteLogItemsButton();
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl1", "Client", "Client",
				"Client-Client");
		itemsPageSteps.checkIfElementIsPresent("client-cl1");
		// export
		exportFiles.deleteFilesFromDownloadsFolder("LinkCategoriesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("LinkCategoriesList.xlsx");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		itemsPageSteps.checkThatElementIsNotPresent("client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("LinkCategories", "Exported");
	}
}
