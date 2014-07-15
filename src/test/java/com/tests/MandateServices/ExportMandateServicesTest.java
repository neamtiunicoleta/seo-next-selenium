package com.tests.MandateServices;

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

@Story(Application.Export.ExportMandateServices.class)
@RunWith(ThucydidesRunner.class)
public class ExportMandateServicesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;

	@Test
	public void exportMandateServices() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Mandate Services");
		abstractPageSteps.deleteElementIfExists("896");
		abstractPageSteps.deleteElementIfExists("897");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("896");
		itemsPageSteps.inputServiceDescription("service1");
		itemsPageSteps.selectMandateServiceType("Non AML");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("897");
		itemsPageSteps.inputServiceDescription("service2");
		itemsPageSteps.selectMandateServiceType("Non AML");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("896");
		itemsPageSteps.checkIfElementIsPresent("897");
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("MandateServicesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("MandateServicesList.xlsx");
		abstractPageSteps.deleteElementIfExists("896");
		itemsPageSteps.checkThatElementIsNotPresent("896");
		abstractPageSteps.deleteElementIfExists("897");
		itemsPageSteps.checkThatElementIsNotPresent("897");

	}

}
