package com.tests.Offices;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditOffice.class)
@RunWith(ThucydidesRunner.class)
public class EditOfficeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editOffice() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("15f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("15f", "1F");
		itemsPageSteps.checkIfElementIsPresent("15f");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "15f", "12", "John Doe");
		itemsPageSteps.checkIfElementIsPresent("cluj");
		abstractPageSteps.selectItemFromGrid("cluj");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputTitleField("alba");
		itemsPageSteps.inputOrganizationUnit("abb");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("alba");
		itemsPageSteps.checkOrganizationunit("alba", "abb");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("15f");
		itemsPageSteps.checkThatElementIsNotPresent("15f");
	}
}
