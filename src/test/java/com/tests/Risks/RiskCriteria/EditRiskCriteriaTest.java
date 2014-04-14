package com.tests.Risks.RiskCriteria;

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

@Story(Application.Edit.EditRisks.EditRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskCriteriaTest extends BaseTest {
	@Steps
	public CreateItemsPageSteps createItemsPageSteps;
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
		createItemsPageSteps.createRiskCategoryOrAsset("292", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCriteria("293", "Edit Risk", "292");
		abstractPageSteps.selectItemFromGrid("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		createItemsPageSteps.inputDescriptionField("Edit Risk Criteria");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		createItemsPageSteps.checkDescription("293", "Edit Risk Criteria");
		abstractPageSteps.selectItemFromGrid("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.selectItemFromGrid("292");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
	}

}
