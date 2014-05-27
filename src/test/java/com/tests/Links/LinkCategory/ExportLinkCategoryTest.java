package com.tests.Links.LinkCategory;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
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
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void exportLinkCategories() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
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
		// export
		exportFiles.deleteFilesFromDownloadsFolder("LinkCategoriesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("LinkCategoriesList.xlsx");
		abstractPageSteps.deleteElementIfExists("client-md1");
		itemsPageSteps.checkThatElementIsNotPresent("client-md1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
	}
}
