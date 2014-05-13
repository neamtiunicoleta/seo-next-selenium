package com.pages;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class LinksPage extends AbstractPage {

	public LinksPage(WebDriver driver) {
		super(driver);
	}

	public void switchToCreateIframe() {
		WebElement createIframe = getDriver().findElement(
				By.cssSelector("iframe[class*='dlgFrame']"));
		getDriver().switchTo().frame(createIframe);

	}

	public void inputTitle(String title) {
		WebElement titleField = returnField("input", "idTitle");
		element(titleField).clear();
		element(titleField).type(title);
	}

	public void selectSourceObjectType(String source) {
		WebElement sourceObjectList = getDriver().findElement(
				By.cssSelector("div[id*='SourceObject']"));
		element(sourceObjectList).click();

		List<WebElement> sourceList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;

		for (WebElement item : sourceList) {
			if (item.getText().contains(source)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);

	}

	public void selectSourceObject(String source) {
		WebElement sourceObjectList = getDriver()
				.findElement(
						By.cssSelector("div [id*='UpdatePanel1'] div[id*='SourceObject']"));
		element(sourceObjectList).click();

		List<WebElement> sourceList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;

		for (WebElement item : sourceList) {
			System.out.println("@@@@@@@@@@@" + item.getText());
			if (item.getText().contains(source)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);

	}

	public void selectTargetObjectType(String target) {
		WebElement sourceObjectList = getDriver().findElement(
				By.cssSelector("div[id*='TargetObject']"));
		element(sourceObjectList).click();

		List<WebElement> sourceList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;

		for (WebElement item : sourceList) {
			if (item.getText().contains(target)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);

	}

	public void selectTargetObject(String target) {
		waitABit(1000);
		WebElement sourceObjectList = getDriver()
				.findElement(
						By.cssSelector("div [id*='UpdatePanel2'] div[id*='TargetObject']"));
		element(sourceObjectList).click();

		List<WebElement> sourceList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;

		for (WebElement item : sourceList) {
			System.out.println("@@@@@@@@@@@" + item.getText());
			if (item.getText().contains(target)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);

	}

	public void selectLinkCategory(String category) {
		WebElement sourceObjectList = getDriver().findElement(
				By.cssSelector("div[id*='LinkCategory']"));
		element(sourceObjectList).click();

		List<WebElement> sourceList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;

		for (WebElement item : sourceList) {
			System.out.println("@@@@@@@@@@@" + item.getText());
			if (item.getText().contains(category)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);

	}

	public void selectLinkType(String linkType) {
		WebElement sourceObjectList = getDriver().findElement(
				By.cssSelector("div[id*='LinkType']"));
		element(sourceObjectList).click();

		List<WebElement> sourceList = getDriver().findElements(
				By.cssSelector("div[class*='select2-drop'] ul li"));
		boolean foundOption = false;

		for (WebElement item : sourceList) {
			System.out.println("@@@@@@@@@@@" + item.getText());
			if (item.getText().contains(linkType)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);

	}

	public void inputRelations(String relation) {
		WebElement relationField = returnField("input", "idRelations");
		element(relationField).clear();
		element(relationField).type(relation);
	}

	public void checkSource(String id, String source) {
		checkTextFromField("td:nth-child(3)", id, source);
	}

	public void checkTarget(String id, String target) {
		checkTextFromField("td:nth-child(4)", id, target);
	}

	public void checkRelations(String id, String relation) {
		checkTextFromField("td:nth-child(5)", id, relation);
	}

	public void checkLinkCategory(String id, String linkCategory) {
		checkTextFromField("td:nth-child(3)", id, linkCategory);
	}

	public void inputComments(String comment) {
		WebElement commentField = returnField("textarea", "Comments");
		element(commentField).waitUntilVisible();
		element(commentField).clear();
		element(commentField).type(comment);
	}

	public void clickOnActiveCheckBox() {
		WebElement activeCheckBox = returnField("input", "SEOActive");
		element(activeCheckBox).click();
	}

	public void checkLinkType(String id, String linkType) {
		checkTextFromField("td:nth-child(5)", id, linkType);
	}

	public void checkIfActiveCheckBoxIsChecked(String id) {
		Assert.assertTrue("The checkbox is not checked",
				checkCheckBox("input[id*='linkActive']", id));
	}

	public void checkIfActiveCheckBoxIsNotChecked(String id) {
		Assert.assertFalse("The checkbox is not checked",
				checkCheckBox("input[id*='linkActive']", id));
	}
}
