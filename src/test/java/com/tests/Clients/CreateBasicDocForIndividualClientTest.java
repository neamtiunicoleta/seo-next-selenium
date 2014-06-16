package com.tests.Clients;

import java.util.Date;

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
import com.tools.DateUtils;

@Story(Application.Create.CreateClientBasicDocumentation.class)
@RunWith(ThucydidesRunner.class)
public class CreateBasicDocForIndividualClientTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;

	@Test
	public void createBasicDocForIndividualClient() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		abstractPageSteps.deleteElementIfExists("20f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("19f", "9F");
		itemsPageSteps.checkIfElementIsPresent("19f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("20f", "1F");
		itemsPageSteps.checkIfElementIsPresent("20f");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "19f", "12", "John Doe");
		itemsPageSteps.createOfficeIfNotExists("alba", "abb", "Independentei",
				"95", "Alba", "19f", "12", "John Doe");
		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Johnny doe");
		abstractPageSteps.selectActionFromRibbon("Individual");
		clientsPageSteps.createBasicStandardIndividualClient("Standard",
				"cluj", "Doe", "Johnny");
		clientsPageSteps.checkIfClientExists("Johnny Doe");
		// create basic doc situation
		abstractPageSteps.selectActionFromLeftMenu("Basic Documentation");
		abstractPageSteps.selectActionFromRibbon("Edit");
		clientsPageSteps.inputAdditionalName("JJ");
		clientsPageSteps.inputNicknameOrAbbreviation("Johnny");
		clientsPageSteps.inputAlternativeSpelling("JJ");
		clientsPageSteps.inputStreet("Abator");
		clientsPageSteps.inputZIP("122");
		clientsPageSteps.inputCity("Cluj");
		itemsPageSteps.selectCountry("19f");
		clientsPageSteps.inputAdditionalStreet("Deva");
		clientsPageSteps.inputAdditionalZIP("79");
		clientsPageSteps.inputAdditionalCity("Cluj");
		clientsPageSteps.inputPlaceOfBirth("Romania");
		clientsPageSteps.inputDateOfBirthOrIncorporation(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("-100")),
				"dd/MM/yyyy"));
		clientsPageSteps.selectCountryOfDomicile("20f");
		clientsPageSteps.selectNationality("20f");
		clientsPageSteps.inputPhone("123456789");
		clientsPageSteps.inputEmail("johhny.doe@test.com");
		clientsPageSteps.inputRemarks("Test");
		clientsPageSteps.clickOnPEP();
		clientsPageSteps.inputClientComments("Just testing");
		abstractPageSteps.clickOnTab("Private Background");
		clientsPageSteps.selectEmploymentState("Employed");
		clientsPageSteps.inputProfessionalActivity("Qa");
		clientsPageSteps.inputActualFunction("Dev");
		clientsPageSteps.inputNameOfEmployer("John Smith");
		clientsPageSteps.selectAnualIncome("More than 1 Mil");
		clientsPageSteps.selectEstimatedWealth("less than USD 1 Mil");
		clientsPageSteps.inputSourceOfWealth("Test");
		clientsPageSteps.selectMaritalStatus("Married");
		abstractPageSteps.clickOnTab("Identification");
		clientsPageSteps.inputIdentificationMadeBy("Jane Doe");
		clientsPageSteps.selectTypeOfID("Passport");
		clientsPageSteps.inputPassportNumber("1001");
		clientsPageSteps.selectTypeOfProcedure("Personally");
		clientsPageSteps.inputIdentificationDate("0");
		clientsPageSteps.selectTypeOfCopy("Normal copy");
		clientsPageSteps.inputIDValidUntil("0");
		clientsPageSteps.selectLocationOfID("cluj");
		abstractPageSteps.selectActionFromRibbon("Save");
		abstractPageSteps.selectActionFromLeftMenu("Basic Documentation");
		clientsPageSteps.checkIndividualClientInformation("Standard", "cluj",
				"Doe", "Johnny", "JJ", "Johnny", "JJ", "Abator", "122", "Cluj",
				"19f", "Deva", "79", "Cluj", "Romania", "-100", "20f", "20f",
				"123456789", "johhny.doe@test.com", "Test", "Just testing",
				"Employed", "Qa", "Dev", "John Smith", "More than 1 Mil",
				"less than USD 1 Mil", "Test", "Married", "Jane Doe",
				"Passport", "1001", "Personally", "0", "Normal Copy", "0",
				"cluj");
		// change type
		abstractPageSteps.selectActionFromRibbon("Change Type");
		clientsPageSteps.changeType("Light");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkClientProfileType("Light");
		abstractPageSteps.checkThatTabIsNotPresent("Private Background");
		// change office
		abstractPageSteps.selectActionFromRibbon("Change Office");
		clientsPageSteps.changeOffice("alba");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkOffice("cluj");
		clientsPageSteps.checkOffice("alba");
		abstractPageSteps.selectActionFromRibbon("Close");
		// delete items
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatClientDoesntExists("Johnny Doe");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("19f");
		itemsPageSteps.checkThatElementIsNotPresent("19f");
		abstractPageSteps.deleteElementIfExists("20f");
		itemsPageSteps.checkThatElementIsNotPresent("20f");
	}
}
