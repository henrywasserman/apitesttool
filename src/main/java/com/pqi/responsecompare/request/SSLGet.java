package com.pqi.responsecompare.request;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;

import org.junit.Assert;

import com.pqi.responsecompare.configuration.Utilities;
import com.pqi.responsecompare.json.HandleJSONRequest;
import com.pqi.responsecompare.json.JSONToMap;
import com.pqi.responsecompare.splunk.SplunkManager;


public class SSLGet extends Request {
	static Logger logger = Logger.getLogger(SSLGet.class);

	public SSLGet(TestCase test) throws Exception {
		super(test);
	}

	public void makeRequests() throws Exception {
		CloseableHttpResponse response = null;
		
		post = new StringBuffer(builddir.toString());
		post.append(file);		

		try {

			logger.info("TestID: " + test.getTestCaseID());
			logger.info("GET Request: " + url);
			
			httpget = new HttpGet(url.toString().trim());
	
			setGetHeaders(test_request_counter);
			
			logger.debug("Executing get");
			test.setHttpClient();
			response = test.getHttpClient().execute(httpget);
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

			logger.debug("Finished executing get");
			validateHeaders(response, test_request_counter);

			setupAndOutput(response);

			if (isJSONRequest(test_request_counter,response)) {
				//HandleJSONRequest.Instance.handleJSON(outputfile);
				HandleJSONRequest.Instance.handleJSON(outputfile, test);
				Map<String, String> vairableMap = test.getRequests().get(test_request_counter).getVariableHash();
				String key = "";
				String value = "";
				for (Map.Entry<String,String> entry: vairableMap.entrySet()) {
					key = entry.getKey();
					value = entry.getValue().replace("${","").replace("}","");
					JSONToMap.Instance.getMap().get(value);
				}
			}

		Utilities.Instance.logHeaders(response); 
		
		} catch (AssertionError ae) {
			ae.printStackTrace();
			throw ae;
		} catch (Exception e) {
			e.printStackTrace();
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