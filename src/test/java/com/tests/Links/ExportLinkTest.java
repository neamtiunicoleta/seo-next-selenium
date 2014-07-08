package com.tests.Links;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ExportFilesPageSteps;
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
	public ExportFilesPageSteps exportFilesPageSteps;

	@Pending
	@Test
	public void exportLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.deleteElementIfExists("Cl-cl Link9");
		abstractPageSteps.deleteElementIfExists("Cl-md Link9");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client123-Client123");
		abstractPageSteps.deleteElementIfExists("Client233-Mandate233");
		// create link categories
		abstractPageSteps.selectActionFromRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl120");
		abstractPageSteps.deleteElementIfExists("cl-md200");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl120", "Client", "Client",
				"Client-Client");
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkCategory("cl-md200", "Client", "Mandate",
				"Client-Mandate");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create link types
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createLinkType("Client123-Client123", "client-cl120");
		abstractPageSteps.selectActionFromRibbon("Create");

		linksPageSteps.createLinkType("Client233-Mandate233", "cl-md200");
		abstractPageSteps.selectActionFromRibbon("Close");
		// create links
		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps
				.createInactiveLink("Cl-cl Link9", "Client", "Walters",
						"Client", "Muller", "Client123-Client123",
						"Client client link");
		itemsPageSteps.checkIfElementIsPresent("Cl-cl Link9");

		abstractPageSteps.selectActionFromRibbon("Create");
		linksPageSteps.createInactiveLink("Cl-md Link9", "Client", "Muller",
				"Mandate", "PAEMandate", "Client233-Mandate233",
				"Client mandate link");
		itemsPageSteps.checkIfElementIsPresent("Cl-md Link9");
		// export
		exportFilesPageSteps.deleteFilesFromDownloadsFolder("LinksList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("LinksList.xlsx");
		// delete items
		abstractPageSteps.deleteElementIfExists("Cl-cl Link9");
		abstractPageSteps.deleteElementIfExists("Cl-md Link9");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client123-Client123");
		abstractPageSteps.deleteElementIfExists("Client233-Mandate233");
		abstractPageSteps.selectActionFromRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl120");
		abstractPageSteps.deleteElementIfExists("cl-md200");
	}
}
