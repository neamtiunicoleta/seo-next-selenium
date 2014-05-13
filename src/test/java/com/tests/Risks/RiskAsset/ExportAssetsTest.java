package com.tests.Risks.RiskAsset;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFiles;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Export.ExportRisks.ExportRiskAssets.class)
@RunWith(ThucydidesRunner.class)
public class ExportAssetsTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfAssets() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("13");
		abstractPageSteps.deleteElementIfExists("14");
		itemsPageSteps.checkThatElementIsNotPresent("13");
		itemsPageSteps.checkThatElementIsNotPresent("14");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("13", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("14", "Edit Risk");
		// export
		exportFiles.deleteFilesFromDownloadsFolder("RiskAssetsList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("RiskAssetsList.xlsx");
		// delete items
		abstractPageSteps.deleteElementIfExists("13");
		abstractPageSteps.deleteElementIfExists("14");
		itemsPageSteps.checkThatElementIsNotPresent("13");
		itemsPageSteps.checkThatElementIsNotPresent("14");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Exported");
	}
}
