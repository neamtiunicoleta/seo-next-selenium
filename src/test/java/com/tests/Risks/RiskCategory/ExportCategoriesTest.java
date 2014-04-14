package com.tests.Risks.RiskCategory;

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
public class ExportCategoriesTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void exportListOfCategories() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("136");
		abstractPageSteps.deleteElementIfExists("147");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("136", "First Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("147", "Second Risk");
		exportFiles.deleteFilesFromDownloadsFolder("RiskCategoriesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("RiskCategoriesList.xlsx");

	}
}
