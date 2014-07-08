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
public class CreateBasicDocForLegalClientTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;

	@Test
	public void createBasicDocForLegalClient() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("29f");
		abstractPageSteps.deleteElementIfExists("30f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("29f", "92");
		itemsPageSteps.checkIfElementIsPresent("29f");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("30f", "3F");
		itemsPageSteps.checkIfElementIsPresent("30f");
		// create risk criteria
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("893", "Edit Risk", "B (Category B)");
		// create business code
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("594", "Kenya", "893");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("dej", "dej", "Unirii", "325",
				"Cluj", "29f", "12", "John Doe");
		itemsPageSteps.createOfficeIfNotExists("alba", "abb", "Independentei",
				"95", "Alba", "29f", "12", "John Doe");
		// create client
		abstractPageSteps.selectActionFromTopMenu("Clients");
		searchPageSteps.searchAndDeleteItem("Doe Mary");
		abstractPageSteps.selectActionFromRibbon("Legal Standard");
		clientsPageSteps.createBasicStandardLegalClient("cluj", "Doe Mary");
		// create basic doc situation
		abstractPageSteps.selectActionFromRibbon("Edit");
		clientsPageSteps.inputNicknameOrAbbreviation("Test");
		clientsPageSteps.selectListedIn("29f");
		clientsPageSteps.selectTypeOfShareholding("Public");
		clientsPageSteps.inputStreet("Abator");
		clientsPageSteps.inputZIP("122");
		clientsPageSteps.inputCity("Cluj");
		itemsPageSteps.selectCountry("29f");
		clientsPageSteps.inputDateOfBirthOrIncorporation(DateUtils.toString(
				DateUtils.addDays(new Date(), Integer.parseInt("-100")),
				"dd/MM/yyyy"));
		clientsPageSteps.inputRemarks("Test");
		clientsPageSteps.clickOnPEP();
		clientsPageSteps.inputClientComments("Test");

		abstractPageSteps.clickOnTab("Business Activities");
		clientsPageSteps.selectBusinessCode("594");
		clientsPageSteps.inputActualBusinessActivities("Dev");
		clientsPageSteps.inputComments("Testing");

		abstractPageSteps.clickOnTab("Identification");
		clientsPageSteps.inputIdentificationMadeBy("Jane Doe");
		clientsPageSteps.selectTypeOfID("Passport");
		clientsPageSteps.inputIdentificationDate("0");
		clientsPageSteps.inputOther("Just test");
		abstractPageSteps.selectActionFromRibbon("Save");

		abstractPageSteps.selectActionFromLeftMenu("Basic Documentation");
		clientsPageSteps.checkLegalClientInformation("Standard", "cluj",
				"Doe Mary", "Test", "29f", "Public", "Abator", "122", "Cluj",
				"29f", "-100", "Test", "Test", "594", "Dev", "Testing",
				"Jane Doe", "Passport", "0", "Just test");
		// change type
		abstractPageSteps.selectActionFromRibbon("Change Type");
		clientsPageSteps.changeType("Light");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		clientsPageSteps.checkClientProfileType("Light");
		abstractPageSteps.checkThatTabIsNotPresent("Business Activities");
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
		clientsPageSteps.checkThatEntityDoesntExists("Doe Mary");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("30f");
		itemsPageSteps.checkThatElementIsNotPresent("30f");
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		itemsPageSteps.checkThatElementIsNotPresent("594");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("893");
		itemsPageSteps.checkThatElementIsNotPresent("893");

	}
}
