package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;
import com.tools.Constants;

public class UploadItemsPage extends AbstractPage {

	public UploadItemsPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnSelectFile() {
		try {
			implicitlyWaitSmall();
			WebElement selectFilesButton = getDriver().findElement(
					By.cssSelector("input[id*='FileUpload']"));
			selectFilesButton.click();
		} catch (Exception e) {
			implicitlyWaitDefault();
			try {
				clickOnButtonUsingSikuli(Constants.SIKULI_IMAGES_FOLDER
						+ "SelectFilesToUploadButton.png");
			} catch (Exception e1) {
				e1.printStackTrace();
				Assert.fail("Could not click on the select file button!");
			}
		}
	}

	public void clickOnUploadFileButton() {
		WebElement uploadFileButton = getDriver().findElement(
				By.cssSelector("input[id*='UploadButton']"));
		$(uploadFileButton).waitUntilVisible();
		uploadFileButton.click();
	}

	public void insertFilePath(String filePath) {
		try {
			clickOnButtonUsingSikuli(Constants.SIKULI_IMAGES_FOLDER
					+ "FileUploadInput.PNG");
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail("Could not click on the upload file button!");
		}
		typeAndEnterUsingSikuli(filePath);
	}

	public void selectDocumentType(String type) {
		getDriver().findElement(
				By.cssSelector("div[id*='uploadDiv'] tbody tr:first-child"))
				.click();
		List<WebElement> typeList = getDriver().findElements(
				By.cssSelector("select[id*='ddlDocumentsType'] option"));
		boolean foundOption = false;
		for (WebElement item : typeList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void inputDocumentDate(String date) {
		WebElement documentDateFiedld = getDriver()
				.findElement(
						By.cssSelector("div[id*='uploadDiv'] tbody tr:nth-child(2) input"));
		element(documentDateFiedld).clear();
		element(documentDateFiedld).type(date);
	}

	public void inputAbstract(String text) {
		WebElement abstractField = returnField("textarea", "txtAbstract");
		element(abstractField).type(text);
	}

	public void clickOnChooseButton() {
		WebElement browseButton = returnField("input", "uploadFile");
		element(browseButton).click();
	}

	public void clickOnUploadDocumentsButton() {
		getDriver().findElement(
				By.cssSelector("div#uploadDiv tbody tr:nth-child(5) input"))
				.click();
	}

	public boolean checkIfDocumentExists(String terms) {
		List<WebElement> docList = getDriver()
				.findElements(
						By.cssSelector("div[id*='documentsGrid__div'] table.ms-listviewtable > tbody > tr td:nth-child(2)"));
		for (WebElement item : docList) {
			System.out.println("@@@@@@@@"+item.getText());
			if (item.getText().contains(terms)) {
				return true;

			}
		}
		return false;

	}

}
