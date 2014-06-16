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

@Story(Application.Create.CreateCountry.class)
@RunWith(ThucydidesRunner.class)
public class CreateCountryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createCountry() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("CtTest");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("293");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("293", "Edit Risk", "A (Category A)");
		itemsPageSteps.checkIfElementIsPresent("293");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("CtTest");
		itemsPageSteps.inputCodeField("C2");
		itemsPageSteps.selectRisk("293");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("CtTest");
		itemsPageSteps.checkCodeFromGrid("CtTest", "C2");
		itemsPageSteps.checkRiskCriteriaFromGrid("CtTest", "293");
		// delete items
		abstractPageSteps.deleteElementIfExists("CtTest");
		itemsPageSteps.checkThatElementIsNotPresent("CtTest");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("293");
		itemsPageSteps.checkThatElementIsNotPresent("293");
	}

}
