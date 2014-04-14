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
public class CreateInactiveRiskCriteriaTest extends BaseTest {

	@Steps
	public CreateItemsPageSteps creaeItemsPageSteps;

	@Test
	public void createInactiveRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("52");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("285");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		creaeItemsPageSteps.createRiskCategoryOrAsset("285", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		creaeItemsPageSteps.inputKeyField("52");
		creaeItemsPageSteps.inputDescriptionField("Seo Next");
		creaeItemsPageSteps.selectRisk("285");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.checkIfElementExists("52");
		creaeItemsPageSteps.checkDescription("52", "Seo Next");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		creaeItemsPageSteps.checkThatCategoryDoesntExist("52");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectItemFromGrid("52");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.selectItemFromGrid("285");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();

	}
}
