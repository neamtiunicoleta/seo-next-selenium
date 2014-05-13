package com.tests.Risks.RiskCategory;

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

@Story(Application.Edit.EditRisks.EditRiskCategory.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskCategoryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editRiskCategory() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("298");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("298", "Edit Risk");
		abstractPageSteps.selectItemFromGrid("298");
		// edit
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputDescriptionField("Edit Risk Category");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("298");
		itemsPageSteps.checkDescriptionFromGrid("298", "Edit Risk Category");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("298");
		abstractPageSteps.deleteElementIfExists("298");
		itemsPageSteps.checkThatElementIsNotPresent("298");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");

		itemsPageSteps.checkIfElementIsPresent("RiskCategories", "Accessed");

		itemsPageSteps
				.checkIfElementIsPresent("Key: 298 from RiskCategories was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 298 from RiskCategories was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Key: 298 from RiskCategories was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Description", "Edit Risk",
				"Edit Risk Category");
		hitLogPageSteps.checkIfChangesArePresent("Active", "True", "False");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Key: 298 from RiskCategories was Added");
	}

}
