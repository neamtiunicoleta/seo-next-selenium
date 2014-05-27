package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;
import com.tools.Delay;

public class SearchPage extends AbstractPage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void inputSearchText(String text) {
		WebElement searchField = returnField("input", "SearchInput");
		element(searchField).clear();
		element(searchField).type(text);
	}

	public void clickOnSearchIcon() {
		WebElement searchIcon = getDriver().findElement(
				By.cssSelector("div[class*='searchLink']"));
		element(searchIcon).click();
	}

	public void clickOnMoreButton() {
		WebElement moreButton = getDriver()
				.findElement(
						By.cssSelector("div#searchResultsContainerButtons > input#moreButton"));
		element(moreButton).waitUntilVisible();
		element(moreButton).click();
	}

	public void clickOnHideButton() {
		WebElement moreButton = getDriver()
				.findElement(
						By.cssSelector("div#searchResultsContainerButtons > input#hideButton"));
		element(moreButton).waitUntilVisible();
		element(moreButton).click();
	}

	public boolean checkIfElementIsPresentInSearchResultsList(String... key) {
		boolean hasMorePages = true;
		boolean foundDocument = false;
		while (hasMorePages && !foundDocument) {
			foundDocument = checkIfElementWithSpecifiedTextExistsInList(
					By.cssSelector("div#page_container > ul > li> table > tbody>tr:nth-child(2)>td:nth-child(2)"),
					true, false, key);
			WebElement nextPageButton = getElementIfExists(
					By.cssSelector("a[class*='next_link']"), Delay.SMALL,
					TimeUnit.SECONDS);
			if (nextPageButton == null) {
				hasMorePages = false;
			} else if (!foundDocument) {
				nextPageButton.click();
				waitABit(2000);
			}
		}
		return foundDocument;
	}

	public void selectItemFromSearchResultsList(String key) {

		List<WebElement> resultsList = getDriver().findElements(
				By.cssSelector("div#page_container > ul > li> table > tbody"));

		for (WebElement item : resultsList) {
			WebElement title = item.findElement(By
					.cssSelector("tr:nth-child(2)>td:nth-child(2)"));
			if (title.getText().contentEquals(key)) {
				System.out.println("@@@@@@@@@" + title.getText());
				mouseOver(item.findElement(By
						.cssSelector("tr:nth-child(1)>td:nth-child(4)")));
				item.findElement(
						By.cssSelector("tr:nth-child(1)>td:nth-child(4)"))
						.click();
			}
		}
	}

	public boolean moreButtonIsDisplayed() {
		WebElement moreButton = getDriver()
				.findElement(
						By.cssSelector("div#searchResultsContainerButtons > input#moreButton"));
		if (moreButton.getAttribute("style").contains("inline")) {
			return true;
		}
		return false;
	}
}
