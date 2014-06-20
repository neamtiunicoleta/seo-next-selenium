package com.tests.Risks;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class CreateInactiveRiskCriteriaTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createInactiveRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("52");
		// create risk criteria
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("52");
		itemsPageSteps.inputDescriptionField("Seo Next");
		itemsPageSteps.selectRisk("A (Category A)");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("52");
		itemsPageSteps.checkDescriptionFromGrid("52", "Seo Next");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("52", "A");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("52");
		// check in risk criteria in business codes
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.checkThatCategoryDoesntExist("52");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		// delete items
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("52");
		itemsPageSteps.checkThatElementIsNotPresent("52");
	}
}
