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

@Story(Application.Create.CreateBusinessCode.class)
@RunWith(ThucydidesRunner.class)
public class CreateBusinessCodeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createBusinessCode() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		// create RiskCriterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("893", "Edit Risk", "B (Category B)");
		// create business code
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputCodeField("594");
		itemsPageSteps.inputTitleField("Kenya");
		itemsPageSteps.selectRisk("893");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("594");
		itemsPageSteps.checkNameForBusinessCodesFromGrid("594", "Kenya");
		itemsPageSteps.checkRiskCriteriaFromGrid("594", "893");
		abstractPageSteps.selectItemFromGrid("594");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		itemsPageSteps.checkThatElementIsNotPresent("594");
		// delete items
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		itemsPageSteps.checkThatElementIsNotPresent("893");
	}

}
