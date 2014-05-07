package com.tools;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.FilterPage;
import com.pages.HitLogPage;
import com.pages.ItemsPage;
import com.pages.LinksPage;
import com.pages.UploadAssetsPage;

public class AbstractSteps extends ScenarioSteps {

	public AbstractSteps(Pages pages) {
		super(pages);
	}

	private static final long serialVersionUID = -4313637991347558986L;

	public AbstractPage abstractPage() {
		return getPages().currentPageAt(AbstractPage.class);
	}

	public ItemsPage itemsPage() {
		return getPages().currentPageAt(ItemsPage.class);
	}

	public static String[] getVarargs(String parameter) {
		return StringUtils.getSubstringsSplitByKey(parameter, "/");
	}

	public UploadAssetsPage uploadAssetsPage() {
		return getPages().currentPageAt(UploadAssetsPage.class);
	}

	public HitLogPage hitLogPage() {
		return getPages().currentPageAt(HitLogPage.class);
	}

	public FilterPage filterPage() {
		return getPages().currentPageAt(FilterPage.class);
	}

	public LinksPage linksPage() {
		return getPages().currentPageAt(LinksPage.class);
	}
}
