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

@Story(Application.Edit.EditMandateService.class)
@RunWith(ThucydidesRunner.class)
public class EditMandateServiceTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editMandateService() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Mandate Services");
		abstractPageSteps.deleteElementIfExists("888");
		abstractPageSteps.deleteElementIfExists("889");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("888");
		itemsPageSteps.inputServiceDescription("service22");
		itemsPageSteps.selectMandateServiceType("Non AML");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("888");
		abstractPageSteps.selectItemFromGrid("888");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputKeyFieldTaskType("889");
		itemsPageSteps.inputServiceDescription("service33");
		itemsPageSteps.selectMandateServiceType("AML");
		abstractPageSteps.selectActionFromRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("889");
		itemsPageSteps.checkDescriptionFromGrid("889", "service33");
		itemsPageSteps.checkTypeFromGrid("889", "AML");
		abstractPageSteps.deleteElementIfExists("889");
		itemsPageSteps.checkThatElementIsNotPresent("889");
	}

}
