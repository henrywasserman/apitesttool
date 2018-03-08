package com.pqi.responsecompare.compare;

import com.pqi.responsecompare.configuration.PropertiesSingleton;
import com.pqi.responsecompare.configuration.Utilities;
import com.pqi.responsecompare.request.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Transform;
import org.custommonkey.xmlunit.XMLUnit;
import org.skyscreamer.jsonassert.JSONAssert;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

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

	public void testMyTest() {

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

			File responseFile =  new File(responseFileString);
			File expectedFile = new File (expectedFileString);

			//Make sure that all of the files we are working with exist
			Utilities.Instance.fileChecker(responseFileString);
			Utilities.Instance.fileChecker(expectedFileString);

			response = FileUtils.readFileToString(responseFile);
			expected = FileUtils.readFileToString(expectedFile);

			JSONAssert.assertEquals(expected, response, false);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while comparing response with the expected result" + e.getMessage() ,e);
		}
	}
}