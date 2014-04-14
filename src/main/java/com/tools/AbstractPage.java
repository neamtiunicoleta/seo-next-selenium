package com.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage extends PageObject {

	public AbstractPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts()
				.setScriptTimeout(Delay.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(Delay.DEFAULT, TimeUnit.SECONDS);
	}

	private void implicitlyWait(long time) {
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void implicitlyWaitDefault() {
		implicitlyWait(Delay.DEFAULT);
	}

	public void implicitlyWaitSmall() {
		implicitlyWait(Delay.SMALL);
	}

	public void implicitlyWaitReasonable() {
		implicitlyWait(Delay.REASONABLE);
	}

	public void implicitlyWaitExtraSmall() {
		implicitlyWait(Delay.EXTRA_SMALL);
	}

	public void implicitlyWaitMedium() {
		implicitlyWait(Delay.MEDIUM);
	}

	public void implicitlyWaitLarge() {
		implicitlyWait(Delay.LARGE);
	}

	public void implicitlyWaitExtraLarge() {
		implicitlyWait(Delay.EXTRA_LARGE);
	}

	public void switchToCreateIframe() {
		WebElement createIframe = getDriver().findElement(
				By.cssSelector("iframe[class*='dlgFrame']"));
		getDriver().switchTo().frame(createIframe);

	}

	public void selectActionFromHeader(String actionName) {
		List<WebElement> actionsTab = getDriver().findElements(
				By.cssSelector("div#RibbonContainer li > a span"));
		boolean foundOption = false;
		for (WebElement action : actionsTab) {
			if (action.getText().contains(actionName)) {

				foundOption = true;
				action.click();
				break;
			}
		}
		Assert.assertTrue("The action from header was not found!", foundOption);
	}

	public void selectActionFromRibbon(String action) {

		List<WebElement> ribbonButtonsList = getDriver()
				.findElements(
						By.cssSelector("div#RibbonContainer div[class*='tabContainer'] li span > a span"));
		boolean foundOption = false;

		for (WebElement option : ribbonButtonsList) {

			if (option.getText().contains(action)) {
				foundOption = true;
				option.click();
				break;
			}
		}
		Assert.assertTrue("The" + action + " was not found!", foundOption);

		waitABit(3000);
	}

	public WebElement returnField(String fieldType, String fieldName) {
		WebElement element = null;
		List<WebElement> inputList = getDriver().findElements(
				By.tagName(fieldType));
		boolean foundInput = false;
		for (WebElement input : inputList) {
			if (input.getAttribute("name").contains(fieldName)) {
				foundInput = true;
				return input;
			}

		}
		Assert.assertTrue("The field was not found", foundInput);
		return element;
	}

// public boolean checkIfElementExists(String id) {
	// List<WebElement> gridList = getDriver()
	// .findElements(
	// By.cssSelector("div[id*='seoGridView'] > table > tbody > tr td[class*='title']"));
	// for (WebElement item : gridList) {
	// if (item.getText().contains(id)) {
	// return true;
	// }
	//
	// }
	// return false;
	// }

	public void selectItemFromGrid(String itemId) {
		List<WebElement> gridList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridView']  table.ms-listviewtable > tbody > tr"));
		gridList.remove(0);
		for (WebElement elemNow : gridList) {
			String elemId = elemNow.findElement(
					By.cssSelector("a.ms-core-menu-root")).getText();
			elemId = elemId.replace("\n", "");
			elemId = elemId.replace(
					"Use SHIFT+ENTER to open the menu (new window).", "");

			if (elemId != null && itemId.contentEquals(elemId)) {
				elemNow.findElement(By.cssSelector("input")).click();
				break;
			}
		}
	}

	public void clickOk() {
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
	}

	public void checkTextFromField(String fieldType, String id, String text) {
		String result = "";
		List<WebElement> gridList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridView'] table.ms-listviewtable > tbody > tr"));
		gridList.remove(0);

		for (WebElement elemNow : gridList) {
			String elemId = elemNow.findElement(
					By.cssSelector("a.ms-core-menu-root")).getText();
			elemId = elemId.replace("\n", "");
			elemId = elemId.replace(
					"Use SHIFT+ENTER to open the menu (new window).", "");

			if (elemId != null && id.contentEquals(elemId)) {
				result = elemNow.findElement(By.cssSelector(fieldType))
						.getText();

				break;
			}

		}

		Assert.assertTrue("The text is not correct", result.contains(text));
	}

	public void selectMenuOption(String optionTitle) {
		boolean foundOption = false;
		List<WebElement> homeMenuOptionsList = getDriver()
				.findElements(
						By.cssSelector("div[id*='DeltaPlaceHolderMain'] table div[id*='Tile'] li[id*='Tile']> div"));
		for (WebElement option : homeMenuOptionsList) {
			if (option.getText().contains(optionTitle)) {
				foundOption = true;
				option.click();
				break;
			}
		}
		Assert.assertTrue("The " + optionTitle + " option was not found!",
				foundOption);
		waitABit(3000);
	}

	public List<WebElement> getVisibleElementsFromList(
			List<WebElement> elementsList) {
		for (int i = 0; i < elementsList.size(); i++) {
			WebElement element = elementsList.get(i);
			if (!$(element).isCurrentlyVisible()) {
				elementsList.remove(i);
				i--;
			}
		}
		return elementsList;
	}

	public boolean checkIfElementWithSpecifiedTextExistsInList(By by,
			boolean ignoreCase, boolean equals, String... terms) {
		implicitlyWaitReasonable();
		List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
				.findElements(by));
		for (WebElement element : elementsList) {
			String currentElementName = element.getText().trim();
			if (ignoreCase)
				currentElementName = currentElementName.toLowerCase();
			boolean matched = false;
			if (terms.length == 1) {
				if (ignoreCase)
					matched = equals ? currentElementName.equals(terms[0]
							.toLowerCase()) : currentElementName
							.contains(terms[0].toLowerCase());
				else
					matched = equals ? currentElementName.equals(terms[0])
							: currentElementName.contains(terms[0]);
			} else
				matched = StringUtils.checkIfTextContainsTerms(
						currentElementName, ignoreCase, terms);
			if (matched)
				return true;
		}
		return false;
	}

	public WebElement getElementIfExists(By by, int waitingTime,
			TimeUnit timeUnit) {
		getDriver().manage().timeouts().implicitlyWait(waitingTime, timeUnit);
		try {
			WebElement element = getDriver().findElement(by);
			implicitlyWaitDefault();
			return element;
		} catch (Exception e) {
			implicitlyWaitDefault();
			return null;
		}
	}
}