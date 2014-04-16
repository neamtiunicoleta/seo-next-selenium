package com.tests.Currencies;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.AbstractPageSteps;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Edit.EditCurrency.class)
@RunWith(ThucydidesRunner.class)
public class EditCurrencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Steps
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void editCurrency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g59k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCurrency("384", "g59k", "USD", "AUSTRIA", "985");
		itemsPageSteps.checkIfElementIsPresent("g59k");
		abstractPageSteps.selectItemFromGrid("g59k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputCodeField("g60k");
		itemsPageSteps.inputTitleField("Euro");
		itemsPageSteps.inputRoundingValue("112");
		itemsPageSteps.selectCountry("ANGOLA");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("g60k");
		itemsPageSteps.checkTitleFromGrid("g60k", "Euro");
		itemsPageSteps.checkCountryFromGrid("g60k", "ANGOLA");
		itemsPageSteps.checkRoundingValueFromGrid("g60k", "112");
		abstractPageSteps.deleteElementIfExists("g60k");
	}

}
