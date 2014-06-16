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

@Story(Application.Create.CreateExchangeRate.class)
@RunWith(ThucydidesRunner.class)
public class CreateExchangeRateTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Steps
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void createExchangeRate() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("91m");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("91m", "9M");
		itemsPageSteps.checkIfElementIsPresent("91m");
		// create currency
		abstractPageSteps.selectActionFromLeftMenu("Currencies");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("384");
		itemsPageSteps.inputCodeField("g12k");
		itemsPageSteps.inputTitleField("edit currency");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");

		itemsPageSteps.checkIfElementIsPresent("g12k");
		abstractPageSteps.selectItemFromGrid("g12k");
		// create exchange rate
		abstractPageSteps.selectActionFromRibbon("Exchange");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("4", "485");

		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.selectActionFromRibbon("Close");
		// delete items
		abstractPageSteps.deleteElementIfExists("g12k");
		itemsPageSteps.checkThatElementIsNotPresent("g12k");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("91m");
	}

}
