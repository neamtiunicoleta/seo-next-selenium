package com.tests.Offices.OfficeLink;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFilesPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Export.ExportOfficeLink.class)
@RunWith(ThucydidesRunner.class)
public class ExportOfficeLinkTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;

	@Test
	public void exportOfficeLinks() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("OfficeLinks");
		abstractPageSteps.deleteElementIfExists("office 1");
		abstractPageSteps.deleteElementIfExists("office 2");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("office 1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("office 2");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("office 1");
		itemsPageSteps.checkIfElementIsPresent("office 2");
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("OfficeLinksList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("OfficeLinksList.xlsx");
		abstractPageSteps.goToHomePage();
		abstractPageSteps.selectMenuOption("OfficeLinks");
		abstractPageSteps.deleteAllItems();
		itemsPageSteps.checkThatElementIsNotPresent("office 1");
		itemsPageSteps.checkThatElementIsNotPresent("office 2");

	}

}
