#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package com.jamcracker.jif.sample.sugarcrm.adapter;

import com.jamcracker.jif.adapter.BaseCompanyEventsAdapter;
import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.sample.sugarcrm.dataobject.SugarAccount;
import com.jamcracker.jif.sample.sugarcrm.util.SugarCRMConnector;

/**
 * @author ppnair
 *
 */
public class CompanyEventsAdapter extends BaseCompanyEventsAdapter {
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}createCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse createCompany(JIFRequest jifRequest) {
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

		String website=jifRequest.getCompanyField("URL");
		String billingAddress = jifRequest.getCompanyField("address1")+ jifRequest.getCompanyField("address2") + jifRequest.getCompanyField("address3");		
		String billingState= jifRequest.getCompanyField("state");
		String billingAddressPostalcode = jifRequest.getCompanyField("zip");
     	String billingAddressCountry =  jifRequest.getCompanyField("country");
     	String description =  jifRequest.getCompanyField("companyDescription");
		
		//post it to your application using your APIs
		SugarAccount sugarAccount=new SugarAccount();
		sugarAccount.setAccountName(companyAcr);
		sugarAccount.setWebsite(website != null?website:"");
		sugarAccount.setBillingAddress(billingAddress);
        sugarAccount.setBillingAddressState(billingState==null?"":billingState);
     	sugarAccount.setBillingAddressCountry(billingAddressCountry==null?"":billingAddressCountry);
     	sugarAccount.setDescription(description==null?"":description);
     	sugarAccount.setBillingAddressPostalCode(billingAddressPostalcode);
		SugarCRMConnector connector =new SugarCRMConnector();
		String recordID;
		JIFResponse jifResponse = null;
		try {
			//receive the response
			recordID = connector.createSugarAccount(sugarloginUrl, sugarUsername, sugarPassword, sugarAccount);
			// success
			jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");
			//update recordId back to JSDN
			jifResponse.setCompanyField("sugarrecordID", recordID);
		} catch (Exception e) {
			//Failure
			jifResponse = new JIFResponse("1",e.getMessage());
		}
		
		return jifResponse;
	}

	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}updateCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse updateCompany(JIFRequest jifRequest) {
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

		String website=jifRequest.getCompanyField("URL");
		String billingAddress = jifRequest.getCompanyField("address1")+ jifRequest.getCompanyField("address2") + jifRequest.getCompanyField("address3");		
		String billingState= jifRequest.getCompanyField("state");
		String billingAddressPostalcode = jifRequest.getCompanyField("zip");
     	String billingAddressCountry =  jifRequest.getCompanyField("country");
     	String description =  jifRequest.getCompanyField("companyDescription");
		
		//post it to your application using your APIs
		SugarAccount sugarAccount=new SugarAccount();
		sugarAccount.setAccountName(companyAcr);
		sugarAccount.setWebsite(website != null?website:"");
		sugarAccount.setBillingAddress(billingAddress);
        sugarAccount.setBillingAddressState(billingState==null?"":billingState);
     	sugarAccount.setBillingAddressCountry(billingAddressCountry==null?"":billingAddressCountry);
     	sugarAccount.setDescription(description==null?"":description);
     	sugarAccount.setBillingAddressPostalCode(billingAddressPostalcode);
     	sugarAccount.setRecordID(jifRequest.getCompanyField("sugarrecordID"));
		
		//post it to your application using your APIs
		
		//receive the response
		SugarCRMConnector connector =new SugarCRMConnector();

		JIFResponse jifResponse = null;
		try {
			connector.updateAccount(sugarloginUrl, sugarUsername, sugarPassword, sugarAccount);
			// success
			jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");

		} catch (Exception e) {
			//Failure
			jifResponse = new JIFResponse("1",e.getMessage());
		}

		//send back the response
		
		return jifResponse;
		
	}


	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}deleteCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse deleteCompany(JIFRequest jifRequest) {
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
		String recordID = jifRequest.getCompanyField("sugarrecordID");
		//post it to your application using your APIs
		
		//receive the response
		SugarCRMConnector connector =new SugarCRMConnector();
		JIFResponse jifResponse = null;
		try {
			connector.deleteAccount(sugarloginUrl, sugarUsername, sugarPassword, recordID);
			// success
			jifResponse = new JIFResponse(JIFConstants.SUCCESS_CODE,"SUCCESS");

		} catch (Exception e) {
			//Failure
			jifResponse = new JIFResponse("1",e.getMessage());

		}
		return jifResponse;
	}


}
