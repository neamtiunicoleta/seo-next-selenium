package com.tests.TaskDeficiency;

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

@Story(Application.Export.ExportTaskDeficiency.class)
@RunWith(ThucydidesRunner.class)
public class ExportTaskDeficiencyTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;
	@Steps
	public ExportFilesPageSteps exportFilesPageSteps;

	@Test
	public void exportTaskDeficiencies() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Task Deficiencies");
		abstractPageSteps.deleteElementIfExists("816");
		abstractPageSteps.deleteElementIfExists("817");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("816");
		itemsPageSteps.inputTitleField("task deficiency1");
		itemsPageSteps.selectTaskTypeForDeficienct("PIA");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.selectActionFromRibbon("Create");
		itemsPageSteps.inputKeyField("817");
		itemsPageSteps.inputTitleField("task type2");
		itemsPageSteps.selectTaskTypeForDeficienct("Basic doc");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("816");
		itemsPageSteps.checkIfElementIsPresent("817");
		exportFilesPageSteps
				.deleteFilesFromDownloadsFolder("TaskDeficienciesList.xlsx");
		abstractPageSteps.selectActionFromRibbon("Export");
		exportFilesPageSteps
				.checkIfTheFileHasBeenSuccessfullyDownloaded("TaskDeficienciesList.xlsx");
		abstractPageSteps.deleteElementIfExists("816");
		itemsPageSteps.checkThatElementIsNotPresent("816");
		abstractPageSteps.deleteElementIfExists("817");
		itemsPageSteps.checkThatElementIsNotPresent("817");

	}

}
