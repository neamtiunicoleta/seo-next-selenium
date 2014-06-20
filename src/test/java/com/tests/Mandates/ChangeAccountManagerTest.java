package com.tests.Mandates;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ClientsPageSteps;
import com.steps.ItemsPageSteps;
import com.steps.MandatesPageSteps;
import com.steps.SearchPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.ChangeAccountManager.class)
@RunWith(ThucydidesRunner.class)
public class ChangeAccountManagerTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void changeAccountManager() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("345");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("345", "34");
		itemsPageSteps.checkIfElementIsPresent("345");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "345", "12", "John Doe");
		// create client
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate11");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate11", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate22", "cluj",
				"Jane Doe");
		abstractPageSteps.selectActionFromLeftMenu("Account Manager");
		mandatesPageSteps.inputUser("Jane Doe");
		mandatesPageSteps.clickOnGetMandatesButton();
		mandatesPageSteps.checkIfMandateIsPresent("Mandate22");
		abstractPageSteps.selectItemFromGrid("Mandate22");
		abstractPageSteps.selectActionFromRibbon("Account Manager");
		mandatesPageSteps.changeAccountManager("John Doe");
		mandatesPageSteps.inputUser("Jane Doe");
		mandatesPageSteps.clickOnGetMandatesButton();
		mandatesPageSteps.checkThatMandateIsNotPresent("Mandate22");
		mandatesPageSteps.inputUser("John Doe");
		mandatesPageSteps.clickOnGetMandatesButton();
		mandatesPageSteps.checkIfMandateIsPresent("Mandate22");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate 22");
		searchPageSteps.searchAndDeleteItem("Mandate11");
		abstractPageSteps.goToHomePage();
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("345");
		itemsPageSteps.checkThatElementIsNotPresent("345");
	}
}
