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
public class FilterHitLogByUserAndDateTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;
	@Steps
	public FilterPageSteps filterPageSteps;

	@Test
	public void filterHitLogByUserAndDateTest() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// abstractPageSteps.selectMenuOption("Hitlog");
		// itemsPageSteps.clickOnDeleteLogItemsButton();
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		// create risk assets
		abstractPageSteps.selectActionFromManagePagesRibbon("Assets");
		abstractPageSteps.deleteElementIfExists("185");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("185", "Edit Risk");
		itemsPageSteps.checkIfElementIsPresent("185");
		abstractPageSteps.deleteElementIfExists("185");
		itemsPageSteps.checkThatElementIsNotPresent("185");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");

		abstractPageSteps.selectMenuOption("Hitlog");
		filterPageSteps.clickOnFilterDropdownList();
		// filter by user
		filterPageSteps.inputUsername("System Account");
		filterPageSteps.clickOnFilterButton();

		itemsPageSteps
				.checkIfElementIsPresent("Key: 185 from RiskAssets was Added");
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 185 from RiskAssets was Deleted");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.inputUsername("System");
		filterPageSteps.clickOnFilterButton();

		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 185 from RiskAssets was Added");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 185 from RiskAssets was Deleted");
		filterPageSteps.clickOnClearFiltersButton();
		// filter by date
		filterPageSteps.clickOnFilterByDateCheckBox();
		filterPageSteps.inputFromDateField("-1");
		filterPageSteps.inputToDateField("0");
		filterPageSteps.clickOnFilterButton();

		itemsPageSteps
				.checkIfElementIsPresent("Key: 185 from RiskAssets was Added");
		itemsPageSteps.checkIfElementIsPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Key: 185 from RiskAssets was Deleted");
		filterPageSteps.clickOnClearFiltersButton();

		filterPageSteps.clickOnFilterByDateCheckBox();
		filterPageSteps.inputFromDateField("-2");
		filterPageSteps.inputToDateField("-1");
		filterPageSteps.clickOnFilterButton();

		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 185 from RiskAssets was Added");
		itemsPageSteps.checkThatElementIsNotPresent("RiskAssets", "Accessed");
		itemsPageSteps
				.checkThatElementIsNotPresent("Key: 185 from RiskAssets was Deleted");
	}
}
