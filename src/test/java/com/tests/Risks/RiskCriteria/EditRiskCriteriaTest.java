package com.tests.Risks.RiskCriteria;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.HitLogPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditRisks.EditRiskCriteria.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskCriteriaTest extends BaseTest {
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editRiskCriteria() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("292", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("203", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("293", "Edit Risk", "292");
		itemsPageSteps.checkIfElementIsPresent("293");
		abstractPageSteps.selectItemFromGrid("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputDescriptionField("Edit Risk Criteria");
		itemsPageSteps.selectRisk("203");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("293");
		itemsPageSteps.checkDescriptionFromGrid("293", "Edit Risk Criteria");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("293", "203");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("293");
		abstractPageSteps.deleteElementIfExists("293");
		itemsPageSteps.checkThatElementIsNotPresent("293");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("292");
		abstractPageSteps.deleteElementIfExists("203");
		itemsPageSteps.checkThatElementIsNotPresent("292");
		itemsPageSteps.checkThatElementIsNotPresent("203");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("RiskCriterias", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 293 from RiskCriterias was Added");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 293 from RiskCriterias was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 293 from RiskCriterias was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Key: 293 from RiskCriterias was Changed");
		hitLogPageSteps.checkIfChangesArePresent("RiskCategory", "292", "203");
		hitLogPageSteps.checkIfChangesArePresent("Description", "Edit Risk",
				"Edit Risk Criteria");
		hitLogPageSteps.checkIfChangesArePresent("Active", "True", "False");
	}

}
