package com.tests.DocumentType;

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

@Story(Application.Export.ExportOfficeLink.class)
@RunWith(ThucydidesRunner.class)
public class ExportDocumentTypesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;

	@Test
	public void exportDocumentType() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Document Types");
		abstractPageSteps.deleteElementIfExists("type1");
		abstractPageSteps.deleteElementIfExists("type2");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("type1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("type2");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("type1");
		itemsPageSteps.checkIfElementIsPresent("type2");
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("DocumentTypesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("DocumentTypesList.xlsx");
		abstractPageSteps.deleteElementIfExists("type1");
		itemsPageSteps.checkThatElementIsNotPresent("type1");
		abstractPageSteps.deleteElementIfExists("type2");
		itemsPageSteps.checkThatElementIsNotPresent("type2");

	}

}
