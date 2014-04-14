package com.tests.Risks.RiskCategory;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.CreateItemsPageSteps;
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
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void createInactiveRiskCategory() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("196");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.inputKeyField("196");
		createItemsPageSteps.inputDescriptionField("Seo Risk");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.checkIfElementExists("196");
		createItemsPageSteps.checkDescription("196", "Seo Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.checkThatCategoryDoesntExist("196");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.selectItemFromGrid("196");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
	}

}
