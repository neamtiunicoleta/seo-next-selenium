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
public class CreateActiveRiskCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createActiveRiskCategory() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("196");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.inputKeyField("196");
		itemsPageSteps.inputDescriptionField("Seo Risk");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("196");
		itemsPageSteps.checkDescriptionFromGrid("196", "Seo Risk");
		itemsPageSteps.checkIfActiveCheckBoxIsChecked("196");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		//check risk category in risk criterias
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.checkThatCategoryExists("196");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("196");
		itemsPageSteps.checkThatElementIsNotPresent("196");
	}

}
