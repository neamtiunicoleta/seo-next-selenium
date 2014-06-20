package com.tests.Mandates;

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

@Story(Application.Create.CreateMandate.class)
@RunWith(ThucydidesRunner.class)
public class CreateMandateTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;

	@Test
	public void createMandate() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);

		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("384");
		itemsPageSteps.inputCodeField("g12k");
		itemsPageSteps.inputTitleField("edit currency");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		// create country
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("1a5");
		abstractPageSteps.deleteElementIfExists("1b5");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("1a5", "1A");
		itemsPageSteps.checkIfElementIsPresent("1a5");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("1b5", "1B");
		itemsPageSteps.checkIfElementIsPresent("1b5");

		// create risk criteria
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.deleteElementIfExists("599");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("899");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createRiskCriteria("899", "Edit Risk", "B (Category B)");
		// create business code
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createBusinessCode("599", "Kenya", "899");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "1a5", "12", "John Doe");
		// create office link
		abstractPageSteps.selectActionFromLeftMenu("Office Links");
		abstractPageSteps.deleteElementIfExists("office 1");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("office 1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("AMLMandate");
		abstractPageSteps.selectActionFromRibbon("Create");

		mandatesPageSteps.selectServiceType("Process Agent", "Accounting");
		mandatesPageSteps.inputFullName("AMLMandate");
		mandatesPageSteps.selectOffice("cluj");
		mandatesPageSteps.inputAccountManager("Jane Doe");
		abstractPageSteps.selectActionFromRibbon("Save");
		abstractPageSteps.selectActionFromLeftMenu("Basic Documentation");
		abstractPageSteps.selectActionFromRibbon("Edit");
		mandatesPageSteps.inputOfficeFileNumber("1214");
		mandatesPageSteps.inputPOPBox("test");
		mandatesPageSteps.selectOfficeLink("office 1");
		mandatesPageSteps.inputCompanyType("SA");
		mandatesPageSteps.inputPurpose("Test");
		mandatesPageSteps.inputAgreementDate("-50");
		mandatesPageSteps.addNewContact("John Doe", "jd");
		abstractPageSteps.clickOnTab("Business Activities");
		clientsPageSteps.inputActualBusinessActivities("Dev");
		clientsPageSteps.selectBusinessCode("599");
		mandatesPageSteps.inputValuationOfTheLegalEntityAmount("1");
		mandatesPageSteps.selectValuationOfTheLegalEntityCurrency("g12k");
		mandatesPageSteps.inputYearlyTurnoverAmount("2");
		mandatesPageSteps.selectYearlyTurnoverCurrency("g12k");
		mandatesPageSteps.inputYearlyNetProfitAmount("3");
		mandatesPageSteps.selectYearlyNetProfitCurrency("g12k");
		mandatesPageSteps.inputNumberOfStaff("12");
		mandatesPageSteps.inputBusinessActivitiesComments("Test");
		abstractPageSteps.clickOnTab("Economic Background");
		mandatesPageSteps.inputFinancialYear("2000");
		mandatesPageSteps.inputCorporateCapitalAmount("2");
		mandatesPageSteps.selectCorporateCapitalCurrency("g12k");
		mandatesPageSteps.inputAuditor("Test");
		mandatesPageSteps.addBankableAsset("Ro", "1", "g12k", "Test");
		mandatesPageSteps.addParticipation("Part 1", "12", "g12k", "Main",
				"23", "Cluj", "1a5", "test", "12", "Just test");
		mandatesPageSteps.addRealEstate("Estate 1", "1", "g12k", "Beta", "33",
				"Cluj", "1a5", "test");
		mandatesPageSteps.addOtherInformation("78", "g12k", "Romania",
				"testing");
		abstractPageSteps.clickOnTab("Transactions");
		mandatesPageSteps.inputTypeOfTransaction("Test");
		mandatesPageSteps.selectDomicileOfCounterParties("1b5");
		mandatesPageSteps.inputTransactionComments("comment");
		abstractPageSteps.clickOnTab("FATCA");
		mandatesPageSteps.clickOnFFICheckbox();
		mandatesPageSteps.clickOnNFFICheckbox();
		mandatesPageSteps.inputTINNumber("233");
		mandatesPageSteps.inputRegistrationDate("-50");
		abstractPageSteps.selectActionFromRibbon("Save");
		abstractPageSteps.selectActionFromLeftMenu("Basic Documentation");
		mandatesPageSteps.checkMandateInformation("Process Agent",
				"Accounting", "1214", "AMLMandate", "Unirii", "325", "Cluj",
				"1a5", "test", "cluj", "Jane Doe", "office 1", "SA", "Test",
				"-50", "jd", "John Doe", "Dev", "599", "1", "g12k", "2",
				"g12k", "3", "g12k", "12", "Test", "2000", "2", "g12k", "Test",
				"Ro", "1", "g12k", "Test", "Part 1", "12", "g12k", "test",
				"12", "Just test", "1a5", "Estate 1", "1", "g12k", "test",
				"1a5", "78", "g12k", "Romania", "testing", "Test", "1b5",
				"comment", "233", "-50");
		// change type
		abstractPageSteps.selectActionFromRibbon("Change Type");
		clientsPageSteps.changeType("Non AML");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		mandatesPageSteps.checkMandateProfileType("Non AML");
		mandatesPageSteps.checkThatServiceTypeIsNotChecked("Accounting");
		abstractPageSteps.selectActionFromRibbon("Close");
		// delete items
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Johnny Doe");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectMenuOption("Currencies");
		abstractPageSteps.deleteElementIfExists("g12k");
		itemsPageSteps.checkThatElementIsNotPresent("g12k");
		abstractPageSteps.selectActionFromLeftMenu("Countries");
		abstractPageSteps.deleteElementIfExists("1a5");
		itemsPageSteps.checkThatElementIsNotPresent("1a5");
		abstractPageSteps.deleteElementIfExists("1b5");
		itemsPageSteps.checkThatElementIsNotPresent("1b5");
		abstractPageSteps.selectActionFromLeftMenu("Business Codes");
		abstractPageSteps.deleteElementIfExists("599");
		itemsPageSteps.checkThatElementIsNotPresent("599");
		abstractPageSteps.selectActionFromLeftMenu("Risk Criterias");
		abstractPageSteps.deleteElementIfExists("899");
		itemsPageSteps.checkThatElementIsNotPresent("899");
		abstractPageSteps.selectActionFromLeftMenu("Office Links");
		abstractPageSteps.deleteElementIfExists("office 1");
		itemsPageSteps.checkThatElementIsNotPresent("office 1");
	}
}
