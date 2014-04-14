package com.tests.Risks.RiskCriteria;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateRisks.CreateRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class CreateActiveRiskCriteriaTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createActiveRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("20");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("292", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.inputKeyField("20");
		itemsPageSteps.inputDescriptionField("Seo Next");
		itemsPageSteps.selectRisk("292");
		itemsPageSteps.checkActive();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("20");
		itemsPageSteps.checkDescription("20", "Seo Next");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.checkThatCategoryExists("20");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("20");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");

	}
}
