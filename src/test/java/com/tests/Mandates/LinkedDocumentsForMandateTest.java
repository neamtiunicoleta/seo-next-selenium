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
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("19f", "19");
		itemsPageSteps.checkIfElementIsPresent("19f");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "19f", "12", "John Doe");
		// create document type
		abstractPageSteps.selectActionFromLeftMenu("Document Types");
		abstractPageSteps.deleteElementIfExists("type1");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("type1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");

		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate 1");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate 1", "cluj",
				"John Doe");
		// upload documents
		abstractPageSteps.selectActionFromLeftMenu("Linked Documents");
		uploadItemsSteps.selectDocumentType("type1");
		uploadItemsSteps.inputDocumentDate("-20");
		uploadItemsSteps.inputAbstract("Upload doc for mandates");
		uploadItemsSteps.clickOnChooseButton();
		uploadItemsSteps.insertFilePath(Constants.FILES_FOLDER
				+ "SEONEXT-Concept.pdf");
		uploadItemsSteps.clickOnUploadDocumentsButton();
		uploadItemsSteps.checkIfDocumentExists("SEONEXT-Concept.pdf");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate 1");
		abstractPageSteps.goToHomePage();
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		itemsPageSteps.checkThatElementIsNotPresent("19f");
		abstractPageSteps.selectActionFromLeftMenu("Document Types");
		abstractPageSteps.deleteElementIfExists("type1");
		itemsPageSteps.checkThatElementIsNotPresent("type1");
	}
}
