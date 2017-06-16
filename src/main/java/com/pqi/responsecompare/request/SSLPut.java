package com.pqi.responsecompare.request;

import java.io.ByteArrayOutputStream;
import java.io.File;

import nu.xom.Builder;
import nu.xom.Serializer;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.log4j.Logger;
import org.apache.maven.surefire.shade.org.apache.commons.io.IOUtils;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;

import com.pqi.responsecompare.configuration.Utilities;
import com.pqi.responsecompare.json.HandleJSONRequest;
import com.pqi.responsecompare.json.JSONToMap;
import com.pqi.responsecompare.splunk.SplunkManager;


public class SSLPut extends Request {
	static Logger logger = Logger.getLogger(SSLPut.class);

	public SSLPut(TestCase test) throws Exception {
		super(test);
	}

	public void makeRequests() throws Exception {

		CloseableHttpResponse response = null;
		
		try {

			logger.info("TestID: " + test.getTestCaseID());
			logger.info("PUT Request: " + url);
			
			//Test for a body file.
			if (test.getRequests().get(test_request_counter).getBodyFile() != null) {
				File postfile = test.getRequests().get(test_request_counter).getBodyFile();
				
				String post_file_contents = FileUtils.readFileToString(postfile);
				
				post_file_contents = InterpolateRequest.Instance.interpolateString(new StringBuffer(post_file_contents)).toString();
				
				test.getRequests().get(test_request_counter).setBody(post_file_contents);
			}

			httpput = new HttpPut(url.toString().trim());
			
			entity = test.getRequests().get(test_request_counter).getBody();
			
			if (entity != null) {
				logger.info("Here is entity: \n" + IOUtils.readLines(test.getRequests().get(test_request_counter).getBody().getContent()));
				httpput.setEntity(entity);
			}
			
			setPutHeaders(test_request_counter);
			
			logger.debug("Executing put");
			test.setHttpClient();
			response = test.getHttpClient().execute(httpput);
			SplunkManager.Instance.search();

			if (test.getRequests().get(test_request_counter).getStatus() == 0) {
				Assert.assertTrue("Status: "
					+ response.getStatusLine().getStatusCode()
					+ " The request " + url + " was not successful", response
					.getStatusLine().getStatusCode() < 300);
			}
			
			else {
				Assert.assertTrue("Status: " + response.getStatusLine().getStatusCode() + " did not equal expected result of " + Integer.valueOf(test.getRequests().get(test_request_counter).getStatus()).toString(), 
				response.getStatusLine().getStatusCode() == test.getRequests().get(test_request_counter).getStatus());
			}

			logger.debug("Finished executing put");
			validateHeaders(response, test_request_counter);

			setupAndOutput(response);
			
			if (isJSONRequest(test_request_counter,response)) {
				HandleJSONRequest.Instance.handleJSON(outputfile, test);			}

		Utilities.Instance.logHeaders(response);
		} catch (AssertionError ae) {
			throw ae;
		} catch (Exception e) {
			throw e;
		}
		finally {
			if (response != null) {
				response.close();
			}
			if (test_request_counter + 1 == test.getRequests().size()) {
				test.httpClientClose();
			}
		}
	}
}