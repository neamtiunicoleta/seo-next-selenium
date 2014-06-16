package com.steps;

import java.io.File;

import net.thucydides.core.pages.Pages;

import com.tools.AbstractSteps;
import com.tools.FileUtils;

public class ExportFilesPageSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	public ExportFilesPageSteps(Pages pages) {
		super(pages);
	}

	public void deleteFilesFromDownloadsFolder(String searchedTerms) {
		FileUtils.deleteFilesContainingStringsInNameFromDirectory(
				FileUtils.getCurrentUserPath() + "\\Downloads",
				getVarargs(searchedTerms));
	}

	public void checkIfTheFileHasBeenSuccessfullyDownloaded(
			String fileIdentifiers) {
		waitABit(10000);
		File downloadedFile = FileUtils.searchFileRecursively(
				FileUtils.getCurrentUserPath() + "\\Downloads",
				new String[] { "zip", "xml", "doc", "xlsx" }, false,
				getVarargs(fileIdentifiers)).get(0);
	}
}
