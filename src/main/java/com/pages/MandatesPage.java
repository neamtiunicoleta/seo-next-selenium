package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class MandatesPage extends AbstractPage {

	public MandatesPage(WebDriver driver) {
		super(driver);
	}

	public void inputKeyField(String key) {
		WebElement keyField = returnField("input", "Key");
		element(keyField).clear();
		element(keyField).type(key);
	}

	public void inputDescriptionField(String description) {
		WebElement descriptionField = returnField("input", "Description");
		element(descriptionField).clear();
		element(descriptionField).type(description);

	}

	public void selectMandateType(String type) {
		getDriver().findElement(By.cssSelector("div[id*='TypeOfMandate']"))
				.click();
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[name*='TypeOfMandate'] option"));
		boolean foundOption = false;
		for (WebElement item : typesList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void selectServiceType(String type) {
		getDriver().findElement(By.cssSelector("div[id*='ddlTypeOfService']"))
				.click();
		;
		List<WebElement> typesList = getDriver().findElements(
				By.cssSelector("select[name*='TypeOfService'] option"));
		boolean foundOption = false;
		for (WebElement item : typesList) {
			if (item.getText().equals(type)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);

	}

	public void checkDescription(String id, String description) {
		checkTextFromField("td:nth-child(3)", id, description);
	}

	public void checkServiceType(String id, String type) {
		checkTextFromField("td:nth-child(4)", id, type);
	}

	public void inputOfficeFileNumber(String number) {
		WebElement officeFileNumberField = returnField("input",
				"OfficeFileNumber");
		element(officeFileNumberField).clear();
		element(officeFileNumberField).type(number);
	}

	public void inputFullName(String name) {
		WebElement fullNameField = returnField("input", "FullName");
		element(fullNameField).clear();
		element(fullNameField).type(name);
	}

	public void inputPOPBox(String pop) {
		WebElement popBox = returnField("input", "POBox");
		element(popBox).clear();
		element(popBox).type(pop);
	}

	public void inputAccountManager(String userName) {
		WebElement identificationMadeByField = getDriver()
				.findElement(
						By.cssSelector("input[id*='UserAccountManager_TopSpan_EditorInput']"));
		element(identificationMadeByField).clear();
		element(identificationMadeByField).type(userName);
		List<WebElement> usersList = getDriver().findElements(
				By.cssSelector("div[id*='AutoFillDiv'] ul li"));

		boolean foundOption = false;
		for (WebElement item : usersList) {
			if (item.getText().contentEquals(userName)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);
	}

	public void inputCompanyType(String type) {
		WebElement companyTypeField = returnField("input", "CompanyType");
		element(companyTypeField).clear();
		element(companyTypeField).type(type);
	}

	public void selectOffice(String offices) {
		getDriver().findElement(By.cssSelector("div[id*='Office']")).click();
		List<WebElement> officesList = getDriver().findElements(
				By.cssSelector("select[name*='Office'] option"));
		boolean foundOption = false;

		for (WebElement item : officesList) {
			if (item.getText().contentEquals(offices)) {
				foundOption = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found!", foundOption);
	}
}
