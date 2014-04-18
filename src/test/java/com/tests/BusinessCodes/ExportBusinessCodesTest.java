package com.tests.BusinessCodes;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFiles;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Export.ExportBusinessCodes.class)
@RunWith(ThucydidesRunner.class)
public class ExportBusinessCodesTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListBusinessCodes() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.deleteElementIfExists("595");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.deleteElementIfExists("894");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("78");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("78", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("893", "Edit Risk", "78");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("894", "Edit Risk", "78");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createBusinessCode("594", "Kenya", "893");
		itemsPageSteps.checkIfElementIsPresent("594");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createBusinessCode("511", "Kenya", "893");
		itemsPageSteps.checkIfElementIsPresent("511");
		exportFiles.deleteFilesFromDownloadsFolder("BusinessCodesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("BusinessCodesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("BusinessCodes", "Exported");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");

		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.deleteElementIfExists("894");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("78");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
	}
}