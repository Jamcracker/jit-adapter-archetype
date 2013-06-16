#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.adapter;

import com.jamcracker.jif.adapter.BaseCompanyEventsAdapter;
import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.dataobject.SuccessResponse;
import com.jamcracker.jif.dataobject.WaitResponse;
import com.jamcracker.jif.exception.JIFException;

/**
 * @author ppnair
 *
 */
public class CompanyEventsAdapter extends BaseCompanyEventsAdapter {
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}createCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse createCompany(JIFRequest jifRequest) throws JIFException {
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
		try{
			//post it to your application using your APIs
			
			//receive the response
			// If success
			SuccessResponse jifResponse = new SuccessResponse();
			
			//If async response
			//SuccessResponse jifResponse = new WaitResponse();
			//If you want to update some value back to JSDN
			jifResponse.setCompanyField("UID", "test");
			return jifResponse;

		}catch(Exception e){
			//On error, set proper error code and error response
			throw new JIFException("404", "Duplicate Account Found");
		}

	}
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}updateCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse updateCompany(JIFRequest jifRequest) throws JIFException{
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
		
		try{
			//post it to your application using your APIs
			
			//receive the response
			// If success
			SuccessResponse jifResponse = new SuccessResponse();
			//If async response
			//SuccessResponse jifResponse = new WaitResponse();

			//If you want to update some value back to JSDN
			jifResponse.setCompanyField("UID", "test");
			return jifResponse;

		}catch(Exception e){
			//On error, set proper error code and error response
			throw new JIFException("404", "Account not able to update");
		}
	}

	
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}deleteCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse deleteCompany(JIFRequest jifRequest) throws JIFException{
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
		
		try{
			//post it to your application using your APIs
			
			//receive the response
			// If success
			SuccessResponse jifResponse = new SuccessResponse();
			//If async response
			//SuccessResponse jifResponse = new WaitResponse();

			//If you want to update some value back to JSDN
			jifResponse.setCompanyField("UID", "test");
			return jifResponse;

		}catch(Exception e){
			//On error, set proper error code and error response
			throw new JIFException("404", "Account Not Found");
		}

	}

}
