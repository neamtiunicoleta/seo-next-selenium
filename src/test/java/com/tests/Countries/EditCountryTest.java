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
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("aaf3");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("315");
		abstractPageSteps.deleteElementIfExists("316");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("315", "Edit Risk", "A (Category A)");
		itemsPageSteps.checkIfElementIsPresent("315");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("316", "Edit Risk", "B (Category B)");
		itemsPageSteps.checkIfElementIsPresent("316");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithRisk("aaf3", "NC", "315");
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		abstractPageSteps.selectItemFromGrid("aaf3");
		// edit country
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputTitleField("A58kn");
		itemsPageSteps.inputCodeField("C2");
		itemsPageSteps.selectRisk("316");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("A58kn");
		itemsPageSteps.checkCodeFromGrid("A58kn", "C2");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("A58kn", "316");
		// delete items
		abstractPageSteps.deleteElementIfExists("A58kn");
		itemsPageSteps.checkThatElementIsNotPresent("A58kn");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteAllItems();
		itemsPageSteps.checkThatElementIsNotPresent("315");
		itemsPageSteps.checkThatElementIsNotPresent("316");
	}

}
