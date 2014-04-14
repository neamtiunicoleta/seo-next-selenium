package com.tests.BusinessCodes;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.CreateItemsPageSteps;
import com.tests.BaseTest;
import com.tools.Application;
import com.tools.Constants;

@Story(Application.Edit.EditBusinessode.class)
@RunWith(ThucydidesRunner.class)
public class EditBusinessCodeTest extends BaseTest {

	@Steps
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void editBusinessCode() {
		abstractPageSteps.openLoginPage(Constants.SEONEXT_BASE_URL);
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("702");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCategoryOrAsset("702", "Edit Risk");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createRiskCriteria("893", "Edit Risk", "702");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Business Codes");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.selectActionFromManagePagesRibbon("Create");
		createItemsPageSteps.createBusinessCode("594", "Kenya", "893");
		abstractPageSteps.selectItemFromGrid("594");
		abstractPageSteps.selectActionFromManagePagesRibbon("Edit");
		abstractPageSteps.switchToCreateIframe();
		createItemsPageSteps.inputTitleField("Germany");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		createItemsPageSteps.checkTitle("594", "Germany");
		abstractPageSteps.deleteElementIfExists("594");
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("702");
	}

}
