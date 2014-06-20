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
public class CreateActiveRiskCriteriaTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createActiveRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("20");
		// create risk criteria
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("20");
		itemsPageSteps.inputDescriptionField("Seo Next");
		itemsPageSteps.selectRisk("B (Category B)");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("20");
		itemsPageSteps.checkDescriptionFromGrid("20", "Seo Next");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("20", "B");
		itemsPageSteps.checkIfActiveCheckBoxIsChecked("20");
		// check in risk criteria in business codes
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.selectRisk("20");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		// delete items
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("20");
		itemsPageSteps.checkThatElementIsNotPresent("20");

	}
}
