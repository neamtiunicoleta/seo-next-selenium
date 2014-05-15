package com.tests.Clients;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Create.CreateClient.class)
@RunWith(ThucydidesRunner.class)
public class CreateIndividualClient extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void createIndividualClient() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Clients");
		// abstractPageSteps.deleteElementIfExists("John Doe");
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// // create country
		// abstractPageSteps.selectMenuOption("Countries");
		// abstractPageSteps.deleteElementIfExists("1yg2");
		// abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		// itemsPageSteps.createCountryWithoutRisk("1yg2", "1Y");
		// itemsPageSteps.checkIfElementIsPresent("1Y");
		// abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		// itemsPageSteps.createCountryWithoutRisk("1fb2", "1F");
		// itemsPageSteps.checkIfElementIsPresent("1F");
		// abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		// // create client
		// abstractPageSteps.selectMenuOption("Clients");
		abstractPageSteps.selectActionFromManagePagesRibbon("Individual");
		clientsPageSteps.selectOffice("Brazil");
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
		clientsPageSteps.selectTypeOfID("Passport");
		clientsPageSteps.inputPassportNumber("02154");
		clientsPageSteps.selectTypeOfProcedure("Personally");
		clientsPageSteps.inputIdentificationDate("-10");
		clientsPageSteps.selectTypeOfCopy("Normal copy");
		clientsPageSteps.inputIDValidUntil("30");
		clientsPageSteps.selectLocationOfID("Brazil");
		abstractPageSteps.selectActionFromManagePagesRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("Doe John");
	}

}
