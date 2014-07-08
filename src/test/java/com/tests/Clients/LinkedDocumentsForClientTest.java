package com.tests.Clients;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.SearchPageSteps;
import com.steps.UploadItemsSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Upload.UploadForClients.class)
@RunWith(ThucydidesRunner.class)
public class LinkedDocumentsForClientTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public UploadItemsSteps uploadItemsSteps;

	@Test
	public void UploadDocumentsForClients() {
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
		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Jane Doe");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("cluj", "Doe",
				"Jane");
		// upload documents
		abstractPageSteps.selectActionFromLeftMenu("Linked Documents");
		uploadItemsSteps.selectDocumentType("type2");
		uploadItemsSteps.inputDocumentDate("-20");
		uploadItemsSteps.inputAbstract("Upload doc for clients");
		uploadItemsSteps.clickOnChooseButton();
		uploadItemsSteps.insertFilePath(Constants.FILES_FOLDER
				+ "SEONEXT-Concept.pdf");
		uploadItemsSteps.clickOnUploadDocumentsButton();
		uploadItemsSteps.checkIfDocumentExists("SEONEXT-Concept.pdf");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Jane Doe");
		abstractPageSteps.goToHomePage();
		abstractPageSteps.selectMenuOption("Document Types");
		abstractPageSteps.deleteElementIfExists("type2");
		itemsPageSteps.checkThatElementIsNotPresent("type2");
	}
}
