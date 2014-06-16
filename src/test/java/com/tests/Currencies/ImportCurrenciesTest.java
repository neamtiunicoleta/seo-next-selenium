package com.tests.Currencies;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.steps.UploadItemsSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Import.ImportCurrencies.class)
@RunWith(ThucydidesRunner.class)
public class ImportCurrenciesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public UploadItemsSteps uploadItemsSteps;

	@Test
	public void importCurrencies() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.selectActionFromRibbon("Import");
		uploadItemsSteps.clickOnSelectFilesButton();
		uploadItemsSteps.insertFilePath(Constants.FILES_FOLDER
				+ "FX rates.xlsx");
		uploadItemsSteps.clickOnUploadFileButton();
		itemsPageSteps.checkIfElementIsPresent("ARS");
		itemsPageSteps.checkIfElementIsPresent("AUD");
		abstractPageSteps.deleteAllItems();
		itemsPageSteps.checkThatElementIsNotPresent("ARS");
		itemsPageSteps.checkThatElementIsNotPresent("AUD");
	}

}
