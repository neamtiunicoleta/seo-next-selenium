package com.tests.Currencies;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.HitLogPageSteps;
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
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editCurrency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
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
		itemsPageSteps.clickOnActiveCheckBox();
		itemsPageSteps.clickOnHighImportanceCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("g60k");
		itemsPageSteps.checkTitleFromGrid("g60k", "Euro");
		itemsPageSteps.checkCountryFromGrid("g60k", "ANGOLA");
		itemsPageSteps.checkRoundingValueFromGrid("g60k", "112");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("g60k");
		itemsPageSteps.checkIfHighImportanceCheckBoxIsNotChecked("g60k");
		abstractPageSteps.deleteElementIfExists("g60k");
		itemsPageSteps.checkThatElementIsNotPresent("g60k");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Currencies", "Accessed");

		itemsPageSteps
				.checkIfElementIsPresent("ISOCode: g59k from Currencies was Added");
		itemsPageSteps
				.checkIfElementIsPresent("ISOCode: g60k from Currencies was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("ISOCode: g60k from Currencies was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("ISOCode: g60k from Currencies was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "USD", "Euro");
		hitLogPageSteps.checkIfChangesArePresent("ISOCode", "g59k", "g60k");
		hitLogPageSteps
				.checkIfChangesArePresent("Country", "AUSTRIA", "ANGOLA");
		hitLogPageSteps.checkIfChangesArePresent("RoundingValue", "985", "112");
		hitLogPageSteps.checkIfChangesArePresent("Active", "True", "False");
		hitLogPageSteps.checkIfChangesArePresent("HighImportance", "True",
				"False");
	}

}
