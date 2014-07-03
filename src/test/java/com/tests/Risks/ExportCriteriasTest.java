package com.tests.Risks;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFilesPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Export.ExportRiskCriterias.class)
@RunWith(ThucydidesRunner.class)
public class ExportCriteriasTest extends BaseTest {

	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfCriterias() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("212");
		abstractPageSteps.deleteElementIfExists("125");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("212", "Edit Risk", "A (Category A)");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("125", "Edit Risk", "A (Category A)");
		// export
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("RiskCriteriasList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("RiskCriteriasList.xlsx");
		// delete items
		abstractPageSteps.deleteElementIfExists("212");
		itemsPageSteps.checkThatElementIsNotPresent("212");
		abstractPageSteps.deleteElementIfExists("125");
		itemsPageSteps.checkThatElementIsNotPresent("125");
	}
}
