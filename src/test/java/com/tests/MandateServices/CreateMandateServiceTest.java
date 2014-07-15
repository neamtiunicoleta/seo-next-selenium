package com.tests.MandateServices;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateMandateService.class)
@RunWith(ThucydidesRunner.class)
public class CreateMandateServiceTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createMandateService() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Mandate Services");
		abstractPageSteps.deleteElementIfExists("567");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("567");
		itemsPageSteps.inputServiceDescription("service1");
		itemsPageSteps.selectMandateServiceType("Non AML");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("567");
		itemsPageSteps.checkDescriptionFromGrid("567", "service1");
		itemsPageSteps.checkTypeFromGrid("567", "Non AML");
		abstractPageSteps.deleteElementIfExists("567");
		itemsPageSteps.checkThatElementIsNotPresent("567");
	}
}
