package com.tests.Countries;

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

@Story(Application.Export.ExportCountries.class)
@RunWith(ThucydidesRunner.class)
public class ExportCountriesTest extends BaseTest {

	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListCountries() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("aaf3");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("315");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("315", "Edit Risk", "C (Category C)");
		itemsPageSteps.checkIfElementIsPresent("315");
		// create countries
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithRisk("aaf3", "NC", "315");
		// export
		itemsPageSteps.checkIfElementIsPresent("aaf3(*)");
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("CountriesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("CountriesList.xlsx");
		abstractPageSteps.deleteElementIfExists("aaf3(*)");
		itemsPageSteps.checkThatElementIsNotPresent("aaf3(*)");
		// delete items
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("315");
		itemsPageSteps.checkThatElementIsNotPresent("315");
	}
}
