package com.tools;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.risks.CreateItemsPage;

public class AbstractSteps extends ScenarioSteps {

	public AbstractSteps(Pages pages) {
		super(pages);
	}

	private static final long serialVersionUID = -4313637991347558986L;

	public AbstractPage abstractPage() {
		return getPages().currentPageAt(AbstractPage.class);
	}

	public CreateItemsPage createItemsPage() {
		return getPages().currentPageAt(CreateItemsPage.class);
	}

	public static String[] getVarargs(String parameter) {
		return StringUtils.getSubstringsSplitByKey(parameter, "/");
	}
}
