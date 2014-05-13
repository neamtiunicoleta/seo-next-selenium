package com.tests.Filters;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.FilterPageSteps;
import com.steps.HitLogPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Filter.FilterHitlog.class)
@RunWith(ThucydidesRunner.class)
public class FilterHitLogByTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterHitlogByType() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// abstractPageSteps.selectMenuOption("Hitlog");
		// itemsPageSteps.clickOnDeleteLogItemsButton();
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		// create risk assets
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("184");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("184", "Edit Risk");
		itemsPageSteps.checkIfElementIsPresent("184");
		abstractPageSteps.selectItemFromGrid("184");
		// edit
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputDescriptionField("Edit Risk Category");
		itemsPageSteps.clickOnActiveCheckBox();
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		// export
		abstractPageSteps.selectActionFromManagePagesRibbon("Export");
		itemsPageSteps.checkIfElementIsPresent("184");
		// delete
		abstractPageSteps.deleteElementIfExists("184");
		itemsPageSteps.checkThatElementIsNotPresent("184");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// added
		abstractPageSteps.selectMenuOption("Hitlog");
		filterPageSteps.clickOnFilterDropdownList();
		filterPageSteps.selectTypeFilter("Added");
		filterPageSteps.clickOnFilterButton();

		itemsPageSteps
				.checkIfElementIsPresent("Key: 184 from RiskAssets was Added");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Deleted");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Changed");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Exported");

		// changed
		filterPageSteps.selectTypeFilter("Changed");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps
				.checkIfElementIsPresent("Key: 184 from RiskAssets was Changed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Added");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Deleted");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Exported");

		// deleted
		filterPageSteps.selectTypeFilter("Deleted");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps
				.checkIfElementIsPresent("Key: 184 from RiskAssets was Deleted");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Added");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Changed");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Exported");

		// accessed
		filterPageSteps.selectTypeFilter("Accessed");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Added");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Deleted");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Changed");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Exported");

		// exported
		filterPageSteps.selectTypeFilter("Exported");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Exported");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Added");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Deleted");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 184 from RiskAssets was Changed");

		// all
		filterPageSteps.selectTypeFilter("All");
		filterPageSteps.clickOnFilterButton();
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Exported");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 184 from RiskAssets was Added");
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 184 from RiskAssets was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 184 from RiskAssets was Changed");
	}
}
