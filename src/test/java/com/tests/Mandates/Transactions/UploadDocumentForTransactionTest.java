package com.tests.Mandates.Transactions;

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
import com.tools.AbstractPageSteps;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Upload.UploadForTransactions.class)
@RunWith(ThucydidesRunner.class)
public class UploadDocumentForTransactionTest extends BaseTest {
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public AbstractPageSteps abstractPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public UploadItemsSteps uploadItemsSteps;

	@Test
	public void uploadDocumentForTransaction() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("Euro");
		abstractPageSteps.deleteElementIfExists("g56h");
		// create currency
		abstractPageSteps.selectActionFromLeftMenu("Currencies");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("Euro");
		itemsPageSteps.inputCodeField("Euro");
		itemsPageSteps.inputTitleField("edit currency");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("384");
		itemsPageSteps.inputCodeField("g56h");
		itemsPageSteps.inputTitleField("edit currency");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");

		itemsPageSteps.checkIfElementIsPresent("g56h");
		abstractPageSteps.selectItemFromGrid("g56h");
		// create exchange rate
		abstractPageSteps.selectActionFromRibbon("Exchange");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("0", "278");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		// create document type
		abstractPageSteps.selectActionFromLeftMenu("Document Types");
		abstractPageSteps.deleteElementIfExists("type1");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("type1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");

		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate10");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate10", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Transactions");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		mandatesPageSteps.selectPayment("Non Cash");
		mandatesPageSteps.selectDirection("Outgoing");
		mandatesPageSteps.inputDateOfTransaction("50");
		mandatesPageSteps.inputAmountFX("112");
		mandatesPageSteps.selectCurrency("g56h");
		mandatesPageSteps.inputPlausability("Test");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		mandatesPageSteps.checkIfTransactionExists("50");
		mandatesPageSteps.selectTransactionFromGrid("50");

		abstractPageSteps.selectActionFromRibbon("Documents");
		uploadItemsSteps.selectDocumentType("type1");
		uploadItemsSteps.inputDocumentDate("-20");
		uploadItemsSteps.inputAbstract("Upload doc for mandates");
		uploadItemsSteps.clickOnChooseButton();
		uploadItemsSteps.insertFilePath(Constants.FILES_FOLDER
				+ "SEONEXT-Concept.pdf");
		uploadItemsSteps.clickOnUploadDocumentsButton();
		uploadItemsSteps.checkIfDocumentExists("SEONEXT-Concept.pdf");
		abstractPageSteps.selectActionFromRibbon("Close");
		// delete items
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate10");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("Euro");
		itemsPageSteps.checkThatElementIsNotPresent("Euro");
		abstractPageSteps.deleteElementIfExists("g56h");
		itemsPageSteps.checkThatElementIsNotPresent("g56h");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("92m");
		itemsPageSteps.checkThatElementIsNotPresent("92m");
		abstractPageSteps.selectActionFromLeftMenu("Document Types");
		abstractPageSteps.deleteElementIfExists("type1");
		itemsPageSteps.checkThatElementIsNotPresent("type1");
	}
}
