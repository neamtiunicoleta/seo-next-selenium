package com.tests.Risks.RiskAsset;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.CreateItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateRisks.CreateRiskAsset.class)
@RunWith(ThucydidesRunner.class)
public class CreateRiskAssetTest extends BaseTest {

	@Steps
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void createRiskAsset() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("120");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.inputKeyField("120");
		createItemsPageSteps.inputDescriptionField("Seo Risk");
		createItemsPageSteps.checkActive();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.checkIfElementExists("120");
		createItemsPageSteps.checkDescription("120", "Seo Risk");
		abstractPageSteps.selectItemFromGrid("120");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
	}

}