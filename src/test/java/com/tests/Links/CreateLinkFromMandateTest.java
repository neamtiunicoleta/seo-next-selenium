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
public class CreateLinkFromMandateTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createLinkFromMandateSide() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");

		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Joe Doe");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("cluj", "Doe",
				"Joe");
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Ana Smith");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("cluj", "Smith",
				"Ana");

		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("MANDATE5");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate5", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Linked Clients");
		// create links
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		clientsPageSteps.selectTargetObject("Ana Smith");
		clientsPageSteps.activateLinkType("UBO", "20");
		clientsPageSteps.activateLinkType("Settlor", "30");
		clientsPageSteps.inputLinkComments("Create link");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkIfLinkIsPresentInActiveSection("Ana Smith");
		clientsPageSteps
				.checkThatLinkIsNotPresentInInactiveSection("Ana Smith");
		clientsPageSteps.checkLinkCommentsFromGrid("Ana Smith", "Create link");
		clientsPageSteps.selectLinkFromGrid("Ana Smith");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		clientsPageSteps.checkDataForActiveLink("UBO", "20");
		clientsPageSteps.checkDataForActiveLink("Settlor", "30");
		clientsPageSteps.inactivateLinkType("UBO", "100");
		clientsPageSteps.inputLinkComments("Edit link");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkIfLinkIsPresentInActiveSection("Ana Smith");
		clientsPageSteps.checkIfLinkIsPresentInInactiveSection("Ana Smith");
		clientsPageSteps.checkLinkCommentsFromGrid("Ana Smith", "Edit link");
		clientsPageSteps.selectLinkFromGrid("Ana Smith");

		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		clientsPageSteps.checkDataForInactiveLink("UBO", "100");
		abstractPageSteps.selectActionFromCreateAndEditPage("Close");
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchByText("Smith Ana");
		searchPageSteps.selectItemFromSearchResultsList("Ana Smith");
		abstractPageSteps.selectActionFromLeftMenu("Linked Mandates");
		clientsPageSteps.checkIfLinkIsPresentInActiveSection("MANDATE5");
		clientsPageSteps.checkIfLinkIsPresentInInactiveSection("MANDATE5");
		searchPageSteps.searchAndDeleteItem("Smith Ana");
		clientsPageSteps.checkThatEntityDoesntExists("Smith Ana");
		searchPageSteps.searchAndDeleteItem("Doe Joe");
		clientsPageSteps.checkThatEntityDoesntExists("Doe Joe");
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("MANDATE5");
		clientsPageSteps.checkThatEntityDoesntExists("MANDATE5");
	}
}
