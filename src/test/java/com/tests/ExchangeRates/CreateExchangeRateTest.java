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
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCurrency("384", "g12k", "edit currency",
				"AUSTRIA", "985");
		itemsPageSteps.checkIfElementIsPresent("g12k");
		abstractPageSteps.selectItemFromGrid("g12k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Exchange Rates");
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));
		abstractPageSteps.deleteElementIfExists("Year To Date");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("2", "278");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createExchangeRateWithStartDate("4", "485");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createExchangeRateWithYearToDate("954");
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkEndDate(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"), DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("3")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkIfElementIsPresent(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));
		itemsPageSteps.checkEndDate(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"), "");
		itemsPageSteps.checkIfElementIsPresent("Year To Date");
		itemsPageSteps.checkEndDate("Year To Date", DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("1")),
				"dd/MM/yyyy"));
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("2")),
				"dd/MM/yyyy"));
		abstractPageSteps.deleteElementIfExists(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("4")),
				"dd/MM/yyyy"));
		abstractPageSteps.deleteElementIfExists("Year To Date");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.deleteElementIfExists("g12k");
	}

}
