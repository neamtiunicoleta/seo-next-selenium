package com.tests.Risks.RiskCriteria;

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

@Story(Application.Create.CreateRisks.CreateRiskCategory.class)
@RunWith(ThucydidesRunner.class)
public class ExportCriteriasTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfCriterias() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("212");
		abstractPageSteps.deleteElementIfExists("125");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("35");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("35", "Category Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("212", "Edit Risk", "35");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("125", "Edit Risk", "35");
		exportFiles.deleteFilesFromDownloadsFolder("RiskCriteriasList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("RiskCriteriasList.xlsx");

	}
}
