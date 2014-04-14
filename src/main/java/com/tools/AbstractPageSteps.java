package com.tools;

import junit.framework.Assert;
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
	public void selectActionFromManagePagesRibbon(String action) {
		abstractPage().selectActionFromHeader("ACTIONS");
		abstractPage().selectActionFromRibbon(action);
	}

	@Step
	public void checkIfElementExists(String key) {
		Assert.assertTrue("The element is not present!", abstractPage()
				.checkIfElementExists(key));
		waitABit(2000);

	}

	@Step
	public void checkIfElementDoesntExists(String key) {
		Assert.assertFalse("The element is present!", abstractPage()
				.checkIfElementExists(key));
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
		if (abstractPage().checkIfElementExists(id)) {
			abstractPage().selectItemFromGrid(id);
			selectActionFromManagePagesRibbon("Delete");
			abstractPage().clickOk();
		}
	}

}
