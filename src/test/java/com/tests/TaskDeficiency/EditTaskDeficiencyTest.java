package com.tests.TaskDeficiency;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Edit.EditTaskDeficiency.class)
@RunWith(ThucydidesRunner.class)
public class EditTaskDeficiencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editTaskDeficiency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Task Deficiencies");
		abstractPageSteps.deleteElementIfExists("66");
		abstractPageSteps.deleteElementIfExists("67");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("66");
		itemsPageSteps.inputTitleField("task deficiency1");
		itemsPageSteps.selectTaskTypeForDeficienct("PIA");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("66");
		abstractPageSteps.selectItemFromGrid("66");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputKeyFieldTaskType("67");
		itemsPageSteps.inputTitleField("deficiency2");
		itemsPageSteps.selectTaskTypeForDeficienct("Basic doc");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("67");
		itemsPageSteps.checkDescriptionFromGrid("67", "deficiency2");
		itemsPageSteps.checkTypeFromGrid("67", "1");
		abstractPageSteps.deleteElementIfExists("67");
		itemsPageSteps.checkThatElementIsNotPresent("67");
	}

}
