package com.tests.Currencies;

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

@Story(Application.Export.ExportCurrencies.class)
@RunWith(ThucydidesRunner.class)
public class ExportCurrenciesTest extends BaseTest {

	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void exportListOfCurrencies() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("a67b");
		abstractPageSteps.deleteElementIfExists("a68b");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("8km");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("8km", "8K");
		itemsPageSteps.checkIfElementIsPresent("8km");
		abstractPageSteps.selectActionFromLeftMenu("Currencies");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("67");
		itemsPageSteps.inputCodeField("a67b");
		itemsPageSteps.inputTitleField("Euro");
		itemsPageSteps.clickOnHighImportanceCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("68");
		itemsPageSteps.inputCodeField("a68b");
		itemsPageSteps.inputTitleField("Euro");
		itemsPageSteps.clickOnHighImportanceCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("a67b");
		itemsPageSteps.checkIfElementIsPresent("a68b");
		// export
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("CurrenciesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("CurrenciesList.xlsx");
		// delete items
		abstractPageSteps.goToHomePage();
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteAllItems();
		itemsPageSteps.checkThatElementIsNotPresent("a67b");
		itemsPageSteps.checkThatElementIsNotPresent("a68b");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("8km");
	}
}
