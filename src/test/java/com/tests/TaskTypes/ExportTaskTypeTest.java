package com.tests.TaskTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ExportFilesPageSteps;
import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Export.ExportTaskType.class)
@RunWith(ThucydidesRunner.class)
public class ExportTaskTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;

	@Test
	public void exportTaskTypes() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Task Types");
		abstractPageSteps.deleteElementIfExists("816");
		abstractPageSteps.deleteElementIfExists("817");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("816");
		itemsPageSteps.inputTitleField("task type1");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("817");
		itemsPageSteps.inputTitleField("task type2");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("816");
		itemsPageSteps.checkIfElementIsPresent("817");
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("TaskTypesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("TaskTypesList.xlsx");
		abstractPageSteps.deleteElementIfExists("816");
		itemsPageSteps.checkThatElementIsNotPresent("816");
		abstractPageSteps.deleteElementIfExists("817");
		itemsPageSteps.checkThatElementIsNotPresent("817");

	}

}
