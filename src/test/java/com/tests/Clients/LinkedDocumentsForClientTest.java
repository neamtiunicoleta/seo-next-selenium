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
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("19f", "9F");
		itemsPageSteps.checkIfElementIsPresent("19f");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "19f", "12", "John Doe");
		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Jane doe");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("cluj", "Doe",
				"Jane");
		// upload documents
		abstractPageSteps.selectActionFromLeftMenu("Linked Documents");
		uploadItemsSteps.selectDocumentType("Other");
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
		clientsPageSteps.checkThatClientDoesntExists("Jane Doe");
	}
}
