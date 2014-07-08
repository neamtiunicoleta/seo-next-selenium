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

@Story(Application.Create.CreateTaskType.class)
@RunWith(ThucydidesRunner.class)
public class CreateEditTaskTypeTest extends BaseTest {
	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ClientsPageSteps clientsPageSteps;
	@Steps
	public SearchPageSteps searchPageSteps;
	@Steps
	public MandatesPageSteps mandatesPageSteps;

	@Test
	public void createAndEditTaskType() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		// create office
		abstractPageSteps.selectMenuOption("Offices");
		itemsPageSteps.createBasicOfficeIfNotExists("cluj", "cjj");
		// create mandate
		abstractPageSteps.selectActionFromTopMenu("Mandates");
//		searchPageSteps.searchAndDeleteItem("Mandate23");
//		mandatesPageSteps.createBasicMandate("Liquidator", "Mandate23", "cluj",
//				"John Doe");
		abstractPageSteps.selectActionFromLeftMenu("Open Issues");
		abstractPageSteps.selectActionFromRibbon("Types");
		abstractPageSteps.deleteElementIfExists("88");
		abstractPageSteps.deleteElementIfExists("89");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("88");
		itemsPageSteps.inputTitleField("test");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("88");
		itemsPageSteps.checkDescriptionFromGrid("88", "test");
		abstractPageSteps.selectItemFromGrid("88");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputKeyFieldTaskType("89");
		itemsPageSteps.inputTitleField("test2");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("89");
		itemsPageSteps.checkDescriptionFromGrid("89", "test2");
		abstractPageSteps.deleteElementIfExists("89");
		itemsPageSteps.checkThatElementIsNotPresent("89");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Close");
		abstractPageSteps.selectActionFromRibbon("Delete");
		abstractPageSteps.clickOk();
		clientsPageSteps.checkThatEntityDoesntExists("Mandate23");
	}
}
