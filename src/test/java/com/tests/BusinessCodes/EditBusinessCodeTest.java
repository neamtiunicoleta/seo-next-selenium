package com.tests.BusinessCodes;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditBusinessode.class)
@RunWith(ThucydidesRunner.class)
public class EditBusinessCodeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editBusinessCode() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.deleteElementIfExists("595");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.deleteElementIfExists("894");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("893", "Edit Risk", "A (Category A)");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("894", "Edit Risk", "B (Category B)");
		// create business code
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("594", "Kenya", "893");
		itemsPageSteps.checkIfElementIsPresent("594");
		abstractPageSteps.selectItemFromGrid("594");
		// edit business code
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputCodeField("595");
		itemsPageSteps.inputTitleField("Germany");
		itemsPageSteps.selectRisk("894");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("595");
		itemsPageSteps.checkNameForBusinessCodesFromGrid("595", "Germany");
		itemsPageSteps.checkRiskCriteriaFromGrid("595", "894");
		abstractPageSteps.deleteElementIfExists("595");
		itemsPageSteps.checkThatElementIsNotPresent("595");
		// delete items
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		itemsPageSteps.checkThatElementIsNotPresent("893");
		abstractPageSteps.deleteElementIfExists("894");
		itemsPageSteps.checkThatElementIsNotPresent("894");
	}
}
