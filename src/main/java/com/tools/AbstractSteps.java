package com.tools;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.ClientsPage;
import com.pages.FilterPage;
import com.pages.HitLogPage;
import com.pages.ItemsPage;
import com.pages.LinksPage;
import com.pages.MandatesPage;
import com.pages.SearchPage;
import com.pages.UploadItemsPage;

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

	public UploadItemsPage uploadItemsPage() {
		return getPages().currentPageAt(UploadItemsPage.class);
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

	public ClientsPage clientsPage() {
		return getPages().currentPageAt(ClientsPage.class);
	}

	public MandatesPage mandatesPage() {
		return getPages().currentPageAt(MandatesPage.class);
	}

	public SearchPage searchPage() {
		return getPages().currentPageAt(SearchPage.class);
	}
}
