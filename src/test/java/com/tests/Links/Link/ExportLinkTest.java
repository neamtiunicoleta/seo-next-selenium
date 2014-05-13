package com.tests.Links.Link;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ExportFiles;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Export.ExportLink.class)
@RunWith(ThucydidesRunner.class)
public class ExportLinkTest extends BaseTest {

	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFiles exportFiles;

	@Test
	public void exportLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.deleteElementIfExists("Cl-cl Link9");
		abstractPageSteps.deleteElementIfExists("Cl-md Link9");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client123-Client123");
		abstractPageSteps.deleteElementIfExists("Client233-Mandate233");
		// create link categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl120");
		abstractPageSteps.deleteElementIfExists("cl-md200");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl120", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md200", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client123-Client123", "client-cl120");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");

		linksPageSteps.createLinkType("Client233-Mandate233", "cl-md200");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create links
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps
				.createInactiveLink("Cl-cl Link9", "Client", "Walters",
						"Client", "Muller", "Client123-Client123",
						"Client client link");
		itemsPageSteps.checkIfElementIsPresent("Cl-cl Link9");

		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createInactiveLink("Cl-md Link9", "Client", "Muller",
				"Mandate", "PAEMandate", "Client233-Mandate233",
				"Client mandate link");
		itemsPageSteps.checkIfElementIsPresent("Cl-md Link9");
		// export
		exportFiles.deleteFilesFromDownloadsFolder("LinksList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("LinksList.xlsx");
		// delete items
		abstractPageSteps.deleteElementIfExists("Cl-cl Link9");
		abstractPageSteps.deleteElementIfExists("Cl-md Link9");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client123-Client123");
		abstractPageSteps.deleteElementIfExists("Client233-Mandate233");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl120");
		abstractPageSteps.deleteElementIfExists("cl-md200");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Links", "exported");
	}
}
