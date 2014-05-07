package com.tests.Countries;

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

@Story(Application.Export.ExportCountries.class)
@RunWith(ThucydidesRunner.class)
public class ExportCountriesTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListCountries() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.deleteElementIfExists("133");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("132", "Edit Risk1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("133", "Edit Risk2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithRisk("aaf3", "NC", "132");
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		exportFiles.deleteFilesFromDownloadsFolder("CountriesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("CountriesList.xlsx");
		abstractPageSteps.deleteElementIfExists("aaf3");
		itemsPageSteps.checkThatElementIsNotPresent("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Countries", "Exported");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.deleteElementIfExists("133");
		itemsPageSteps.checkThatElementIsNotPresent("132");
		itemsPageSteps.checkThatElementIsNotPresent("133");
	}
}
