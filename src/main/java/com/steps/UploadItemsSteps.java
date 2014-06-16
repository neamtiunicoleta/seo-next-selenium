package com.steps;

import java.util.Date;

import junit.framework.Assert;

import com.tools.AbstractSteps;
import com.tools.DateUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class UploadItemsSteps extends AbstractSteps {
	public UploadItemsSteps(Pages pages) {
		super(pages);
	}

	private static final long serialVersionUID = 1L;

	@Step
	public void clickOnSelectFilesButton() {
		abstractPage().switchToCreateIframe();
		uploadItemsPage().clickOnSelectFile();
	}

	@Step
	public void insertFilePath(String filePath) {
		uploadItemsPage().insertFilePath(filePath);
	}

	@Step
	public void clickOnUploadFileButton() {
		uploadItemsPage().clickOnUploadFileButton();
		waitABit(4000);
	}

	@Step
	public void selectDocumentType(String type) {
		uploadItemsPage().selectDocumentType(type);
	}

	@Step
	public void inputDocumentDate(String days) {
		uploadItemsPage().inputDocumentDate(
				DateUtils.toString(
						DateUtils.addDays(new Date(), Integer.parseInt(days)),
						"dd/MM/yyyy"));
	}

	@Step
	public void inputAbstract(String text) {
		uploadItemsPage().inputAbstract(text);
	}

	@Step
	public void clickOnChooseButton() {
		uploadItemsPage().clickOnChooseButton();
	}

	@Step
	public void clickOnUploadDocumentsButton() {
		uploadItemsPage().clickOnUploadDocumentsButton();
	}

	@Step
	public void checkIfDocumentExists(String name) {
		Assert.assertTrue("The document is not present", uploadItemsPage()
				.checkIfDocumentExists(name));
	}

	@Step
	public void checkThatDocumentDoesntExists(String name) {
		Assert.assertFalse("The document is not present", uploadItemsPage()
				.checkIfDocumentExists(name));
	}
}
