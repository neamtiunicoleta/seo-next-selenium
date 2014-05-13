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
		// abstractPageSteps.selectMenuOption("Hitlog");
		// itemsPageSteps.clickOnDeleteLogItemsButton();
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("315");
		abstractPageSteps.deleteElementIfExists("316");
		// create risk categories
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("211");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("211", "Edit Risk1");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create risk criterias
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("315", "Edit Risk", "211");
		itemsPageSteps.checkIfElementIsPresent("315");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("316", "Edit Risk", "211");
		itemsPageSteps.checkIfElementIsPresent("316");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("aaf3");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithRisk("aaf3", "NC", "315");
		itemsPageSteps.checkIfElementIsPresent("aaf3");
		abstractPageSteps.selectItemFromGrid("aaf3");
		// edit country
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("A58kn");
		itemsPageSteps.inputCodeField("C2");
		itemsPageSteps.selectRisk("316");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("A58kn");
		itemsPageSteps.checkCodeFromGrid("A58kn", "C2");
		itemsPageSteps.checkRiskCategoryForCriteriasFromGrid("A58kn", "316");
		// delete items
		abstractPageSteps.deleteElementIfExists("A58kn");
		itemsPageSteps.checkThatElementIsNotPresent("A58kn");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("315");
		abstractPageSteps.deleteElementIfExists("316");
		itemsPageSteps.checkThatElementIsNotPresent("315");
		itemsPageSteps.checkThatElementIsNotPresent("316");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("211");
		itemsPageSteps.checkThatElementIsNotPresent("211");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// check hitlog
		abstractPageSteps.selectMenuOption("Hitlog");
		itemsPageSteps.checkIfElementIsPresent("Countries", "Accessed");
		itemsPageSteps
				.checkIfElementIsPresent("Title: A58kn from Countries was Deleted");
		itemsPageSteps
				.checkIfElementIsPresent("Title: A58kn from Countries was Changed");

		hitLogPageSteps
				.clickOnviewLogDetails("Title: A58kn from Countries was Changed");
		hitLogPageSteps.checkIfChangesArePresent("Title", "aaf3", "A58kn");
		hitLogPageSteps.checkIfChangesArePresent("Code", "NC", "C2");
		abstractPageSteps.closeHitlogDetailsPage();
		itemsPageSteps
				.checkIfElementIsPresent("Title: aaf3 from Countries was Added");

	}

}
