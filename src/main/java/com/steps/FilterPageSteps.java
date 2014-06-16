package com.steps;

import java.util.Date;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;
import com.tools.DateUtils;

public class FilterPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public FilterPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void clickOnFilterDropdownList() {
		filterPage().clickOnFilterDropdownList();
	}

	@Step
	public void selectTypeFilter(String filter) {
		filterPage().selectTypeFilter(filter);
	}

	@Step
	public void clickOnFilterButton() {
		filterPage().clickOnFilterButton();
	}

	@Step
	public void inputUsername(String user) {
		filterPage().inputUsername(user);
	}

	@Step
	public void clickOnClearFiltersButton() {
		filterPage().clickOnClearFiltersButton();
	}

	@Step
	public void clickOnFilterByDateCheckBox() {
		filterPage().clickOnFilterByDateCheckBox();
	}

	@Step
	public void inputFromDateField(String days) {
		filterPage().inputFromDateField(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void inputToDateField(String days) {
		filterPage().inputToDateField(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void inputBussinessCode(String code) {
		filterPage().inputBussinessCode(code);
	}

	@Step
	public void inputName(String name) {
		filterPage().inputName(name);
	}

	@Step
	public void inputCountryCode(String country) {
		filterPage().inputCountryCode(country);
	}

	@Step
	public void inputCountryTitle(String country) {
		filterPage().inputCountryTitle(country);
	}

	@Step
	public void inputISOCode(String isoCode) {
		filterPage().inputISOCode(isoCode);
	}

	@Step
	public void checkActiveCheckBox() {
		filterPage().checkActiveCheckBox();
	}

	@Step
	public void checkRiskyCheckBox() {
		filterPage().checkRiskyCheckBox();
	}

	@Step
	public void inputTitle(String title) {
		filterPage().inputTitle(title);
	}

	@Step
	public void inputRelations(String relation) {
		filterPage().inputRelations(relation);
	}

}
