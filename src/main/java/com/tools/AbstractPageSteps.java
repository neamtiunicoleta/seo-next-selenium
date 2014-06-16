package com.tools;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class AbstractPageSteps extends AbstractSteps {

	public AbstractPageSteps(Pages pages) {
		super(pages);
	}

	private static final long serialVersionUID = 1L;

	@Step
	public void selectMenuOption(String optionMenu) {
		abstractPage().selectMenuOption(optionMenu);
	}

	@Step
	public void selectActionFromCreateAndEditPage(String action) {
		abstractPage().selectActionFromRibbon(action);
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void openLoginPage(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}

	@Step
	public void switchToCreateIframe() {
		abstractPage().switchToCreateIframe();
	}

	@Step
	public void selectItemFromGrid(String itemId) {
		abstractPage().selectItemFromGrid(itemId);
	}

	@Step
	public void clickOk() {
		abstractPage().clickOk();
	}

	@Step
	public void deleteElementIfExists(String id) {
		while ((abstractPage().checkIfElementIsPresent(id))) {
			abstractPage().selectItemFromGrid(id);
			selectActionFromRibbon("Delete");
			abstractPage().clickOk();
		}
	}

	@Step
	public void deleteAllItems() {
		abstractPage().clickOnTitleCheckBox();
		selectActionFromRibbon("Delete");
		abstractPage().clickOk();
	}

	@Step
	public void selectActionFromRibbon(String action) {
		abstractPage().selectActionFromRibbon(action);
	}

	@Step
	public void selectActionFromLeftMenu(String action) {
		abstractPage().selectActionFromLeftMenu(action);
	}

	@Step
	public void selectActionFromTopMenu(String action) {
		abstractPage().selectActionFromTopMenu(action);
	}

	@Step
	public void closeHitlogDetailsPage() {
		switchToCreateIframe();
		abstractPage().selectActionFromRibbon("Close");
	}

	@Step
	public void clickOnTab(String tabName) {
		abstractPage().clickOnTab(tabName);
	}

	@Step
	public void goToHomePage() {
		abstractPage().clickOnLogo();
	}

	@Step
	public void selectEditModeButton() {
		abstractPage().switchToCreateIframe();
		abstractPage().selectActionFromRibbon("Edit");
	}

	@Step
	public void checkIfTabIsPresent(String tabName) {
		Assert.assertTrue("The tab is not present", abstractPage()
				.checkIfTabIsPresent(tabName));
	}

	@Step
	public void checkThatTabIsNotPresent(String tabName) {
		Assert.assertFalse("The tab is not present", abstractPage()
				.checkIfTabIsPresent(tabName));
	}
}
