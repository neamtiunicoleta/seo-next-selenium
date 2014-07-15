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

@Story(Application.Create.CreateTaskDeficiency.class)
@RunWith(ThucydidesRunner.class)
public class CreateTaskDeficiencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void createTaskDeficiency() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Task Deficiencies");
		abstractPageSteps.deleteElementIfExists("32");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("32");
		itemsPageSteps.inputTitleField("task deficiency1");
		itemsPageSteps.selectTaskTypeForDeficienct("PIA");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("32");
		itemsPageSteps.checkDescriptionFromGrid("32", "task deficiency1");
		itemsPageSteps.checkTypeFromGrid("32", "3");
		abstractPageSteps.deleteElementIfExists("32");
		itemsPageSteps.checkThatElementIsNotPresent("32");
	}
}
