package com.pqi.responsecompare.request;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.pqi.responsecompare.configuration.SqlServerDbManager;
import com.pqi.responsecompare.configuration.Utilities;

public class GetWithSqlTraceTables extends Request {
	Properties props = Utilities.Instance.getTestProperties();

	String creativeIds = new String();
	protected String consult_url = Utilities.Instance.getEndPoint("consult");
	protected String lpa_url = Utilities.Instance.getEndPoint("lpa");
	
	public GetWithSqlTraceTables(TestCase test)  throws Exception {
		super(test);
	}

	@Override
	public void makeRequests() throws Exception  {
		SqlServerDbManager dbManager = null;
		java.sql.Timestamp ts = null; 
		try{
		  dbManager = new SqlServerDbManager(props);
	 	 // record the start time
		 ts = dbManager.getDatabaseTimeStamp();
	     }catch(Exception ex){
	    	 logger.error("Could not obtain database connection ", ex);
		     Assert.fail("Could not obtain database connection "+ ex.getMessage()); 
          }
		// LPA request
		// populate url1 instance var
		// save the string out of the url1
		String lpaUrl = this.buildLpaURL();
		// process the lpa request from the url1 string
		test.getRequests().get(0).setURL(lpaUrl);
		HttpResponse response = this.processUrl1Request();
		List<String> creativeIdList = this.getCreativeIdsFromResponse(response);

		this.buildNmgUrlOutOfLpaUrl(lpaUrl);
		
		response = this.processUrl1Request();
    
		List<String> dataValidators = test.getDataValidators();
		
	    Assert.assertTrue("Data validators cannot be null",dataValidators!=null);
		Assert.assertTrue("Number of SqlStrings and Validators not equal", dataValidators.size()==test.getSqlStrings().size());
		
		this.executeAndValidateEachSql(creativeIdList, ts, dbManager);
		dbManager.closeConnection();
	}

	/**
	 * Gets a list of creativeIds out of the response object
	 * 
	 * @param response
	 * @return
	 */
	List<String> getCreativeIdsFromResponse(HttpResponse response) {
		return Utilities.Instance.getAllNodeValuesFromResponse("creativeid", response);
	}

	protected String replaceCreativeIds(List<String> ids, String source) {
		int k = 0;
		for (String id : ids) {
			k++;
			source = source.replace("${creativeid" + k + "}", id);
		}

		return source;
	}

	protected String buildLpaURL() {
		url = url + "http://" + test.getRequests().get(0).getURL().trim();
		logger.info("TestID: " + test.getTestCaseID());
		logger.info("LPA Request: " + url.toString());
		return url.toString();
	}

	protected String buildNmgUrlOutOfLpaUrl(String lpaRequestUrl) {
		String nmgRequestUrl = consult_url
				+ lpaRequestUrl.substring(lpaRequestUrl.indexOf("?"));
		// reset the url1
		url = nmgRequestUrl;
		test.getRequests().get(0).setURL(url.toString());
		logger.info("NMG request: " + url);
		return nmgRequestUrl;
	}

	protected HttpResponse processUrl1Request() throws ClientProtocolException,
			IOException, Exception {
		HttpClient httpclient = HttpClientBuilder.create().build();
		test.getRequests().get(0).setURL(url.toString());
		httpget = new HttpGet(url.toString().trim());
		setGetHeaders(0);
		HttpResponse response = null;
		
		try {
		 response = httpclient.execute(httpget);
		}catch(Exception ex){
			Assert.fail("Could not execute an http reguest "+ex.getMessage());
			logger.error(ex);
			
		}
		validateHeaders(response, 0);
		Utilities.Instance.logHeaders(httpget);
		Utilities.Instance.logHeaders(response);
		return response;
	}

	protected void executeAndValidateEachSql (List<String> creativeIdList,
			java.sql.Timestamp ts, SqlServerDbManager dbManager) throws SQLException, Exception {

		for (int i = 0; i < test.getSqlStrings().size(); i++) {

			String sql = test.getSqlStrings().get(i);
			// replace tags with the values
			String replaced = this.replaceCreativeIds(creativeIdList, sql);

			// the validation need to be in the req file for each sql statement
			String validation_data = test.getDataValidators().get(i);
            Assert.assertFalse("Not enough creativeIds to substitute in: " + replaced, replaced.contains("${creativeid")); 
			String dbName = props.getProperty("mssql-dbname");
			replaced = replaced.replace("${db_start_time}", ts.toString());
			replaced = replaced.replace("${lpa_db_name}", dbName);
			
			ResultSet resultSet = null; 
			
			logger.info("sql" + i + " " + replaced);
            
			// execute up to 10 times until data appears  in the database 
			boolean reached =false;
			Integer res = -9999;
			
			for (int k = 0; k < 10; k++) {
				resultSet = dbManager.executeQuery(replaced);
				// loop until the validation is true or it ran 10 times
				while (resultSet.next()) {
						res = resultSet.getInt(1);
						reached= true;
				}
           
				//we had gotten some result, no need to execute 10 times.
				if (reached)break;

			}

			Assert.assertEquals( "Data validator did not match query result for: " + replaced , validation_data.trim(),
						res.toString().trim());
				
			Assert.assertFalse("Could not retrieve any result using sql:"+ replaced, res==-9999);	
			
		}

	}
	
}