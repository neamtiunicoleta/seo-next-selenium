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
public class CreateIndividualClientTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;

	@Test
	public void createIndividualClient() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("1yg2");
		abstractPageSteps.deleteElementIfExists("1fb2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("1yg2", "1Y");
		itemsPageSteps.checkIfElementIsPresent("1Y");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("1fb2", "1F");
		itemsPageSteps.checkIfElementIsPresent("1F");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cj", "Unirii", "325",
				"Cluj", "1yg2", "12", "John Doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// create client
		abstractPageSteps.selectMenuOption("Clients");
		searchPageSteps.searchAndDeleteItem("john doe");
		itemsPageSteps.checkThatElementIsNotPresent("john doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.selectOffice("cluj");
		clientsPageSteps.inputFamilyName("Doe");
		clientsPageSteps.inputFirstName("John");
		clientsPageSteps.inputAdditionalName("Mark");
		clientsPageSteps.inputNickname("Johnny");
		clientsPageSteps.inputAlternativeSpelling("John");
		clientsPageSteps.inputPlaceOfBirth("Salvador");
		clientsPageSteps.inputDateOfBirth("15/02/1992");
		clientsPageSteps.inputStreet("Broadway");
		clientsPageSteps.inputZIP("123");
		clientsPageSteps.inputCity("Salvador");
		itemsPageSteps.selectCountry("1yg2");
		clientsPageSteps.selectCountryOfDomicile("1fb2");
		clientsPageSteps.selectNationality("1fb2");
		clientsPageSteps.inputPhone("01245");
		clientsPageSteps.inputEmail("johndoe@test.com");
		clientsPageSteps.clickOnUSPerson();
		clientsPageSteps.inputRemarks("Testing");
		clientsPageSteps.clickOnHighRisk();
		clientsPageSteps.clickOnPEP();
		clientsPageSteps.inputPepDetails("Pep Details");
		clientsPageSteps.inputClientComments("testing clients");

		abstractPageSteps.clickOnTab("Private Background");
		clientsPageSteps.selectEmploymentState("Employed");
		clientsPageSteps.inputProfessionalActivity("Qa");
		clientsPageSteps.inputActualFunction("Developer");
		clientsPageSteps.inputNameOfEmployer("Joe Smith");
		clientsPageSteps.selectAnualIncome("More than 1 Mil");
		clientsPageSteps.selectEstimatedWealth("USD 1-5 Mil");
		clientsPageSteps.inputSourceOfWealth("Testing");
		clientsPageSteps.selectMaritalStatus("Married");

		abstractPageSteps.clickOnTab("Identification");
		clientsPageSteps.inputIdentificationMadeBy("John Doe");
		clientsPageSteps.selectTypeOfProcedure("Personally");
		clientsPageSteps.selectTypeOfID("Passport");
		clientsPageSteps.inputPassportNumber("02154");

		clientsPageSteps.inputIdentificationDate("-10");
		clientsPageSteps.selectTypeOfCopy("Normal copy");
		clientsPageSteps.inputIDValidUntil("30");
		clientsPageSteps.selectLocationOfID("cluj");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("John Doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		itemsPageSteps.checkThatElementIsNotPresent("John Doe");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("1yg2");
		itemsPageSteps.checkThatElementIsNotPresent("1yg2");
		abstractPageSteps.deleteElementIfExists("1fb2");
		itemsPageSteps.checkThatElementIsNotPresent("1fb2");
	}

}
