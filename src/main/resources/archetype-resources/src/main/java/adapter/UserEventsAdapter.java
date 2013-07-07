#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.adapter;

import com.jamcracker.jif.adapter.BaseUserEventsAdapter;
import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.dataobject.SuccessResponse;
import com.jamcracker.jif.exception.JIFException;
import com.jamcracker.jif.exception.ValidationException;
import com.jamcracker.jif.exception.SystemException;


public class UserEventsAdapter extends BaseUserEventsAdapter {
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}createUser(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	@Override
	public JIFResponse createUser(JIFRequest jifRequest) throws JIFException{
		//Validate your data. 
		validateData(jifRequest);
		// fetch application specific data
		
		//fetch service data. These corresponds to the service fields configured as request fields in create user event in JSDN.
		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="service">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getServiceField("cField1");
		 * 
		 * */

		String someField = jifRequest.getServiceField("someServiceField");
		//fetch company data. These corresponds to the company fields configured as request fields in create user event in JSDN.
		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="company">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getCompanyField("cField1");
		 * 
		 * */

		String companyAcr = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_ACRONYM);
		String companyName = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_NAME);

		//fetch user data. These corresponds to the user fields configured as request fields in create user event in JSDN.

		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="user">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getUserField("cField1");
		 * 
		 * */
		
		String firstName = jifRequest.getUserField(JIFConstants.FIELD_FIRSTNAME);
		String lastName = jifRequest.getUserField(JIFConstants.FIELD_LASTNAME);
		String emailId = jifRequest.getUserField(JIFConstants.FIELD_EMAIL);
		String contactPhone  = jifRequest.getUserField(JIFConstants.FIELD_CONTACT_PHONE);

		String loginName = jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME);
		String password = jifRequest.getUserField(JIFConstants.FIELD_PASSWORD);
		
		try{
			//post it to your application using your APIs
			
			//receive the response
			// If success
			SuccessResponse jifResponse = new SuccessResponse();
			return jifResponse;

		}catch(Exception e){
			//On error, set proper error code and error response
			throw new SystemException("404", "Duplicate User Found");
		}

	}


	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}updateUser(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	@Override
	public JIFResponse updateUser(JIFRequest jifRequest) throws JIFException{
		// fetch application specific data
		
		//fetch service data. These corresponds to the service fields configured as request fields in update user event in JSDN.
		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="service">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getServiceField("cField1");
		 * 
		 * */

		String someField = jifRequest.getServiceField("someServiceField");
		//fetch company data. These corresponds to the company fields configured as request fields in update user event in JSDN.
		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="company">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getCompanyField("cField1");
		 * 
		 * */

		String companyAcr = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_ACRONYM);
		String companyName = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_NAME);

		//fetch user data. These corresponds to the user fields configured as request fields in update user event in JSDN.

		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="user">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getUserField("cField1");
		 * 
		 * */
		
		String firstName = jifRequest.getUserField(JIFConstants.FIELD_FIRSTNAME);
		String lastName = jifRequest.getUserField(JIFConstants.FIELD_LASTNAME);
		String emailId = jifRequest.getUserField(JIFConstants.FIELD_EMAIL);
		String contactPhone  = jifRequest.getUserField(JIFConstants.FIELD_CONTACT_PHONE);

		String loginName = jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME);
		String password = jifRequest.getUserField(JIFConstants.FIELD_PASSWORD);
		
		try{
			//post it to your application using your APIs
			
			//receive the response
			// If success
			SuccessResponse jifResponse = new SuccessResponse();
			//If async response
			//SuccessResponse jifResponse = new WaitResponse();
			
			return jifResponse;

		}catch(Exception e){
			//On error, set proper error code and error response
			throw new SystemException("404", "User Not Found");
		}
	}
	
	

	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}deleteUser(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	@Override
	public JIFResponse deleteUser(JIFRequest jifRequest) throws JIFException{
		// fetch application specific data
		
		//fetch service data. These corresponds to the service fields configured as request fields in delete user event in JSDN.
		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="service">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getServiceField("cField1");
		 * 
		 * */

		String someField = jifRequest.getServiceField("someServiceField");
		//fetch company data. These corresponds to the company fields configured as request fields in delete user event in JSDN.
		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="company">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getCompanyField("cField1");
		 * 
		 * */

		String companyAcr = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_ACRONYM);
		String companyName = jifRequest.getCompanyField(JIFConstants.FIELD_COMPANY_NAME);

		//fetch user data. These corresponds to the user fields configured as request fields in delete user event in JSDN.

		/*
		 * this corresponds to the following in request XML 
		 * 
		 * 		<entitydata entitytype="user">
		 *			<datafield datatype="string">
		 *				<name>cField1</name>
		 * 				<value>1371</value>
		 *			</datafield>
		 *		</entitydata>
		 * 
		 *  eg. String cField1 = jifRequest.getUserField("cField1");
		 * 
		 * */
		
		String firstName = jifRequest.getUserField(JIFConstants.FIELD_FIRSTNAME);
		String lastName = jifRequest.getUserField(JIFConstants.FIELD_LASTNAME);
		String emailId = jifRequest.getUserField(JIFConstants.FIELD_EMAIL);
		String contactPhone  = jifRequest.getUserField(JIFConstants.FIELD_CONTACT_PHONE);

		String loginName = jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME);
		String password = jifRequest.getUserField(JIFConstants.FIELD_PASSWORD);
		
		try{
			//post it to your application using your APIs
			
			//receive the response
			// If success
			SuccessResponse jifResponse = new SuccessResponse();
			//If async response
			//SuccessResponse jifResponse = new WaitResponse();
			
			return jifResponse;

		}catch(Exception e){
			//On error, set proper error code and error response
			throw new SystemException("404", "User not Found");
		}
	}
	
	@Override
	public JIFResponse getSSO(JIFRequest jifRequest) {
		
		// Generate the URL for the SSO 
		String urlForSSO = createSSOURL(jifRequest);
		
		//Create a success response object
		SuccessResponse jifResponse = new SuccessResponse();

		//set the URL in response
		jifResponse.setUrlForSSO(urlForSSO);
		//send back the response
		
		return jifResponse;
	}

	private String createSSOURL(JIFRequest jifRequest) {
		//Preparing the string
		String loginName = jifRequest.getUserField(JIFConstants.FIELD_LOGINNAME);
		String password = jifRequest.getUserField(JIFConstants.FIELD_PASSWORD);
		/*
		The URL should be hashed/ encrypted and should be valid only for limited time to ensure security. This URL when pasted in the browser 
		should login the user into the application without asking username/password
		*/
		String url = "http://sso.app.com/SOMEHASHEDVALUE";//+something
		return  url;
	}

	/* 
	 * Validate the incoming data with this method. If invalid data found, throw back a ValidationException
	 * 
	 */	
	private void validateData(JIFRequest jifRequest) throws ValidationException{
		//Validate the data and if it fails, throw ValidationException
		//throw new ValidationException("23434343","Invalid data. Please correct the data")
	}
	
}
