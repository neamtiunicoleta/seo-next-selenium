package com.tests.Mandates;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.MandatesPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateMandateSituation.class)
@RunWith(ThucydidesRunner.class)
public class CreateMandateSituationTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createMandateSituation() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate2");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate2", "cluj",
				"John Doe");
		// upload documents
		abstractPageSteps.selectActionFromLeftMenu("Mandate Situation");
		abstractPageSteps.selectActionFromRibbon("Create");
		clientsPageSteps.inputActualSituation("Testing");
		clientsPageSteps.inputRiskForSituation("Medium");
		clientsPageSteps.inputResolution("Test");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("Testing");
		clientsPageSteps.checkRiskForSituation("Testing", "Medium");
		clientsPageSteps.checkResolution("Testing", "Test");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate2");
	}

}
