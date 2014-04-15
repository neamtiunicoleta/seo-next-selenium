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

@Story(Application.Create.CreateCurrency.class)
@RunWith(ThucydidesRunner.class)
public class CreateCurrencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Steps
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void createCurrency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("562");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.inputKeyField("562");
		itemsPageSteps.inputCodeField("594f");
		itemsPageSteps.inputTitleField("New Currency");
		itemsPageSteps.selectCountry("ANDORRA");
		itemsPageSteps.inputRoundingValue("345");
		itemsPageSteps.checkActive();
		itemsPageSteps.checkHighImportance();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("594f");
		itemsPageSteps.checkRoundingValue("594f", "345");
		itemsPageSteps.checkCountry("594f", "ANDORRA");
		abstractPageSteps.deleteElementIfExists("594f");
	}

}
