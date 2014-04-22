package com.tests.Currencies;

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

@Story(Application.Export.ExportCurrencies.class)
@RunWith(ThucydidesRunner.class)
public class ExportCurrenciesTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfCurrencies() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("a67b");
		abstractPageSteps.deleteElementIfExists("a68b");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCurrency("384", "a67b", "export currency",
				"AUSTRIA", "985");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCurrency("325", "a68b", "export currency",
				"ANGOLA", "912");
		itemsPageSteps.checkIfElementIsPresent("a67b");
		itemsPageSteps.checkIfElementIsPresent("a68b");

		exportFiles.deleteFilesFromDownloadsFolder("CurrenciesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("CurrenciesList.xlsx");
		abstractPageSteps.deleteElementIfExists("a67b");
		abstractPageSteps.deleteElementIfExists("a68b");
		itemsPageSteps.checkThatElementIsNotPresent("a67b");
		itemsPageSteps.checkThatElementIsNotPresent("a68b");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Currencies", "Exported");
	}
}
