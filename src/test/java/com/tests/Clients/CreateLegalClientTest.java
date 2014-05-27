package com.tests.Clients;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateClient.class)
@RunWith(ThucydidesRunner.class)
public class CreateLegalClientTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;

	@Test
	public void createLegalClient() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
//		abstractPageSteps.selectMenuOption("Clients");
//		searchPageSteps.searchAndDeleteItem("jane doe");
//		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
//
//		abstractPageSteps.selectMenuOption("Business Codes");
//		abstractPageSteps.deleteElementIfExists("54");
//		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("810");
		// create risk categories
		abstractPageSteps.selectActionFromLeftMenu("Categories");
		abstractPageSteps.deleteElementIfExists("98");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCategoryOrAsset("98", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create risk criterias
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createRiskCriteria("810", "Edit Risk", "98");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create business code
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createBusinessCode("54", "Test", "810");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("5g6");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("5g6", "7G");
		itemsPageSteps.checkIfElementIsPresent("5g6");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cj", "Unirii", "325",
				"Cluj", "5g6", "12", "John Doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create client
		abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Legal");
		clientsPageSteps.selectOffice("cluj");
		clientsPageSteps.inputFamilyName("Doe Jane");
		clientsPageSteps.inputNickname("Jane");
		clientsPageSteps.selectTypeOfShareholding("Public");

		clientsPageSteps.inputDateOfBirth("15/02/1992");
		clientsPageSteps.inputStreet("Broadway");
		clientsPageSteps.inputZIP("123");
		clientsPageSteps.inputCity("Salvador");
		itemsPageSteps.selectCountry("5g6");
		clientsPageSteps.selectListedIn("5g6");
		clientsPageSteps.inputRemarks("Testing");
		clientsPageSteps.clickOnHighRisk();
		clientsPageSteps.clickOnPEP();
		clientsPageSteps.inputPepDetails("Pep Details");
		clientsPageSteps.inputClientComments("testing clients");

		abstractPageSteps.clickOnTab("Business Activities");
		clientsPageSteps.selectBusinessCode("Test");
		clientsPageSteps.inputActualBusinessActivities("Testing");
		clientsPageSteps.inputComments("Testing client");

		abstractPageSteps.clickOnTab("Identification");
		clientsPageSteps.inputIdentificationMadeBy("John Doe");
		clientsPageSteps.selectTypeOfID("National Identity card");
		clientsPageSteps.inputIdentificationDate("-10");
		clientsPageSteps.inputOther("other things");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("Doe Jane");
		// delete items
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		itemsPageSteps.checkThatElementIsNotPresent("Doe Jane");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("5g6");
		itemsPageSteps.checkThatElementIsNotPresent("5g6");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("54");
		itemsPageSteps.checkThatElementIsNotPresent("54");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("810");
		itemsPageSteps.checkThatElementIsNotPresent("810");
		abstractPageSteps.selectActionFromLeftMenu("Categories");
		abstractPageSteps.deleteElementIfExists("98");
		itemsPageSteps.checkThatElementIsNotPresent("98");
	}

}
