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
import com.jamcracker.jif.exception.ValidationException;
import com.jamcracker.jif.exception.SystemException;

/**
 * @author ppnair
 *
 */
public class CompanyEventsAdapter extends BaseCompanyEventsAdapter {
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}createCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse createCompany(JIFRequest jifRequest) throws JIFException {
		//Validate your data. 
		validateData(jifRequest);
		// fetch application specific data
		
		//fetch service data. These corresponds to the service fields configured as request fields in create company event in JSDN.
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
		//fetch company data. These corresponds to the company fields configured as request fields in create company event in JSDN.
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
			throw new SystemException("404", "Cannot create Account");
		}

	}
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}updateCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse updateCompany(JIFRequest jifRequest) throws JIFException{
		// fetch application specific data
		
		//fetch service data. These corresponds to the service fields configured as request fields in update company event in JSDN.
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
		//fetch company data. These corresponds to the company fields configured as request fields in update company event in JSDN.
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
			throw new SystemException("404", "Account not able to update");
		}
	}

	
	
	/* (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter${symbol_pound}deleteCompany(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse deleteCompany(JIFRequest jifRequest) throws JIFException{
		// fetch application specific data
		
		//fetch service data. These corresponds to the service fields configured as request fields in delete company event in JSDN.
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
		//fetch company data. These corresponds to the company fields configured as request fields in delete company event in JSDN.
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
			throw new SystemException("404", "Account Not Found");
		}

	}
	
	/* 
	 * Validate the incoming data with this method. If invalid data found, throw back a ValidationException
	 * 
	 */	
	private void validateData(JIFRequest jifRequest) throws ValidationException{
		//Validate the date and if it fails throw ValidationException
		//throw new ValidationException("23434343","Invalid data. Please correct the data")
	}

}
