package com.tests.ExchangeRates;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.HitLogPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;
import com.tools.DateUtils;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Edit.EditExchangeRate.class)
@RunWith(ThucydidesRunner.class)
public class EditExchangeRateTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editExchangeRate() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
		// create currency
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createActiveCurrency("384", "g12k", "edit currency",
				"AUSTRIA", "985");
		itemsPageSteps.checkIfElementIsPresent("g12k");
		abstractPageSteps.selectItemFromGrid("g12k");
		// create exchange rates
		abstractPageSteps.selectActionFromManagePagesRibbon("Exchange");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectItemFromGrid(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputRate("589");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkRateFromGrid(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"), "589");
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkThatElementIsNotPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.deleteElementIfExists("g12k");
		itemsPageSteps.checkThatElementIsNotPresent("g12k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps
				.checkIfElementIsPresent("Currency: g12k from ExchangeRates was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Currency: g12k from ExchangeRates was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Rate", "278", "589");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Currency: g12k from ExchangeRates was Accessed");
	}

}
