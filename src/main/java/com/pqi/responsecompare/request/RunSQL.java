package com.pqi.responsecompare.request;

import com.pqi.responsecompare.configuration.OracleDbManager;
import com.pqi.responsecompare.configuration.PropertiesSingleton;
import com.pqi.responsecompare.configuration.SSHTunnel;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.Formatter;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RunSQL extends Request {
	static final Logger logger = Logger.getLogger(RunSQL.class);
	private ResultSet rs = null;
	private String query = "";
	private OracleDbManager db = null;
	private final File sqlFarmTable = new File ("reports/sql_farm_table.html");
	private String description = "";
	private List<String> la = null;
	private final Formatter formatter = new BasicFormatterImpl();
	private boolean foundQueryEnd = true;

	public RunSQL(TestCase test) throws Exception {
		super(test);
	}

	public void makeRequests() throws Exception {
		File sqlFile = new File(test.getRequests().get(test_request_counter).getURL());
		boolean req_result = false;
		String fs = File.separator;
		logger.info("TestID: " + test.getTestCaseID());

		try {
			logger.debug("Getting db Oracle Manager");
			SSHTunnel.Instance.openTunnel();
			db = new OracleDbManager(PropertiesSingleton.Instance.getProps());

			startCreateHTML();

			description = "Run SQL Farm";
			logger.debug(description);

			la = FileUtils.readLines(sqlFile);
			req_result = runQuery();
			if (req_result)
			{
				// Have not decided what to do yet.
			}
			logger.debug("Calling rs.close");
			rs.close();
			logger.debug("Calling db.closeStatement");
			db.CloseStatement();
			logger.debug("Finished calling db.closeStatement");


		} catch (Exception e) {
			throw e;

		} finally {
			db.CloseStatement();
			db.closeConnection();
			SSHTunnel.Instance.closeTunnel();
		}
	}

	private boolean runQuery() throws Exception
	{
		for (String line : la)
		{
			try
			{
				if (line.trim().startsWith("--"))
				{
					if(foundQueryEnd)
					{
						description = line.split("--")[1].trim();
						foundQueryEnd = false;
					}
					continue;
				}

				if (line.contains("--")) {
					line = line.split("--")[0].trim();
				}
				query = query + " " + line;
				if (query.contains(";"))
				{
					query = query.replaceAll(";", "");
					logger.debug(query);
					rs = db.executeQuery(query);
					addHTML(query);
					foundQueryEnd = true;
					query = "";
					result = rs.next();
				}

			}
			catch (SQLException e)
			{
				if (e.getMessage().contains("fetch out of sequence"))
				{
					logger.debug("This query returned 0 records: " + query);
				}
				else
				{
					throw e;
				}
			}
			catch (Exception e)
			{
				logger.debug("Inside runQuery Exception");
				logger.debug(e.toString());
			}
		}
		endCreateHTML();
		return result;
	}

	private void startCreateHTML() throws Exception {
		FileUtils.writeStringToFile(sqlFarmTable,
			"<html>\n"+
				"  <title></title>\n" +
				"  <body>\n" +
				"    <style>\n" +
				"      table,th,td\n" +
				"      {\n" +
				"        border:1px solid black;\n" +
				"        border-collapse:collapse;\n" +
				"        text-align:left;\n" +
				"        vertical-align: text-top;\n" +
				"        margin: 20px;\n" +
				"        padding: 5px;\n" +
				"      }\n" +
				"      th\n" +
				"    {\n" +
				"      background-color: #f1f1f1;\n" +
				"    }\n" +
				"    </style>\n");
	}

	private void addHTML(String query) throws Exception {
		FileUtils.writeStringToFile(sqlFarmTable,
			"    <table style=\"width:1000px\">\n"
				+"     <tr>\n"
				+ "      <th>Description</th>\n"
				+ "      <th>SQL</th>\n"
				+ "    </tr>\n"
				+ "    <tr>\n"
				+ "      <td>" + description + "</td>\n"
				+ "      <td><pre>"
				+ formatter.format(query)
				+ "</pre></td>\n"
				+ "      </tr>\n"
				+ "    </table>\n"
			,true);
	}

	private void endCreateHTML() throws Exception {
		FileUtils.writeStringToFile(sqlFarmTable,
			"  </body>\n" +
				"</html>",true);
	}
}