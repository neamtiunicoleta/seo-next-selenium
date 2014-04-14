package com.tests.Risks.RiskAsset;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.CreateItemsPageSteps;
import com.tests.BaseTest;
import com.tools.AbstractPageSteps;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditRisks.EditRiskAssets.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskAssetTest extends BaseTest {
	@Steps
	public CreateItemsPageSteps createItemsPageSteps;
	@Steps
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void editRiskAsset() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("21");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("21", "Edit Risk");
		abstractPageSteps.selectItemFromGrid("21");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		createItemsPageSteps.inputDescriptionField("Edit Risk Category");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		createItemsPageSteps.checkDescription("21", "Edit Risk Category");
		abstractPageSteps.selectItemFromGrid("21");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
	}

}
