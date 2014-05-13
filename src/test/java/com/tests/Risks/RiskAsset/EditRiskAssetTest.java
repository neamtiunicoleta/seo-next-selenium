package com.tests.Risks.RiskAsset;

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

@Story(Application.Edit.EditRisks.EditRiskAssets.class)
@RunWith(ThucydidesRunner.class)
public class EditRiskAssetTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editRiskAsset() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("21");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("21", "Edit Risk");
		itemsPageSteps.checkIfElementIsPresent("21");
		abstractPageSteps.selectItemFromGrid("21");
		// edit
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputDescriptionField("Edit Risk Category");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("21");
		itemsPageSteps.checkDescriptionFromGrid("21", "Edit Risk Category");
		itemsPageSteps.checkIfActiveCheckBoxIsNotChecked("21");
		abstractPageSteps.deleteElementIfExists("21");
		itemsPageSteps.checkThatElementIsNotPresent("21");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Accessed");

		itemsPageSteps
				.checkIfElementIsPresent("Key: 21 from RiskAssets was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 21 from RiskAssets was Changed");
		hitLogPageSteps
				.clickOnviewLogDetails("Key: 21 from RiskAssets was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Description", "Edit Risk",
				"Edit Risk Category");
		hitLogPageSteps.checkIfChangesArePresent("Active", "True", "False");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Key: 21 from RiskAssets was Added");
	}
}
