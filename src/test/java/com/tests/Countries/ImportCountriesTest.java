package com.tests.Countries;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.steps.UploadAssetsSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Import.ImportCountries.class)
@RunWith(ThucydidesRunner.class)
public class ImportCountriesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public UploadAssetsSteps uploadAssetsSteps;

	@Test
	public void importCountries() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.selectActionFromManagePagesRibbon("Import");
		uploadAssetsSteps.clickOnSelectFilesButton();
		uploadAssetsSteps.insertFilePath(Constants.FILES_FOLDER
				+ "CountriesCodes.xlsx");
		uploadAssetsSteps.clickOnUploadFileButton();
		itemsPageSteps.checkIfElementIsPresent("ALBANIA");
		itemsPageSteps.checkIfElementIsPresent("CANADA");
		itemsPageSteps.checkIfElementIsPresent("FRANCE");
	}
}
