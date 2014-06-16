package com.tests.ExchangeRates;

import java.util.Date;

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
import com.tools.DateUtils;

@Story(Application.Export.ExportExchangeRates.class)
@RunWith(ThucydidesRunner.class)
public class ExportExchangeRatesTest extends BaseTest {

	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfExchangeRates() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g68k");
		// create currency
		abstractPageSteps.selectActionFromRibbon("Create");

		itemsPageSteps.inputKeyField("381");
		itemsPageSteps.inputCodeField("g68k");
		itemsPageSteps.inputTitleField("edit currency");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("g68k");
		abstractPageSteps.selectItemFromGrid("g68k");
		// create exchange rates
		abstractPageSteps.selectActionFromRibbon("Exchange");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("4", "204");
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));
		// export
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("ExchangeRatesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("ExchangeRatesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.deleteElementIfExists("g68k");
	}
}
