package com.tests.Mandates;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ItemsPageSteps;
import com.steps.MandatesPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateMandateService.class)
@RunWith(ThucydidesRunner.class)
public class CreateMandateServicesTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createMandateService() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Mandates");
		abstractPageSteps.selectActionFromRibbon("Services");
		abstractPageSteps.deleteElementIfExists("456");
		abstractPageSteps.selectActionFromRibbon("Create");
		mandatesPageSteps.inputKeyField("456");
		mandatesPageSteps.inputDescriptionField("MandateService");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("456");
		mandatesPageSteps.checkDescription("456", "MandateService");
		mandatesPageSteps.checkServiceType("456", "AML");
		abstractPageSteps.deleteElementIfExists("456");
		itemsPageSteps.checkThatElementIsNotPresent("456");
	}
}
