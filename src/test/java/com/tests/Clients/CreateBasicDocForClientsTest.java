package com.tests.Clients;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.LinksPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateBasicDocumentation.class)
@RunWith(ThucydidesRunner.class)
public class CreateBasicDocForClientsTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public LinksPageSteps linksPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;

	@Test
	public void createBasicDocForClient() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("15f", "1F");
		itemsPageSteps.checkIfElementIsPresent("15f");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cj", "Unirii", "325",
				"Cluj", "19f", "12", "John Doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create client
		abstractPageSteps.selectMenuOption("Clients");
		searchPageSteps.searchAndDeleteItem("johnny doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.createBasicIndividualClient("cluj", "Doe", "Johnny");
		itemsPageSteps.checkIfElementIsPresent("Johnny Doe");
		// create basic doc situation
		abstractPageSteps.selectActionFromLeftMenu("Client Situation");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps
				.inputActualSituationForDocSituation("Client Documentation");
		itemsPageSteps.inputRiskForDocSituation("Low Risk");
		itemsPageSteps.inputResolutionForDocSituation("Testing");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("Client Documentation");
		linksPageSteps.checkSource("Client Documentation", "Client Jacob");
		itemsPageSteps.checkRiskForDocSituation("Client Documentation",
				"Low Risk");
		itemsPageSteps.checkResolutionForDocSituation("Client Documentation",
				"Testing");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		itemsPageSteps.checkThatElementIsNotPresent("Johnny Doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		itemsPageSteps.checkThatElementIsNotPresent("19f");

	}
}
