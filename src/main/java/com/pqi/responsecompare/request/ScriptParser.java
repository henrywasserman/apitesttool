package com.pqi.responsecompare.request;

import com.pqi.responsecompare.configuration.PropertiesSingleton;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptParser {

	static final Logger logger = Logger.getLogger(Get.class);

	private Collection<File> responsecomparefiles = new ArrayList<File>();
	private boolean isBody = false;
	private boolean avoidMailCommands = false;

	public ScriptParser(Collection<File> responsecomparefiles) {
		this.responsecomparefiles = responsecomparefiles;
	}

	public ArrayList<TestCase> parse() throws Exception {

		ArrayList<TestCase> allTestCases = new ArrayList<TestCase>();
		

		int counter = Integer.valueOf(PropertiesSingleton.Instance.getProps().getProperty("repeat-testcase"));
		for (int i = 0; i < counter; i++) {

			for (File responsecomparefile : responsecomparefiles) {

				if (!PropertiesSingleton.Instance.getProperty("filelist").equals(responsecomparefile.getName())) {
					continue;
				}

				BufferedReader in = new BufferedReader(new FileReader(
						responsecomparefile));
				String line;
				int lineNum = 0;
				Pattern ptnCommand = Pattern.compile("^([a-zA-Z_]+)(.*)"); // Expects "COMMAND and then other stuff"
				Pattern ptnTestCase = Pattern.compile("^TESTCASE+\\s+(.*)\\,(.*)");// Expects "TESTCASE my_id, some description"
				Pattern ptnAPIMethods = Pattern.compile("POST|PUT|GET|DELETE|PATCH");

				ArrayList<String> allValidCommands = new ArrayList<String>(
						Arrays.asList(
								"ADD_ROLE_TO_USER_FROM_CSV", "ASSIGN","BODY","BASIC_AUTHORIZATION",
								"BODY_FILE", "COMPARE_VARIABLES", "CREATE_AUTOMATION_ROLE",
								"CREATE_PATIENT_PORTAL_USER", "CREATE_AGNOSTIC_PROPERTIES",
								"CREATE_JSON_FOR_ROLE", "CUSTOM_MAP", "CREATE_PATIENTS_FROM_CSV",
								"CREATE_USERS", "EXPECT_ERROR", "DELETE","ELSE","GENERATE_GUID",
								"GET", "GET_CONFIRMATION_TOKEN", "GET_IMAGE", "GET_IMAGES",
								"GET_WAPI_IMAGE", "GET_ADROTATION",
								// "SAMPLE_KEYWORD",
								"GETLIST_JASON", "GET_MINI","GET_WITH_AUTHCACHE","IF",
								"IGNORE_GLOBAL_HEADERS","INCREMENT_PATIENT_NUMBER","LOG","OPEN_BUG",
								"POST_IMAGE", "POST_IMAGES", "POST","RUN_ORACLE_SQL","RUN_SQL_FROM_FILE",
								"RUN_SQLSERVER_SQL","POST_MULTIPART","POST_WITH_AUTHCACHE","REMOTE_SHELL",
								"RELOAD_ENVIRONMENT_AGNOSTIC_PROPERTIES","JAVASCRIPT",
								"POST_WITH_FILE_BODY","POST_XML_SUBS", "PUT", "SET_DATETIME",
								"VALIDATE_HEADER","SKIP_COMPARE","TESTRAIL", "VALIDATE_HEADER_SET",
								"VALIDATE_HEADER_NOTEXIST", "VALIDATE_IMAGE", "VALIDATE_IMAGES",
								"TRANSFORM_RESPONSE_FILE","VALIDATE_RAW_RESPONSE",
								"VALIDATE_STATUS_CODE", "SET_HEADER","COMPARE", "STATUS",
								"VALIDATE_DATA", "VERIFY_ICD","VERIFY_RESPONSE_TEXT",
								"VERIFY_MAP_VALUE","WAIT_FOR_DATA"));

				Matcher match = null;

				TestCase currentTestCase = null;

				boolean append = false;
				while ((line = in.readLine()) != null) {
					//logger.debug(line);
					line = line.trim();
					lineNum++;
					match = ptnAPIMethods.matcher(line);
					if (avoidMailCommands && !match.find()) {
						continue;
					} else {
						avoidMailCommands = false;
					}

					if (currentTestCase == null) {
						append = false;
					} else if (currentTestCase.getIsAssign() )
					{
						append = true;
					} else if (currentTestCase.getIsJSONAssign()) {
						append = true;
					} else {
						append = false;
					}
					
					if (line.startsWith("#") || line.equals(""))
					{
						continue; // Skip comments and blanks
					}

					if (PropertiesSingleton.Instance.getProperty("user.hasmail").equals("false") && line.contains("mailboxes")) {
						avoidMailCommands=true;
						continue;
					}

					match = ptnCommand.matcher(line);
					if (match.find() && !append) {
						if (match.group(1).equals("TESTCASE")) { // We found a new TESTCASE line
							if (currentTestCase != null) {
								currentTestCase.setIsBody(false);
								currentTestCase.setIsAssign(false);
								currentTestCase.setIsJSONAssign(false);

								append = false;
							}
							match = ptnTestCase.matcher(line);
							if (match.find()) {
								currentTestCase = new TestCase();
								currentTestCase
										.setRequestFile(responsecomparefile
												.toString());
								currentTestCase.setLineNum(lineNum);
								currentTestCase.setTestCaseID(StringUtils.replace(match.group(1)
										.trim(),"/","_"));
								currentTestCase.setTestCaseDescription(match
										.group(2).trim());
								allTestCases.add(currentTestCase);
							} else {
								throwParseError(lineNum, line,
										"Incorrect TESTCASE line");
							}
						} else {
							if (allValidCommands.contains(match.group(1))) {
								// Found supported commands so add them to the
								// testcase object
								if (currentTestCase != null) {
									currentTestCase.setIsBody(false);
									currentTestCase.setIsAssign(false);
									currentTestCase.setIsJSONAssign(false);

									append = false;
									avoidMailCommands=false;
								}
								currentTestCase.addCommand(match.group(1)
										.trim(), match.group(2).trim());
							} else {

								throwParseError(lineNum, line,
										"Invalid command: " + line + " Supported commands are: "
												+ allValidCommands.toString());
							}
						}
					} else {
						if (currentTestCase != null) {
							currentTestCase.addCommand("",line);
							continue;
						} else {
						throwParseError(lineNum, line,
								"Could not match a command: " + line + " on line using regex pattern: "
										+ ptnCommand.pattern());
						}
					}
				}
				in.close();
			}
		}
		return allTestCases;
	}

	private void throwParseError(int lineNum, String line, String message)
			throws Exception {
		throw new Exception("Parse error on line " + lineNum + ": \"" + line
				+ "\" -- message is: " + message);
	}

}