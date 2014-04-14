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

@Story(Application.Create.CreateBusinessCode.class)
@RunWith(ThucydidesRunner.class)
public class CreateBusinessCodeTest extends BaseTest {

	@Steps
	public CreateItemsPageSteps createItemsPageSteps;

	@Test
	public void createBusinessCode() {
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
		createItemsPageSteps.inputCodeField("594");
		createItemsPageSteps.inputTitleField("Kenya");
		createItemsPageSteps.selectRisk("893");
		abstractPageSteps.selectActionFromCreateAndEditPage("Save");
		abstractPageSteps.checkIfElementExists("594");
		createItemsPageSteps.checkTitle("594", "Kenya");
		abstractPageSteps.selectItemFromGrid("594");
		abstractPageSteps.selectActionFromManagePagesRibbon("Delete");
		abstractPageSteps.clickOk();
		abstractPageSteps.selectActionFromManagePagesRibbon("Close");
		abstractPageSteps.selectMenuOption("Risk Management");
		abstractPageSteps.deleteElementIfExists("893");
		abstractPageSteps.selectActionFromManagePagesRibbon("Categories");
		abstractPageSteps.deleteElementIfExists("702");
	}

}
