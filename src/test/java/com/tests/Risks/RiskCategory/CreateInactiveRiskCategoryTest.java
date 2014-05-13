package com.tests.Risks.RiskCategory;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateRisks.CreateRiskCategory.class)
@RunWith(ThucydidesRunner.class)
public class CreateInactiveRiskCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createInactiveRiskCategory() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("147");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.inputKeyField("147");
		itemsPageSteps.inputDescriptionField("Seo Risk");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("147");
		itemsPageSteps.checkDescriptionFromGrid("147", "Seo Risk");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("147");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check risk category in risk criterias
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.checkThatCategoryDoesntExist("147");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("147");
		itemsPageSteps.checkThatElementIsNotPresent("147");
	}

}
