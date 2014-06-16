package com.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;

public class SearchPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public SearchPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void inputSearchText(String text) {
		searchPage().inputSearchText(text);
	}

	@Step
	public void clickOnSearchIcon() {
		searchPage().clickOnSearchIcon();
	}

	@Step
	public void clickOnMoreButton() {
		searchPage().clickOnMoreButton();
	}

	@Step
	public void clickOnHideButton() {
		searchPage().clickOnHideButton();
	}

	@StepGroup
	public void searchByText(String text) {
		inputSearchText(text);
		clickOnSearchIcon();
		clickOnMoreButton();
	}

	@Step
	public void checkIfElementIsPresentInSearchResultsList(String... key) {
		Assert.assertTrue("The element was not found!", searchPage()
				.checkIfElementIsPresentInSearchResultsList(key));
	}

	@Step
	public void selectItemFromSearchResultsList(String key) {
		searchPage().selectItemFromSearchResultsList(key);
	}

	@StepGroup
	public void searchAndDeleteItem(String key) {
		do {
			inputSearchText(key);
			clickOnSearchIcon();
			waitABit(2000);
			if (searchPage().moreButtonIsDisplayed()) {
				clickOnMoreButton();
				checkIfElementIsPresentInSearchResultsList(key);
				searchPage().selectItemFromSearchResultsList(key);
				abstractPage().selectActionFromRibbon("Delete");
				abstractPage().clickOk();
			} else {
				clickOnHideButton();
			}
		} while (searchPage().moreButtonIsDisplayed());
	}
}
