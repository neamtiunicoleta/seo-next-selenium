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

@Story(Application.Create.CreateOffice.class)
@RunWith(ThucydidesRunner.class)
public class CreateOfficeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createOffice() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("15f");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("15f", "1F");
		itemsPageSteps.checkIfElementIsPresent("15f");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cj", "Unirii", "325",
				"Cluj", "15f", "12", "John Doe");
		itemsPageSteps.checkIfElementIsPresent("cluj");
		itemsPageSteps.checkOrganizationunit("cluj", "cj");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("15f");
		itemsPageSteps.checkThatElementIsNotPresent("15f");
	}
}
