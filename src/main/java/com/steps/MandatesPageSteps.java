package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;

public class MandatesPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public MandatesPageSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void inputKeyField(String key) {
		abstractPage().switchToCreateIframe();
		mandatesPage().inputKeyField(key);
	}

	@Step
	public void inputDescriptionField(String description) {
		mandatesPage().inputDescriptionField(description);
	}

	@Step
	public void selectServiceType(String type) {
		mandatesPage().selectServiceType(type);
	}

	@Step
	public void checkDescription(String id, String description) {
		mandatesPage().checkDescription(id, description);
	}

	@Step
	public void checkServiceType(String id, String type) {
		mandatesPage().checkServiceType(id, type);
	}

	@Step
	public void selectMandateType(String type) {
		mandatesPage().selectMandateType(type);
	}

	@Step
	public void inputOfficeFileNumber(String number) {
		mandatesPage().inputOfficeFileNumber(number);
	}

	@Step
	public void inputFullName(String name) {
		mandatesPage().inputFullName(name);
	}

	@Step
	public void inputPOPBox(String pop) {
		mandatesPage().inputPOPBox(pop);
	}

	@Step
	public void inputAccountManager(String userName) {
		mandatesPage().inputAccountManager(userName);
	}

	@Step
	public void inputCompanyType(String type) {
		mandatesPage().inputCompanyType(type);
	}

	@Step
	public void selectOffice(String office) {
		mandatesPage().selectOffice(office);

	}
}
