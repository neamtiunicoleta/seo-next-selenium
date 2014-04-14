package com.tests.Risks.RiskCategory;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.AbstractPageSteps;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditRisks.EditRiskCategory.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void editRiskCategory() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("298");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("298", "Edit Risk");
		abstractPageSteps.selectItemFromGrid("298");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputDescriptionField("Edit Risk Category");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("298");
		itemsPageSteps.checkDescription("298", "Edit Risk Category");
		abstractPageSteps.deleteElementIfExists("298");
	}

}
