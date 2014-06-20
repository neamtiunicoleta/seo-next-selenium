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
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("7ji");
		abstractPageSteps.deleteElementIfExists("9ji");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("7ji", "7J");
		itemsPageSteps.checkIfElementIsPresent("7ji");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("9ji", "9J");
		itemsPageSteps.checkIfElementIsPresent("9ji");
		abstractPageSteps.selectActionFromLeftMenu("Currencies");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createActiveCurrency("384", "g59k", "USD", "9ji", "985");
		itemsPageSteps.checkIfElementIsPresent("g59k");
		abstractPageSteps.selectItemFromGrid("g59k");
		// edit currency
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputCodeField("g60k");
		itemsPageSteps.inputTitleField("Euro");
		itemsPageSteps.selectCountry("7ji");
		itemsPageSteps.clickOnActiveCheckBox();
		itemsPageSteps.clickOnHighImportanceCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("g60k");
		itemsPageSteps.checkTitleFromGrid("g60k", "Euro");
		itemsPageSteps.checkCountryFromGrid("g60k", "7ji");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("g60k");
		itemsPageSteps.checkIfHighImportanceCheckBoxIsNotChecked("g60k");
		abstractPageSteps.deleteElementIfExists("g60k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("7ji");
		itemsPageSteps.checkThatElementIsNotPresent("7ji");
		abstractPageSteps.deleteElementIfExists("9ji");
		itemsPageSteps.checkThatElementIsNotPresent("9ji");
	}

}
