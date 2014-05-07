package com.tests.ExchangeRates;

import java.util.Date;

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
import com.tools.DateUtils;

@Story(Application.Export.ExportExchangeRates.class)
@RunWith(ThucydidesRunner.class)
public class ExportExchangeRatesTest extends BaseTest {

	@Steps
	public ExportFiles exportFiles;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfExchangeRates() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g68k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createActiveCurrency("384", "g68k", "export exchange rate",
				"AUSTRIA", "985");
		itemsPageSteps.checkIfElementIsPresent("g68k");
		abstractPageSteps.selectItemFromGrid("g68k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Exchange Rates");
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("4", "204");
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));

		exportFiles.deleteFilesFromDownloadsFolder("ExchangeRatesList.xlsx");
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		exportFiles
				.checkIfTheFileHasBeenSuccessfullyDownloaded("ExchangeRatesList.xlsx");
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.deleteElementIfExists("g68k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("ExchangeRates", "Exported");
	}
}
