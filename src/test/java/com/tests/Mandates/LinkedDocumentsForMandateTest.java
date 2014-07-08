package com.tests.Mandates;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.MandatesPageSteps;
import com.steps.SearchPageSteps;
import com.steps.UploadItemsSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Upload.UploadForMandates.class)
@RunWith(ThucydidesRunner.class)
public class LinkedDocumentsForMandateTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public UploadItemsSteps uploadItemsSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void UploadDocumentsForMandates() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		// create document type
		abstractPageSteps.selectActionFromLeftMenu("Document Types");
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

		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate 1");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate 1", "cluj",
				"John Doe");
		// upload documents
		abstractPageSteps.selectActionFromLeftMenu("Linked Documents");
		uploadItemsSteps.selectDocumentType("type2");
		uploadItemsSteps.inputDocumentDate("-20");
		uploadItemsSteps.inputAbstract("Upload doc for mandates");
		uploadItemsSteps.clickOnChooseButton();
		uploadItemsSteps.insertFilePath(Constants.FILES_FOLDER
				+ "SEONEXT-Concept.pdf");
		uploadItemsSteps.clickOnUploadDocumentsButton();
		uploadItemsSteps.checkIfDocumentExists("SEONEXT-Concept.pdf");
		uploadItemsSteps.checkDocumentInformation("SEONEXT-Concept.pdf",
				"type2", "-20", "Upload doc for mandates");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate 1");
		abstractPageSteps.goToHomePage();
		abstractPageSteps.selectMenuOption("Document Types");
		abstractPageSteps.deleteElementIfExists("type1");
		itemsPageSteps.checkThatElementIsNotPresent("type1");
		abstractPageSteps.deleteElementIfExists("type2");
		itemsPageSteps.checkThatElementIsNotPresent("type2");
	}
}
