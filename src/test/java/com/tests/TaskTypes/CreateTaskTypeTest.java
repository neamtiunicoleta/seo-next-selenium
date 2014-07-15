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

@Story(Application.Create.CreateTaskType.class)
@RunWith(ThucydidesRunner.class)
public class CreateTaskTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createTaskType() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Task Types");
		abstractPageSteps.deleteElementIfExists("55");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("55");
		itemsPageSteps.inputTitleField("task type1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("55");
		itemsPageSteps.checkDescriptionFromGrid("55", "task type1");
		abstractPageSteps.deleteElementIfExists("55");
		itemsPageSteps.checkThatElementIsNotPresent("55");
	}
}
