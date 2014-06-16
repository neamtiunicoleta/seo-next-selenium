package com.tests.Clients;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Create.CreateClientSituation.class)
@RunWith(ThucydidesRunner.class)
public class CreateClientSituationTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;

	@Test
	public void createClientSituation() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("19f", "9F");
		itemsPageSteps.checkIfElementIsPresent("19f");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "19f", "12", "John Doe");
		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("John Smith");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("cluj", "Smith",
				"John");
		// upload documents
		abstractPageSteps.selectActionFromLeftMenu("Client Situation");
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
		clientsPageSteps.checkThatClientDoesntExists("John Smith");
	}

}
