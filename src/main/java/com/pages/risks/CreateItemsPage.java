package com.pages.risks;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

public class CreateItemsPage extends AbstractPage {

	public CreateItemsPage(WebDriver driver) {
		super(driver);
	}

	public void inputKeyField(String key) {
		WebElement keyField = returnField("input", "idKey");
		element(keyField).clear();
		element(keyField).type(key);
	}

	public void inputDescriptionField(String description) {
		WebElement descriptionField = returnField("textarea", "idDescription");
		element(descriptionField).clear();
		element(descriptionField).type(description);

	}

	public void selectRisk(String category) {
		getDriver().findElement(By.cssSelector("select[id*='ddlRisk']"))
				.click();
		List<WebElement> riskCategoryList = getDriver().findElements(
				By.cssSelector("select[id*='ddlRisk'] option"));
		boolean foundOption = false;
		for (WebElement riskCategory : riskCategoryList) {
			if (riskCategory.getText().equals(category)) {
				foundOption = true;
				riskCategory.click();
				break;
			}
		}
		Assert.assertTrue("The category was not found!", foundOption);

	}

	public boolean checkIfCategoryExists(String id) {
		getDriver().findElement(By.cssSelector("select[id*='ddlRisk']"))
				.click();
		List<WebElement> gridList = getDriver().findElements(
				By.cssSelector("select[id*='ddlRisk'] option"));
		for (WebElement item : gridList) {
			if (item.getText().contains(id)) {
				return true;
			}

		}
		return false;
	}

	public void checkActive() {
		WebElement activeCheckBox = returnField("input", "idFormSectionActive");
		element(activeCheckBox).click();
	}

	public void checkDescription(String id, String description) {
		checkTextFromField("td.gridDescriptionColumn", id, description);
	}

	public void inputCodeField(String code) {
		WebElement codeField = returnField("input", "txtCode");
		element(codeField).clear();
		element(codeField).type(code);
	}

	public void inputTitleField(String title) {
		WebElement titleField = returnField("input", "txtTitle");
		element(titleField).clear();
		element(titleField).type(title);
	}

	public void checkTitle(String id, String title) {
		checkTextFromField("td:nth-child(3)", id, title);
	}
}