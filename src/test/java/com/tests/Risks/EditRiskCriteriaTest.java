package com.tests.Risks;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskCriteriaTest extends BaseTest {
	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("293");
		// create risk criterias
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("293", "Edit Risk", "D (Category D)");
		itemsPageSteps.checkIfElementIsPresent("293");
		abstractPageSteps.selectItemFromGrid("293");
		// edit
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputDescriptionField("Edit Risk Criteria");
		itemsPageSteps.selectRisk("C (Category C)");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("293");
		itemsPageSteps.checkDescriptionFromGrid("293", "Edit Risk Criteria");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("293", "C");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("293");
		// delete items
		abstractPageSteps.deleteElementIfExists("293");
		itemsPageSteps.checkThatElementIsNotPresent("293");
	}

}
