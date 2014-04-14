package com.tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import org.openqa.selenium.WebDriver;

import com.tools.AbstractPageSteps;

public class BaseTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://evo-nico:112")
	public Pages pages;

	@Steps
	public AbstractPageSteps abstractPageSteps;
}
