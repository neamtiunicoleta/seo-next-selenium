package com.tests.DocumentType;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Edit.EditOfficeLink.class)
@RunWith(ThucydidesRunner.class)
public class EditDocumentTypeTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editDocumentType() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Document Types");
		abstractPageSteps.deleteElementIfExists("test11");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("test11");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("test11");
		abstractPageSteps.selectItemFromGrid("test11");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputTitleField("test22");
		abstractPageSteps.selectActionFromRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("test22");
		abstractPageSteps.deleteElementIfExists("test22");
		itemsPageSteps.checkThatElementIsNotPresent("test22");
	}

}
