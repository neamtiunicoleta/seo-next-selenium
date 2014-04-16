package com.tests.ExchangeRates;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.AbstractPageSteps;
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
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void editExchangeRate() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCurrency("384", "g12k", "edit currency",
				"AUSTRIA", "985");
		itemsPageSteps.checkIfElementIsPresent("g12k");
		abstractPageSteps.selectItemFromGrid("g12k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Exchange Rates");
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
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
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.deleteElementIfExists("g12k");
	}

}
