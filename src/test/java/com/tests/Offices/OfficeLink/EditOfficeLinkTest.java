package com.tests.Offices.OfficeLink;

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
public class EditOfficeLinkTest extends BaseTest {

	@Steps
	public ItemsPageSteps itemsPageSteps;

	@Test
	public void editOfficeLink() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("OfficeLinks");
		abstractPageSteps.deleteElementIfExists("office link");
		abstractPageSteps.selectActionFromRibbon("Create");
		abstractPageSteps.switchToCreateIframe();
		itemsPageSteps.inputTitleField("office link");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		itemsPageSteps.checkIfElementIsPresent("office link");
		abstractPageSteps.selectItemFromGrid("office link");
		abstractPageSteps.selectActionFromRibbon("View");
		abstractPageSteps.selectEditModeButton();
		itemsPageSteps.inputTitleField("office 2");
		abstractPageSteps.selectActionFromRibbon("Save");
		itemsPageSteps.checkIfElementIsPresent("office 2");
		abstractPageSteps.deleteElementIfExists("office 2");
		itemsPageSteps.checkThatElementIsNotPresent("office 2");
	}

}
