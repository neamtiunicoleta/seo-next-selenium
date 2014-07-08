package com.tests.Offices;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ExportFilesPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Export.ExportOffices.class)
@RunWith(ThucydidesRunner.class)
public class ExportOfficesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;

	@Test
	public void exportOffices() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("66f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("66f", "0F");
		itemsPageSteps.checkIfElementIsPresent("66f");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "66f", "12", "John Doe");
		itemsPageSteps.checkIfElementIsPresent("cluj");
		// export
		exportFilesPageSteps.deleteFilesFromDownloadsFolder("OfficesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("OfficesList.xlsx");
	}
}
