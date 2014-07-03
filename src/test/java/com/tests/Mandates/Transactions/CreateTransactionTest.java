package com.tests.Mandates.Transactions;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.MandatesPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.AbstractPageSteps;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateTransactions.class)
@RunWith(ThucydidesRunner.class)
public class CreateTransactionTest extends BaseTest {

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

	@Test
	public void createTransaction() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("Euro");
		abstractPageSteps.deleteElementIfExists("g78k");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("92m");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("92m", "92");
		itemsPageSteps.checkIfElementIsPresent("92m");
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
		itemsPageSteps.inputCodeField("g78k");
		itemsPageSteps.inputTitleField("edit currency");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");

		itemsPageSteps.checkIfElementIsPresent("g78k");
		abstractPageSteps.selectItemFromGrid("g78k");
		// create exchange rate
		abstractPageSteps.selectActionFromRibbon("Exchange");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("0", "278");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate00");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate00", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Transactions");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		mandatesPageSteps.selectPayment("Non Cash");
		mandatesPageSteps.selectDirection("Outgoing");
		mandatesPageSteps.inputDateOfTransaction("50");
		mandatesPageSteps.inputAmountFX("112");
		mandatesPageSteps.selectCurrency("g78k");

		mandatesPageSteps.selectOriginOfFunds("92m");
		mandatesPageSteps.inputNameOfBank("abcd");
		mandatesPageSteps.inputSenderOrRecipient("John");
		mandatesPageSteps.inputRelationWithMandate("test");
		mandatesPageSteps.inputPlausability("Test");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		mandatesPageSteps.checkIfTransactionExists("50");
		mandatesPageSteps.selectTransactionFromGrid("50");
		abstractPageSteps.selectActionFromRibbon("View");
		mandatesPageSteps.checkTransactionInformation("Non Cash", "Outgoing",
				"50", "g78", "112.00", "31,136.00", "John", "test", "92m",
				"abcd", "Test");

		// edit and add link to transaction!!!!!

		// delete items
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate00");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("Euro");
		itemsPageSteps.checkThatElementIsNotPresent("Euro");
		abstractPageSteps.deleteElementIfExists("g78k");
		itemsPageSteps.checkThatElementIsNotPresent("g78k");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("92m");
		itemsPageSteps.checkThatElementIsNotPresent("92m");
	}
}
