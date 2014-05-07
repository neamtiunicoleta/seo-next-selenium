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

	public void selectSourceObject(String source) {
		WebElement sourceObjectList = getDriver().findElement(
				By.cssSelector("div[id*='SourceObject']"));
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

	public void selectTargetObject(String target) {
		WebElement sourceObjectList = getDriver().findElement(
				By.cssSelector("div[id*='TargetObject']"));
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

	public void inputRelations(String relation) {
		WebElement relationField = returnField("input", "idRelations");
		element(relationField).clear();
		element(relationField).type(relation);
	}

	public void checkSourceForLinkCategories(String id, String source) {
		checkTextFromField("td:nth-child(3)", id, source);
	}

	public void checkTargetForLinkCategories(String id, String target) {
		checkTextFromField("td:nth-child(4)", id, target);
	}

	public void checkRelations(String id, String relation) {
		checkTextFromField("td:nth-child(5)", id, relation);
	}

	public void checkLinkCategory(String id, String linkCategory) {
		checkTextFromField("td:nth-child(3)", id, linkCategory);
	}
}
