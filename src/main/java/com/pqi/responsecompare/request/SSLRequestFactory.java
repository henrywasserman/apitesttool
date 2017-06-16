package com.pqi.responsecompare.request;

public enum SSLRequestFactory {

	Instance;
	
	private Request req = null;


	public Request getRequest(TestCase test) throws Exception {
		String type = getRequestType(test).toLowerCase();
		
		if (type.toLowerCase().equals("body")) {
		} else if (type.equals("add_role_to_user_from_csv")) {
			req = new AddRoleToUserFromCSV(test);
		} else if (type.equals("create_patient_portal_user")) {
			req = new CreatePatientPortalUser(test);
		} else if (type.equals("create_patients_from_csv")) {
			req = new CreatePatientsFromCSV(test);
		} else if (type.equals("create_users")) {
			req = new CreateUsers(test);
		} else if (type.equals("get")) {
			req = new SSLGet(test);
		} else if (type.equals("delete")) {
			req = new SSLDelete(test);
		} else if (type.equals("post")) {
			req = new SSLPost(test);
		} else if (type.equals("post_multipart")) {
			req = new SSLPostMultiPart(test);
		} else if (type.equals("post_with_file_body")) {
			req = new SSLPostWithFileBody(test);
		} else if (type.equals("put")) {
			req = new SSLPut(test);
//		} else if (type.toLowerCase().equals("sample_keyword")) {
//			req = new SampleKeywordClassfile(test);
		} else if (type.equals("expect_error")) {
			req = new ExpectError(test);
		} else if (type.equals("getlist_jason")) {
			req = new GetListJason(test);			
		} else if (type.equals("get_image")) {
			req = new GetImage(test);
		} else if (type.equals("post_image")) {
			req = new PostImage(test);
		} else if (type.equals("get_images")) {
			req = new GetImages(test);
		} else if (type.equals("post_images")) {
			req = new PostImages(test);
		} else if (type.equals("get_wapi_image")) {
			req = new GetWapiImage(test);
		} else if (type.equals("get_with_authcache")) {
			req = new GetWithAuthCache(test);
		} else if (type.equals("get_confirmation_token")) {
			req = new GetConfirmationToken(test);
		}	

		return req;
	}

	private String getRequestType(TestCase testcase) {
		String requesttype = "";
		try {
			requesttype = testcase.getRequests().get(testcase.getTestRequestCounter()).getRequestType()
					.toLowerCase();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return requesttype;
	}
}