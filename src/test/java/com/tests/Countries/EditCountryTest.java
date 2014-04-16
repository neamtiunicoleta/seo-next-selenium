package com.tests.Countries;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditCountry.class)
@RunWith(ThucydidesRunner.class)
public class EditCountryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editCountry() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.deleteElementIfExists("133");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("132", "Edit Risk1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("13", "Edit Risk2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("NewCountry");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountry("NewCountry", "NC", "132");
		itemsPageSteps.checkIfElementIsPresent("NewCountry");
		abstractPageSteps.selectItemFromGrid("NewCountry");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		itemsPageSteps.inputTitleField("NewCountry2");
		itemsPageSteps.inputCodeField("CO");
		itemsPageSteps.selectRisk("133");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkCodeFromGrid("NewCountry2", "CO");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("NewCountry2",
				"133");
		abstractPageSteps.deleteElementIfExists("NewCountry2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.deleteElementIfExists("133");
	}

}
