package com.tests.Risks.RiskCriteria;

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

@Story(Application.Edit.EditRisks.EditRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskCriteriaTest extends BaseTest {
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public AbstractPageSteps abstractPageSteps;

	@Test
	public void editRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("292", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("293", "Edit Risk", "292");
		itemsPageSteps.checkIfElementIsPresent("293");
		abstractPageSteps.selectItemFromGrid("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputDescriptionField("Edit Risk Criteria");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("293");
		itemsPageSteps.checkDescription("293", "Edit Risk Criteria");
		abstractPageSteps.deleteElementIfExists("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");
	}

}
