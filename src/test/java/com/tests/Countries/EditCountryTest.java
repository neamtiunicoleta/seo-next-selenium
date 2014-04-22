package com.tests.Countries;

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

@Story(Application.Edit.EditCountry.class)
@RunWith(ThucydidesRunner.class)
public class EditCountryTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public HitLogPageSteps hitLogPageSteps;

	@Test
	public void editCountry() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.clickOnDeleteLogItemsButton();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.deleteElementIfExists("133");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("132", "Edit Risk1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("13", "Edit Risk2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountry("aaf3", "NC", "132");
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		abstractPageSteps.selectItemFromGrid("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("A58kn");
		itemsPageSteps.inputCodeField("C2");
		itemsPageSteps.selectRisk("133");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("A58kn");
		itemsPageSteps.checkCodeFromGrid("A58kn", "C2");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("A58kn", "133");
		abstractPageSteps.deleteElementIfExists("A58kn");
		itemsPageSteps.checkThatElementIsNotPresent("A58kn");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("132");
		abstractPageSteps.deleteElementIfExists("133");
		itemsPageSteps.checkThatElementIsNotPresent("132");
		itemsPageSteps.checkThatElementIsNotPresent("133");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Countries", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Title: aaf3 from Countries was Added");

		itemsPageSteps
				.checkIfElementIsPresent("Title: A58kn from Countries was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Title: A58kn from Countries was Changed");

		hitLogPageSteps
				.clickOnviewLogDetails("Title: A58kn from Countries was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "aaf3", "A58kn");
		hitLogPageSteps.checkIfChangesArePresent("Code", "NC", "C2");
	}

}
