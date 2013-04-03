#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.sugarcrm.adapter;

import ${package}.adapter.BaseUserEventsAdapter;
import ${package}.common.JIFConstants;
import ${package}.dataobject.JIFRequest;
import ${package}.dataobject.JIFResponse;
import ${package}.sample.sugarcrm.dataobject.SugarUser;
import ${package}.sample.sugarcrm.util.SugarCRMConnector;

public class UserEventsAdapter extends BaseUserEventsAdapter {
	/* (non-Javadoc)
	 * @see ${package}.adapter.IJIFAdapter${symbol_pound}createUser(${package}.dataobject.JIFRequest)
	 */
	public JIFResponse createUser(JIFRequest jifRequest) {
		
		/* fetch service data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="service">
		 *			<datafield datatype="string">
		 *				<name>sField1</name>
		 * 				<value>2201371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String sField1 = jifRequest.getServiceField("sField1");
		 * 
		 * */
		String sugarloginUrl =  jifRequest.getServiceField("sugarcrmurl");
	    String sugarUsername =   jifRequest.getServiceField("sugarcrmUsername");
	    String sugarPassword = jifRequest.getServiceField("sugarcrmPassword");
		
		//fetch company mandatory data. These will be there in every company request.
		String companyAcr = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_ACRONYM);
		String companyName = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_NAME);
		
		/* fetch application specific data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="company">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getServiceField("cField1");
		 * 
		 * */
		SugarUser su=new SugarUser();
		su.setLoginName(jifRequest.getUserField("loginName"));
		su.setFirstName(jifRequest.getUserField("firstName"));
		su.setLastName(jifRequest.getUserField("lastName"));
		su.setPassword(jifRequest.getUserField("password"));
		su.setTitle(jifRequest.getUserField("userTitle"));
		su.setDeptName(jifRequest.getUserField("departmentName"));
		su.setPhoneWork(jifRequest.getUserField("contactPhone"));
		su.setMobile(jifRequest.getUserField("contactMobile"));
		su.setFax(jifRequest.getUserField("contactFax"));
		su.setEmail(jifRequest.getUserField("email"));
		su.setOtherEmail(jifRequest.getUserField("alternateEmail"));
		su.setRecordID(jifRequest.getUserField("sugaruserrecordID"));
		String primaryAddress=jifRequest.getUserField("address1") + jifRequest.getUserField("address2") + jifRequest.getUserField("address3");		
		su.setPrimaryAddress(primaryAddress);
		su.setPrimaryAddressCity(jifRequest.getUserField("city"));
		su.setPrimaryAddressState(jifRequest.getUserField("state"));
		su.setPrimaryAddressCountry(jifRequest.getUserField("country"));
		su.setPrimaryAddressPostalcode(jifRequest.getUserField("zip"));

		//post it to your application using your APIs
		
		//receive the response
		SugarCRMConnector connector =new SugarCRMConnector();
		JIFResponse jifResponse = null;
		try {
			String recordID=connector.createUser(sugarloginUrl, sugarUsername, sugarPassword, su);
			// success
			jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");
			//update user recordid back to JSDN
			
			jifResponse.setUserField("sugaruserrecordID", recordID);

		} catch (Exception e) {
			//Failure
			jifResponse = new JIFResponse("1",e.getMessage());
		}

		//send back the response
		
		return jifResponse;
	}


	/* (non-Javadoc)
	 * @see ${package}.adapter.IJIFAdapter${symbol_pound}updateUser(${package}.dataobject.JIFRequest)
	 */
	public JIFResponse updateUser(JIFRequest jifRequest) {
		/* fetch service data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="service">
		 *			<datafield datatype="string">
		 *				<name>sField1</name>
		 * 				<value>2201371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String sField1 = jifRequest.getServiceField("sField1");
		 * 
		 * */
		String sugarloginUrl =  jifRequest.getServiceField("sugarcrmurl");
	    String sugarUsername =   jifRequest.getServiceField("sugarcrmUsername");
	    String sugarPassword = jifRequest.getServiceField("sugarcrmPassword");
		
		//fetch company mandatory data. These will be there in every company request.
		String companyAcr = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_ACRONYM);
		String companyName = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_NAME);
		
		/* fetch application specific data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="company">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getServiceField("cField1");
		 * 
		 * */
		SugarUser su=new SugarUser();
		su.setLoginName(jifRequest.getUserField("loginName"));
		su.setFirstName(jifRequest.getUserField("firstName"));
		su.setLastName(jifRequest.getUserField("lastName"));
		su.setPassword(jifRequest.getUserField("password"));
		su.setTitle(jifRequest.getUserField("userTitle"));
		su.setDeptName(jifRequest.getUserField("departmentName"));
		su.setPhoneWork(jifRequest.getUserField("contactPhone"));
		su.setMobile(jifRequest.getUserField("contactMobile"));
		su.setFax(jifRequest.getUserField("contactFax"));
		su.setEmail(jifRequest.getUserField("email"));
		su.setOtherEmail(jifRequest.getUserField("alternateEmail"));
		su.setRecordID(jifRequest.getUserField("sugaruserrecordID"));
		String primaryAddress=jifRequest.getUserField("address1") + jifRequest.getUserField("address2") + jifRequest.getUserField("address3");		
		su.setPrimaryAddress(primaryAddress);
		su.setPrimaryAddressCity(jifRequest.getUserField("city"));
		su.setPrimaryAddressState(jifRequest.getUserField("state"));
		su.setPrimaryAddressCountry(jifRequest.getUserField("country"));
		su.setPrimaryAddressPostalcode(jifRequest.getUserField("zip"));
		su.setRecordID(jifRequest.getUserField("sugaruserrecordID"));

		//post it to your application using your APIs
		
		//receive the response
		SugarCRMConnector connector =new SugarCRMConnector();
		JIFResponse jifResponse = null;
		try {
			connector.updateUser(sugarloginUrl, sugarUsername, sugarPassword, su);			// success
			jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");

		} catch (Exception e) {
			//Failure
			jifResponse = new JIFResponse("1",e.getMessage());
		}

		//send back the response
		
		return jifResponse;
	}
	
	
	

	/* (non-Javadoc)
	 * @see ${package}.adapter.IJIFAdapter${symbol_pound}deleteUser(${package}.dataobject.JIFRequest)
	 */
	public JIFResponse deleteUser(JIFRequest jifRequest) {
		/* fetch service data. 
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="service">
		 *			<datafield datatype="string">
		 *				<name>sField1</name>
		 * 				<value>2201371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String sField1 = jifRequest.getServiceField("sField1");
		 * 
		 * */
		String sugarloginUrl =  jifRequest.getServiceField("sugarcrmurl");
	    String sugarUsername =   jifRequest.getServiceField("sugarcrmUsername");
	    String sugarPassword = jifRequest.getServiceField("sugarcrmPassword");
		
		//fetch company mandatory data. These will be there in every company/ user request. 
		String companyAcr = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_ACRONYM);
		String companyName = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_NAME);
		
		/* fetch application specific company data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="company">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getServiceField("cField1");
		 * 
		 * */

		//fetch user mandatory data. These will be there in every user request.
		String firstName = jifRequest.getUserField(JIFConstants.FIELD_FIRSTNAME);
		String lastName = jifRequest.getUserField(JIFConstants.FIELD_LASTNAME);
		String emailId = jifRequest.getUserField(JIFConstants.FIELD_EMAIL);
		String contactPhone  = jifRequest.getUserField(JIFConstants.FIELD_CONTACT_PHONE);

		String loginName = jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME);
		String password = jifRequest.getUserField(JIFConstants.FIELD_PASSWORD);
		//set the above password generated by Jamcracker to the user in your application
		
		/* fetch application specific user data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="user">
		 *			<datafield datatype="string">
		 *				<name>uField1</name>
		 * 				<value>371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String uField1 = jifRequest.getServiceField("uField1");
		 * 
		 * */
		String recordID = jifRequest.getUserField("sugaruserrecordID");
		//post it to your application using your APIs
		
		//receive the response
		SugarCRMConnector connector =new SugarCRMConnector();
		JIFResponse jifResponse = null;
		try {
			connector.deleteUser(sugarloginUrl, sugarUsername, sugarPassword, recordID);
			// success
			jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");

		} catch (Exception e) {
			//Failure
			jifResponse = new JIFResponse("1",e.getMessage());
		}

		//send back the response
		
		return jifResponse;
	}

	public JIFResponse getHTMLForSSO(JIFRequest jifRequest) {
		//fetch user mandatory data. These will be there in every user request.
		String loginName = jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME);
		String password = jifRequest.getUserField(JIFConstants.FIELD_PASSWORD);
		//set the above password generated by Jamcracker to the user in your application
		
		/* fetch application specific user data
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="user">
		 *			<datafield datatype="string">
		 *				<name>uField1</name>
		 * 				<value>371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String uField1 = jifRequest.getServiceField("uField1");
		 * 
		 * */
		
		// Generate the HTML for the SSO 
		String htmlForSSO = createSSOHTML(jifRequest);
		
		//Create a success response object
		JIFResponse jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");

		//set the HTML content in response
		jifResponse.setHtmlForSSO(htmlForSSO);
		//send back the response
		
		return jifResponse;
	}

	private String createSSOHTML(JIFRequest jifRequest) {
		//Preparing the string

		StringBuffer sb = new StringBuffer("");
		sb.append("<html>");
		sb.append("<head>");
		sb.append(" <meta HTTP-EQUIV=${symbol_escape}"Content-Type${symbol_escape}" CONTENT=${symbol_escape}"text/html; charset=ISO-8859-1${symbol_escape}">");
		sb.append(" <script language='JavaScript'>");
		sb.append("   function submitSSOForm(){");
		sb.append("     document.ssoform.submit();");
		sb.append("   }");
		sb.append(" </script>");
		sb.append(" <title>SSO :- </title>");
		sb.append("</head>");
		sb.append("<body onLoad='submitSSOForm();return true;'>");
		sb.append(" <form method=${symbol_escape}"post${symbol_escape}" name=${symbol_escape}"ssoform${symbol_escape}" action=${symbol_escape}"http://192.168.9.141/sugarcrm/index.php${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"user_name${symbol_escape}" value=${symbol_escape}"" + jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME) + "${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"user_password${symbol_escape}" value=${symbol_escape}"" + jifRequest.getUserField(JIFConstants.FIELD_PASSWORD) + "${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"login_language${symbol_escape}" value=${symbol_escape}"en_us${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"action${symbol_escape}" value=${symbol_escape}"Authenticate${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"return_action${symbol_escape}" value=${symbol_escape}"Login${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"login_theme${symbol_escape}" value=${symbol_escape}"Sugar${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"return_module${symbol_escape}" value=${symbol_escape}"Users${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"Login${symbol_escape}" value=${symbol_escape}"Login${symbol_escape}">");
		sb.append("   <input type=${symbol_escape}"hidden${symbol_escape}" name=${symbol_escape}"module${symbol_escape}" value=${symbol_escape}"Users${symbol_escape}">");
		sb.append(" </form>");
		sb.append("</body>");
		sb.append("</html>");
		return  sb.toString();

	}

}
