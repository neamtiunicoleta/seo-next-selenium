package com.tests.Links.LinkType;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFiles;
import com.steps.HitLogPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Export.ExporttLinkType.class)
@RunWith(ThucydidesRunner.class)
public class ExportLinkTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public ExportFiles exportFiles;

	@Test
	public void exportLinkTypeTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// abstractPageSteps.selectMenuOption("Hitlog");
		// itemsPageSteps.clickOnDeleteLogItemsButton();
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Links");
		abstractPageSteps.selectActionFromManagePagesRibbon("Types");
		abstractPageSteps.deleteElementIfExists("Client1-Client1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkCategory("client-cl1", "Client", "Client",
				"Client-Client");

		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		linksPageSteps.createLinkType("Client1-Client1", "client-cl1");
		itemsPageSteps.checkIfElementIsPresent("Client1-Client1");
		// export
		exportFiles.deleteFilesFromDownloadsFolder("LinkTypesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("LinkTypesList.xlsx");
		// delete items
		abstractPageSteps.deleteElementIfExists("Client1-Client1");
		itemsPageSteps.checkThatElementIsNotPresent("Client1-Client1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("client-cl1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("LinkTypes", "Exported");

	}

}
