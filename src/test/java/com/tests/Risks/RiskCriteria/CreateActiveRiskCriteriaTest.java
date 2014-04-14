package com.tests.Risks.RiskCriteria;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.CreateItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateRisks.CreateRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class CreateActiveRiskCriteriaTest extends BaseTest {

	@Steps
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void createActiveRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("20");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("292", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.inputKeyField("20");
		createItemsPageSteps.inputDescriptionField("Seo Next");
		createItemsPageSteps.selectRisk("292");
		createItemsPageSteps.checkActive();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.checkIfElementExists("20");
		createItemsPageSteps.checkDescription("20", "Seo Next");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.checkThatCategoryExists("20");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("20");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");

	}
}
