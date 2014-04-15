package com.steps;

import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class UploadAssetsSteps extends AbstractSteps {
	private static final long serialVersionUID = 1L;

	public UploadAssetsSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void clickOnSelectFilesButton() {
		abstractPage().switchToCreateIframe();
		uploadAssetsPage().clickOnSelectFile();
	}

	@Step
	public void insertFilePath(String filePath) {
		uploadAssetsPage().insertFilePath(filePath);
	}

	@Step
	public void clickOnUploadFileButton() {
		uploadAssetsPage().clickOnUploadFileButton();
		waitABit(4000);
	}
//
//	@Step
//	public void clickOnCancelUploadButton() {
//		uploadAssetsPage().clickOnCancelOkUpload();
//	}
//
//	@Step
//	public void clickOnOkUploadButton() {
//		uploadAssetsPage().clickOnCancelOkUpload();
//	}
//
//	@Step
//	public void selectVersionType(String versionType) {
//		alfrescoUploadAssetsPage.selectVersionType(versionType);
//	}
//
//	@Step
//	public void inputCommentField(String comment) {
//		uploadAssetsPage().inputCommentField(comment);
//	}
//
//	@Step
//	public void checkThatUploadButtonIsDisabled() {
//		uploadAssetsPage().checkThatUploadButtonIsDisabled();
//	}
//
//	@Step
//	public void clickOnRemoveFile() {
//		uploadAssetsPage().clickOnRemoveFile();
//	}
//
//	@Step
//	public void checkThatNoFilesWereSelected(String message) {
//		uploadAssetsPage().checkThatNoFilesWereSelected(message);
//	}

}
