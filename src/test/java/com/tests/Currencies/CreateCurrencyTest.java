package com.tests.Currencies;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateCurrency.class)
@RunWith(ThucydidesRunner.class)
public class CreateCurrencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createCurrency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("594f");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("56l");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("56l", "5L");
		itemsPageSteps.checkIfElementIsPresent("56l");
		// create currency
		abstractPageSteps.selectActionFromLeftMenu("Currencies");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("562");
		itemsPageSteps.inputCodeField("594f");
		itemsPageSteps.inputTitleField("Euro");
		itemsPageSteps.clickOnActiveCheckBox();
		itemsPageSteps.clickOnHighImportanceCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("594f");
		itemsPageSteps.checkTitleFromGrid("594f", "Euro");
		itemsPageSteps.checkCountryFromGrid("594f", "56l");
		itemsPageSteps.checkIfActiveCheckBoxIsChecked("594f");
		itemsPageSteps.checkIfHighImportanceCheckBoxIsChecked("594f");
		abstractPageSteps.deleteElementIfExists("594f");
		itemsPageSteps.checkThatElementIsNotPresent("694f");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("56l");
	}

}
