package com.pqi.responsecompare.configuration;

import java.io.File;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;

import com.pqi.responsecompare.request.TestCase;

public class PathGenerator {

	private String response = "";
	private String responseDir = "";
	private String responseTransformed = "";
	private String expectedTransformed = "";
	private String expected = "";
	private String dataSubDir = "";
	private String xslDir = "";
	
	public PathGenerator(TestCase test) {
		String responseCompareDir = "";
		String host = PropertiesSingleton.Instance.getProperty("consult-host");
		responseCompareDir = Utilities.Instance.getResponseCompareRoot();
		String dataDir = responseCompareDir + File.separator +  "data"; 
		dataSubDir = dataDir+ File.separator + "consult" + File.separator + host + File.separator;
		if (test!=null) {
			response = dataSubDir + "response"	+ File.separator + test.getTestCaseID() + "_" + Integer.valueOf(test.getTestRequestCounter()).toString();
			responseTransformed = dataSubDir + "response"	+ File.separator + "transformed" 
					+ File.separator + test.getTestCaseID() + "_" + Integer.valueOf(test.getTestRequestCounter()).toString();
			expectedTransformed = dataSubDir + "expectedresponse" + File.separator
					+ "transformed" + File.separator + test.getTestCaseID() + "_" + Integer.valueOf(test.getTestRequestCounter()).toString();
			xslDir = responseCompareDir + File.separator + "xsl" + File.separator;
			expected = dataSubDir + "expectedresponse" + File.separator + test.getTestCaseID();
			responseDir = dataSubDir + "response" + File.separator;
		}
	}

	public String getResponseFile() {
		return response;
	}

	public String getXslDir() {
		return xslDir;
	}
	
	public String getResponseTransformed() {
		return responseTransformed;
	}
		
	public String getExpectedTransformed() {
		return expectedTransformed;
	}
	
	public String getExpected() {
		return expected;
	}
	
	public String getResponseDir() {
		if (!FileUtils.fileExists(responseDir)) {
			FileUtils.mkdir(responseDir);
		}
		return responseDir;
	}
}
