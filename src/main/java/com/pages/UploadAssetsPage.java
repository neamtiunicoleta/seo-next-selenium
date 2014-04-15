package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;
import com.tools.Constants;

public class UploadAssetsPage extends AbstractPage {

	public UploadAssetsPage(WebDriver driver) {
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

}
