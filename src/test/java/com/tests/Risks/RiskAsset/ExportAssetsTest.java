package com.tests.Risks.RiskAsset;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.CreateItemsPageSteps;
import com.steps.ExportFiles;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateRisks.CreateRiskCategory.class)
@RunWith(ThucydidesRunner.class)
public class ExportAssetsTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void exportListOfAssets() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("13");
		abstractPageSteps.deleteElementIfExists("14");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("13", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("14", "Edit Risk");
		exportFiles.deleteFilesFromDownloadsFolder("RiskAssetsList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("RiskAssetsList.xlsx");

	}
}
