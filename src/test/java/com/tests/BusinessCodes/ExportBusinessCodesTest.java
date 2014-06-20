package com.tests.BusinessCodes;

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

@Story(Application.Export.ExportBusinessCodes.class)
@RunWith(ThucydidesRunner.class)
public class ExportBusinessCodesTest extends BaseTest {

	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListBusinessCodes() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.deleteElementIfExists("595");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.deleteElementIfExists("894");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("893", "Edit Risk", "A (Category A)");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("894", "Edit Risk", "B (Category B)");
		// create business codes
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("594", "Kenya", "893");
		itemsPageSteps.checkIfElementIsPresent("594");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("595", "Kenya", "893");
		itemsPageSteps.checkIfElementIsPresent("595");
		// export
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("BusinessCodesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("BusinessCodesList.xlsx");
		abstractPageSteps.goToHomePage();
		// delete items
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		itemsPageSteps.checkThatElementIsNotPresent("594");
		abstractPageSteps.deleteElementIfExists("595");
		itemsPageSteps.checkThatElementIsNotPresent("595");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		itemsPageSteps.checkThatElementIsNotPresent("893");
		abstractPageSteps.deleteElementIfExists("894");
		itemsPageSteps.checkThatElementIsNotPresent("894");

	}
}
