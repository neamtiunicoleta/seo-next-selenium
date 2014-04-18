package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;

public class HitLogPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public HitLogPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void clickOnviewLogDetails(String... terms) {
		hitLogPage().clickOnviewLogDetails(terms);
	}

	@Step
	public void checkIfChangesArePresent(String field, String valueBefore,
			String valueAfter) {
		abstractPage().switchToCreateIframe();
		hitLogPage().checkIfChangesArePresent(field, valueBefore, valueAfter);
		getDriver().switchTo().defaultContent();
	}
}
