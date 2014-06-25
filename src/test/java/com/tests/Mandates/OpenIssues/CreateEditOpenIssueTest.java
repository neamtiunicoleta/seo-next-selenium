package com.tests.Mandates.OpenIssues;

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

@Story(Application.Create.CreateOpenIssues.class)
@RunWith(ThucydidesRunner.class)
public class CreateEditOpenIssueTest extends BaseTest {
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createAndEditOpenIssues() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create country
		abstractPageSteps.selectMenuOption("Countries");
		abstractPageSteps.deleteElementIfExists("164");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.createCountryWithoutRisk("164", "16");
		itemsPageSteps.checkIfElementIsPresent("16");
		// create office
		abstractPageSteps.selectActionFromLeftMenu("Offices");
		itemsPageSteps.createOfficeIfNotExists("cluj", "cjj", "Unirii", "325",
				"Cluj", "164", "12", "John Doe");
		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate77");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate77", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Open Issues");
		abstractPageSteps.selectActionFromRibbon("Deficiencies");
		abstractPageSteps.deleteElementIfExists("678");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("678");
		itemsPageSteps.inputTitleField("def1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("678");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		mandatesPageSteps.selectTypeOfIssue("Basic doc");
		mandatesPageSteps.inputDeadlineDate("100");
		mandatesPageSteps.selectTypeOfDeficiency("def1");
		mandatesPageSteps.inputFindings("test");
		mandatesPageSteps.inputAddionalRemarks("remarks");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("System Account");
		mandatesPageSteps.checkCreatedOnForOpenIssues("System Account", "0");
		mandatesPageSteps.checkDeadlineForOpenIssues("System Account", "100");
		mandatesPageSteps.checkTypeOfIssue("System Account", "Basic doc");
		mandatesPageSteps.checkTypeOfDeficiency("System Account", "def1");
		mandatesPageSteps.selectItemFromMandateSection("System Account");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		mandatesPageSteps.selectTypeOfIssue("Compliance");
		mandatesPageSteps.inputDeadlineDate("50");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		mandatesPageSteps.checkDeadlineForOpenIssues("System Account", "50");
		mandatesPageSteps.checkTypeOfIssue("System Account", "Compliance");
		mandatesPageSteps.checkTypeOfDeficiency("System Account", " ");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate77");
	}
}
