package com.tests.Links;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.MandatesPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateLink.class)
@RunWith(ThucydidesRunner.class)
public class CreateLinkFromClientTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createLinkFromClientSide() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate2");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate2", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromRibbon("Close");
		searchPageSteps.searchAndDeleteItem("Mandate3");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate3", "cluj",
				"John Doe");
		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Doe Joe");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("cluj", "Doe",
				"Joe");
		abstractPageSteps.selectActionFromLeftMenu("Linked Mandates");

		// create links
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		clientsPageSteps.selectTargetObject("Mandate3");
		clientsPageSteps.activateLinkType("UBO", "20");
		clientsPageSteps.activateLinkType("Settlor", "30");
		clientsPageSteps.inputLinkComments("Create link");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkIfLinkIsPresentInActiveSection("Mandate3");
		clientsPageSteps.checkThatLinkIsNotPresentInInactiveSection("Mandate3");
		clientsPageSteps.checkLinkCommentsFromGrid("Mandate3", "Create link");
		clientsPageSteps.selectLinkFromGrid("Mandate3");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		clientsPageSteps.checkDataForActiveLink("UBO", "20");
		clientsPageSteps.checkDataForActiveLink("Settlor", "30");
		clientsPageSteps.inactivateLinkType("UBO", "100");
		clientsPageSteps.inputLinkComments("Edit link");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkIfLinkIsPresentInActiveSection("Mandate3");
		clientsPageSteps.checkIfLinkIsPresentInInactiveSection("Mandate3");
		clientsPageSteps.checkLinkCommentsFromGrid("Mandate3", "Edit link");
		clientsPageSteps.selectLinkFromGrid("Mandate3");

		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		clientsPageSteps.checkDataForInactiveLink("UBO", "100");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchByText("Mandate3");
		searchPageSteps.selectItemFromSearchResultsList("Mandate3");
		abstractPageSteps.selectActionFromLeftMenu("Linked Clients");
		clientsPageSteps.checkIfLinkIsPresentInActiveSection("Joe Doe");
		clientsPageSteps.checkIfLinkIsPresentInInactiveSection("Joe Doe");
		searchPageSteps.searchAndDeleteItem("Mandate3");
		clientsPageSteps.checkThatEntityDoesntExists("Mandate3");
		searchPageSteps.searchAndDeleteItem("Mandate2");
		clientsPageSteps.checkThatEntityDoesntExists("Mandate2");
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Joe Doe");
		clientsPageSteps.checkThatEntityDoesntExists("Joe Doe");

	}
}
