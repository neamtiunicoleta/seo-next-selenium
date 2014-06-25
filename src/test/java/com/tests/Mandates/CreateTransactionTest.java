package com.tests.Mandates;

import org.junit.Test;
import org.junit.runner.RunWith;

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

	@Test
	public void createTransaction() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
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
		itemsPageSteps.inputKeyField("384");
		itemsPageSteps.inputCodeField("g12k");
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
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		abstractPageSteps.selectActionFromTopMenu("Mandates");
//		searchPageSteps.searchAndDeleteItem("Mandate00");
//		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate00", "cluj",
//				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Transactions");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		mandatesPageSteps.selectPayment("Non Cash");
		mandatesPageSteps.selectDirection("Outgoing");
		mandatesPageSteps.inputDateOfTransaction("50");
		mandatesPageSteps.selectCurrency("g78k");
		mandatesPageSteps.inputAmountFX("112");
	}
}
