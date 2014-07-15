package com.tests.TaskTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Edit.EditTaskType.class)
@RunWith(ThucydidesRunner.class)
public class EditTaskTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editTaskType() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Task Types");
		abstractPageSteps.deleteElementIfExists("11");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("11");
		itemsPageSteps.inputTitleField("task1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("11");
		abstractPageSteps.selectItemFromGrid("11");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputKeyFieldTaskType("12");
		itemsPageSteps.inputTitleField("task2");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("12");
		itemsPageSteps.checkDescriptionFromGrid("12", "task2");
		abstractPageSteps.deleteElementIfExists("12");
		itemsPageSteps.checkThatElementIsNotPresent("12");
	}

}
