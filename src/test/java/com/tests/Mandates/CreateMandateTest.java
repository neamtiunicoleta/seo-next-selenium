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
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("1a2");
		abstractPageSteps.deleteElementIfExists("1b2");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("1a2", "1A");
		itemsPageSteps.checkIfElementIsPresent("1A");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("1b2", "1B");
		itemsPageSteps.checkIfElementIsPresent("1B");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Mandates");
		searchPageSteps.searchAndDeleteItem("AMLMandate");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		mandatesPageSteps.selectMandateType("Non AML");

		mandatesPageSteps.selectServiceType("Process Agent");
		mandatesPageSteps.selectOffice("cj");
		mandatesPageSteps.inputOfficeFileNumber("1214");
		mandatesPageSteps.inputFullName("AMLMandate");
		clientsPageSteps.inputStreet("Broadway");
		clientsPageSteps.inputZIP("1214");
		clientsPageSteps.inputCity("Miami");
		itemsPageSteps.selectCountry("1a2");
		mandatesPageSteps.inputPOPBox("test");
		mandatesPageSteps.inputAccountManager("Jane Doe");
		// account team
		// office link
		mandatesPageSteps.inputCompanyType("SA");
	}
}
