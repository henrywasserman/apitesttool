package com.pqi.responsecompare.request;

import java.io.ByteArrayOutputStream;
import java.io.File;

import nu.xom.Builder;
import nu.xom.Serializer;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;

import com.pqi.responsecompare.configuration.Utilities;
import com.pqi.responsecompare.json.HandleJSONRequest;
import com.pqi.responsecompare.json.JSONToMap;
import com.pqi.responsecompare.splunk.SplunkManager;

public class SSLPostWithFileBody extends Request {
	static Logger logger = Logger.getLogger(SSLPostWithFileBody.class);

	public SSLPostWithFileBody(TestCase test) throws Exception {
		super(test);
	}

	public void makeRequests() throws Exception {

		CloseableHttpResponse response = null;
		
		post = new StringBuffer(builddir.toString());
		post.append(file);
		
		try {
			logger.info("TestID: " + test.getTestCaseID());
			logger.info("POST Request: " + url);
			
			File postfile = test.getRequests().get(test_request_counter).getBodyFile();
			
			String post_file_contents = FileUtils.readFileToString(postfile);
			
			post_file_contents = InterpolateRequest.Instance.interpolateString(new StringBuffer(post_file_contents)).toString();
			
			test.getRequests().get(test_request_counter).setBody(post_file_contents);

			httppost = new HttpPost(url.toString().trim());
			
			entity = test.getRequests().get(test_request_counter).getBody();

			if (entity != null) {
				httppost.setEntity(entity);
			}
		
			setPostHeaders(test_request_counter);
			
			logger.debug("Executing post");
			test.setHttpClient();
			response = test.getHttpClient().execute(httppost);
			SplunkManager.Instance.search();
			Assert.assertTrue("Status: "
					+ response.getStatusLine().getStatusCode()
					+ " The request " + url + " was not successful", response
					.getStatusLine().getStatusCode() < 300);
			
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

			logger.debug("Finished executing post");
			validateHeaders(response, test_request_counter);

			setupAndOutput(response);

			if (isJSONRequest(test_request_counter,response)) {
				HandleJSONRequest.Instance.handleJSON(outputfile, test);
			}

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