package com.pages;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class HitLogPage extends AbstractPage {

	public HitLogPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnviewLogDetails(String... terms) {
		List<WebElement> gridList = getDriver()
				.findElements(
						By.cssSelector("div[id*='seoGridView']  table.ms-listviewtable > tbody > tr"));
		gridList.remove(0);
		boolean foundLog = false;
		for (WebElement elemNow : gridList) {
			String elemId = elemNow.findElement(
					By.cssSelector("a.ms-core-menu-root")).getText();
			elemId = elemId.replace("\n", "");
			elemId = elemId.replace(
					"Use SHIFT+ENTER to open the menu (new window).", "");

			for (String term : terms) {
				if (elemId != null && elemId.contains(term))
					foundLog = true;
				break;
			}
			if (foundLog) {
				elemNow.findElement(By.cssSelector("a.ms-core-menu-root"))
						.click();
				elemNow.findElement(
						By.cssSelector("a[id*='Anchor'] div[id*='viewitem']"))
						.click();
				break;
			}

		}
	}

	public void checkIfChangesArePresent(String field, String valueBefore,
			String valueAfter) {
		List<WebElement> changesList = getDriver()
				.findElements(
						By.cssSelector("div[id*='DeltaPlaceHolderMain'] > table:nth-of-type(2) > tbody > tr"));
		boolean itemCorrect = false;
		for (WebElement item : changesList) {
			if (item.findElement(By.cssSelector("td:first-child")).getText()
					.equals(field)) {
				if (item.findElement(By.cssSelector("td:nth-child(2)"))
						.getText().equals(valueBefore)
						&& item.findElement(By.cssSelector("td:nth-child(3)"))
								.getText().equals(valueAfter)) {
					itemCorrect = true;
					break;
				}

			}

		}

		Assert.assertTrue("The changes are not correct", itemCorrect);

	}
}
