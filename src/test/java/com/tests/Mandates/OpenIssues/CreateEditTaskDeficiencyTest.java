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

@Story(Application.Create.CreateTaskDeficiency.class)
@RunWith(ThucydidesRunner.class)
public class CreateEditTaskDeficiencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createAndEditTaskDeficiency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
		searchPageSteps.searchAndDeleteItem("Mandate23");
		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate23", "cluj",
				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Open Issues");
		abstractPageSteps.selectActionFromRibbon("Deficiencies");
		abstractPageSteps.deleteElementIfExists("678");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("355");
		mandatesPageSteps.createTasktype("355", "type1");
		itemsPageSteps.checkIfElementIsPresent("355");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("678");
		itemsPageSteps.inputTitleField("def1");
		mandatesPageSteps.selectTaskType("355");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("678");
		itemsPageSteps.checkDescriptionFromGrid("678", "def1");
		abstractPageSteps.selectItemFromGrid("678");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		mandatesPageSteps.inputKeyField("679");
		itemsPageSteps.inputTitleField("def2");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("679");
		itemsPageSteps.checkDescriptionFromGrid("679", "def2");
		abstractPageSteps.deleteElementIfExists("679");
		itemsPageSteps.checkThatElementIsNotPresent("679");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate23");
	}
}
