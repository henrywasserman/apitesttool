package com.pqi.responsecompare.compare;

import com.pqi.responsecompare.reports.CreateOutput;
import com.pqi.responsecompare.configuration.Utilities;
import com.pqi.responsecompare.request.TestCase;
import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.Diff;
import org.skyscreamer.jsonassert.JSONAssert;
import org.w3c.dom.Document;
import java.io.File;
import org.junit.Assert;

public class SQLCompare extends Compare {

	private Diff diff = null;
	private String response = "";
	private String expected = "";

	static class TestData {
		Document response = null;
		Document expectedresponse = null;

		public TestData(Document expectedresponse,
				Document response) {
			this.expectedresponse = expectedresponse;
			this.response = response;
		}

		public Document getResponse() {
			return response;
		}

		public Document getResponseGold() {
			return expectedresponse;
		}
	}

	public SQLCompare(TestCase test) {
		super(test);

	}

	public SQLCompare(String testMethodName) {
		super(testMethodName);
	}

	public SQLCompare(String testMethodName, String fileName) {
		super(testMethodName);
		this.fileName = fileName;
	}
	
	public void results() throws Exception {
		
		try {
			String sqlReqNum = Integer.toString(test.getTestRequestCounter());
			String responseFileString = pathGenerator.getResponseFile() + ".json";
			String expectedFileString = pathGenerator.getExpected() + "_" + sqlReqNum + ".json";
			String expectedHTMLFileString = pathGenerator.getExpected() + "_" + sqlReqNum + ".html";

			File responseFile =  new File(responseFileString);
			File expectedFile = new File (expectedFileString);
			File expectedHTMLFile = new File (expectedHTMLFileString);

			//Make sure that all of the files we are working with exist
			Utilities.Instance.fileChecker(responseFileString);
			Utilities.Instance.fileChecker(expectedFileString);

			response = FileUtils.readFileToString(responseFile);
			expected = FileUtils.readFileToString(expectedFile);

			String html = "";
			//TODO: Make sure this does not happen for SQL Requests
			if (expectedHTMLFile.length() == 0) {
				html = CreateOutput.Instance.returnEmptyJsonStringHTML();
			} else {
				html = CreateOutput.Instance.JSONToHTML(expected, test);
			}
			FileUtils.writeStringToFile(expectedHTMLFile,html);

			if (expected.isEmpty()) {
				Assert.fail("Expected json data has not been created yet.");
			}

			JSONAssert.assertEquals(expected, response, false);


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while comparing response with the expected result" + e.getMessage() ,e);
		}
	}
}
