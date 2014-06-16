package com.tests.ExchangeRates;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

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

	@Test
	public void editExchangeRate() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
		// create currency

		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("384");
		itemsPageSteps.inputCodeField("g12k");
		itemsPageSteps.inputTitleField("edit currency");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("g12k");
		abstractPageSteps.selectItemFromGrid("g12k");
		// create exchange rates
		abstractPageSteps.selectActionFromRibbon("Exchange");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectItemFromGrid(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
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
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.deleteElementIfExists("g12k");
		itemsPageSteps.checkThatElementIsNotPresent("g12k");
	}

}
