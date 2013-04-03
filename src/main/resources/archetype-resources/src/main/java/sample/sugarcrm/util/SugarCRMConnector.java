#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.sugarcrm.util;

import java.util.HashMap;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import ${package}.sample.sugarcrm.dataobject.SugarAccount;
import ${package}.sample.sugarcrm.dataobject.SugarUser;

public class SugarCRMConnector {

	private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(SugarCRMConnector.class);
	
	public String createSugarAccount(String loginUrl,String sugarUsername, String sugarPassword,SugarAccount account)throws Exception{
		LOG.debug("START:<<createSugarAccount>>");
		try{
			HttpClient httpClient=doLogin(loginUrl,sugarUsername,sugarPassword);
			
			NameValuePair[] parameters = new NameValuePair[13];
			parameters[0]=new NameValuePair("module","Accounts");
			parameters[1]=new NameValuePair("record","");
			parameters[2]=new NameValuePair("isDuplicate","true");
			parameters[3]=new NameValuePair("","");
			parameters[4]=new NameValuePair("return_module","Accounts");
			parameters[5]=new NameValuePair("return_action","DetailView");
			parameters[6]=new NameValuePair("relate_to","Accounts");
			parameters[7]=new NameValuePair("offset","0");
			parameters[8]=new NameValuePair("button","Save");
			parameters[9]=new NameValuePair("assigned_user_name",sugarUsername);
			parameters[10]=new NameValuePair("assigned_user_id","1");
			parameters[11]=new NameValuePair("emailAddressWidget","1");
			parameters[12]=new NameValuePair("useEmailWidget","true");
			
			PostMethod httpMethod = new PostMethod(loginUrl);
			httpMethod.setQueryString(parameters);
			httpMethod.setParameter("name", account.getAccountName());
			httpMethod.setParameter("action", "Save");
			httpMethod.setParameter("website", account.getWebsite());
			httpMethod.setParameter("billing_address_street", account.getBillingAddress());
			httpMethod.setParameter("billing_address_city", account.getBillingAddressCity());
			httpMethod.setParameter("billing_address_state", account.getBillingAddressState());
			
			httpMethod.setParameter("billing_address_postalcode", account.getBillingAddressPostalCode());
			httpMethod.setParameter("billing_address_country", account.getBillingAddressCountry());
			httpMethod.setParameter("description", account.getDescription());
			httpClient.executeMethod(httpMethod);
			
			
			 //String responseString=httpMethod.getResponseBodyAsString();
	          Header header=httpMethod.getResponseHeader("Location");
	          String value=header.getValue();
	          int recordIndex=value.indexOf("&record=");
	          if(recordIndex==-1){
					int duplicateIndex=value.indexOf("&action=ShowDuplicate");
					if(duplicateIndex>0){
						throw new Exception("Account Name already exists");
					}
				}
	          int endIndex=value.indexOf("&", recordIndex+2);
			
	          String recordID=value.substring(recordIndex+8, endIndex);
	          return recordID;
		}
		catch(Exception exec){
			LOG.error("Error occured in createSugarAccount:",exec);
			throw exec;
		}
		
	}
	
	public void updateAccount(String loginUrl,String sugarUsername, String sugarPassword,SugarAccount account)throws Exception{
		LOG.debug("START:<<updateAccount>>");
		try{
			HttpClient httpClient=doLogin(loginUrl,sugarUsername,sugarPassword);
			PostMethod httpMethod = new PostMethod(loginUrl);
			httpMethod = new PostMethod(loginUrl);
			
			httpMethod.setParameter("module","Accounts");
			httpMethod.setParameter("record", account.getRecordID());
			httpMethod.setParameter("action", "Save");
			httpMethod.setParameter("relate_to","Accounts");
			httpMethod.setParameter("button","Save");
			httpMethod.setParameter("name",account.getAccountName());
			httpMethod.setParameter("website",account.getWebsite());
			httpMethod.setParameter("billing_address_street",account.getBillingAddress());
			httpMethod.setParameter("billing_address_city",account.getBillingAddressCity());
			httpMethod.setParameter("billing_address_state",account.getBillingAddressState());
			httpMethod.setParameter("billing_address_postalcode",account.getBillingAddressPostalCode());
			httpMethod.setParameter("billing_address_country",account.getBillingAddressCountry());
			httpMethod.setParameter("description",account.getDescription());
			httpClient.executeMethod(httpMethod);
		}
		catch(Exception exec){
			LOG.error("Error occured in updateAccount:",exec);
			throw exec;
		}
		LOG.debug("END:<<updateAccount>>");
	}
	private HashMap praserHeader(String value){
		LOG.debug("START:<<praserHeader>>");
		int startindex=value.lastIndexOf("?");
		String keyvalueString=value.substring(startindex+1);
		String []keyValueArray=keyvalueString.split("&");
		HashMap map=new HashMap();
		for(int i=0,j=keyValueArray.length;i<j;i++){
			String[] keyValueSplitArray=keyValueArray[i].split("=");
			map.put(keyValueSplitArray[0], keyValueSplitArray[1]);
		}
		LOG.debug("END:<<praserHeader>>");
		return map;
	}
	
	public void deleteAccount(String loginUrl,String sugarUsername, String sugarPassword,String recordID)throws Exception{
		LOG.debug("START:<<deleteAccount>>");
		try{
			HttpClient httpClient=doLogin(loginUrl,sugarUsername,sugarPassword);
			PostMethod httpMethod = new PostMethod(loginUrl);
			
			httpMethod.setParameter("module","Accounts");
			httpMethod.setParameter("record",recordID );
			httpMethod.setParameter("return_action", "ListView");
			httpMethod.setParameter("return_module", "Accounts");
			httpMethod.setParameter("action", "Delete");
					
			httpClient.executeMethod(httpMethod);
		}
		catch(Exception exec){
			LOG.error("Exception occured while deleting Account:",exec);
			throw exec;
		}
		LOG.debug("END:<<deleteAccount>>");
	}
	
	public void deleteUser(String loginUrl,String sugarUsername, String sugarPassword,String recordID)throws Exception{
		LOG.debug("START:<<deleteAccount>>");
		try{
			HttpClient httpClient=doLogin(loginUrl,sugarUsername,sugarPassword);
			PostMethod httpMethod = new PostMethod(loginUrl);
			httpMethod.setParameter("action","ListView");
			httpMethod.setParameter("uid", recordID);
			httpMethod.setParameter("status", "Inactive");
			httpMethod.setParameter("return_module", "Accounts");
			httpMethod.setParameter("module", "Users");
			httpMethod.setParameter("delete", "false");
			
			httpClient.executeMethod(httpMethod);
		}
		catch(Exception exec){
			LOG.error("Exception occured while deleting user:",exec);
			throw exec;
		}
		LOG.debug("END:<<deleteUser>>");
	}
	
	public void updateUser(String loginUrl,String sugarUsername, String sugarPassword,SugarUser details) throws Exception{
		LOG.debug("START:<<updateUser>>");
		try{
			HttpClient httpClient=doLogin(loginUrl,sugarUsername,sugarPassword);
			PostMethod httpMethod = new PostMethod(loginUrl);
			
			httpMethod.setParameter("module","Users");
			httpMethod.setParameter("status", "Active");
			httpMethod.setParameter("employee_status", "Active");		
			httpMethod.setParameter("record", details.getRecordID());
			httpMethod.setParameter("return_id", details.getRecordID());
			httpMethod.setParameter("last_name", details.getLastName());
			httpMethod.setParameter("sugar_user_name",details.getLoginName());
			httpMethod.setParameter("action", "Save");
			httpMethod.setParameter("first_name", details.getFirstName());
			httpMethod.setParameter("password_change","true");
			httpMethod.setParameter("old_password","");
			httpMethod.setParameter("new_password", details.getPassword());
			httpMethod.setParameter("title", details.getTitle());
			httpMethod.setParameter("phone_work", details.getPhoneWork());
			 
			httpMethod.setParameter("department",details.getDeptName());
			httpMethod.setParameter("phone_mobile", details.getMobile());
			httpMethod.setParameter("phone_fax",details.getFax());
	          httpMethod.setParameter("email1", details.getEmail());
	          httpMethod.setParameter("email2",details.getOtherEmail());
	          httpMethod.setParameter("address_street",details.getPrimaryAddress());
	          httpMethod.setParameter("address_city",details.getPrimaryAddressCity());
	          httpMethod.setParameter("address_state",details.getPrimaryAddressState());
	          httpMethod.setParameter("address_postalcode",details.getPrimaryAddressPostalcode());
	          httpMethod.setParameter("address_country",details.getPrimaryAddressCountry());
	          httpClient.executeMethod(httpMethod);
	          String responseString=httpMethod.getResponseBodyAsString();
		  		Header header=httpMethod.getResponseHeader("Location");
		  		HashMap map=praserHeader(header.getValue());
		  		String actionValue=(String)map.get("action");
		  		if(actionValue.equalsIgnoreCase("ERROR")){
		  			String errorString=(String)map.get("error_string");
		  			errorString=java.net.URLDecoder.decode(errorString);
		  			throw new Exception(errorString);
		  		}
		}
		catch(Exception exec){
			LOG.error("Exception occured in updateUser:",exec);
			throw exec;
		}
		LOG.debug("END:<<updateUser>>");
	}
	
	public String createUser(String loginUrl,String sugarUsername, String sugarPassword,SugarUser details) throws Exception{
		LOG.debug("START:<<createUser>>");
		try{
			HttpClient httpClient=doLogin(loginUrl,sugarUsername,sugarPassword);
			PostMethod httpMethod = new PostMethod(loginUrl);
			
			httpMethod.setParameter("module","Users");
			httpMethod.setParameter("status", "Active");
			httpMethod.setParameter("new_password1", details.getPassword());
			httpMethod.setParameter("new_password2", details.getPassword());
			httpMethod.setParameter("employee_status", "Active");			
			httpMethod.setParameter("last_name", details.getLastName());
			httpMethod.setParameter("first_name", details.getFirstName());
			httpMethod.setParameter("sugar_user_name", details.getLoginName());
			httpMethod.setParameter("password_change", "false");
			httpMethod.setParameter("action", "Save");
			
			
			
			httpMethod.setParameter("title", details.getTitle());
			httpMethod.setParameter("phone_work", details.getPhoneWork());
			 
			httpMethod.setParameter("department",details.getDeptName());
			httpMethod.setParameter("phone_mobile", details.getMobile());
			httpMethod.setParameter("phone_fax",details.getFax());
	          httpMethod.setParameter("email1", details.getEmail());
	          httpMethod.setParameter("email2",details.getOtherEmail());
	          httpMethod.setParameter("address_street",details.getPrimaryAddress());
	          httpMethod.setParameter("address_city",details.getPrimaryAddressCity());
	          httpMethod.setParameter("address_state",details.getPrimaryAddressState());
	          httpMethod.setParameter("address_postalcode",details.getPrimaryAddressPostalcode());
	          httpMethod.setParameter("address_country",details.getPrimaryAddressCountry());
	          httpClient.executeMethod(httpMethod);
	          
	          String responseString=httpMethod.getResponseBodyAsString();
	  		Header header=httpMethod.getResponseHeader("Location");
	  		HashMap map=praserHeader(header.getValue());
	  		String actionValue=(String)map.get("action");
	  		if(actionValue.equalsIgnoreCase("ERROR")){
	  			String errorString=(String)map.get("error_string");
	  			errorString=java.net.URLDecoder.decode(errorString);
	  			throw new Exception(errorString);
	  		}
	  		return (String)map.get("record");
	         
		}
		catch(Exception exec){
			LOG.error("Exception occured in createUser:",exec);
			throw exec;
		}
		
		

		
	}
	
	
	private HttpClient doLogin(String loginUrl,String sugarUsername, String sugarPassword)throws Exception{
		LOG.debug("START:<<doLogin>>");
		PostMethod httpMethod = new PostMethod(loginUrl);
		NameValuePair[] authDetails = new NameValuePair[13];
		authDetails[0]=new NameValuePair("module","Users");
		authDetails[1]=new NameValuePair("action","Authenticate");
		authDetails[2]=new NameValuePair("return_module","Users");
		authDetails[3]=new NameValuePair("return_action","Login");
		authDetails[4]=new NameValuePair("cant_login","");
		authDetails[5]=new NameValuePair("login_module","");
		authDetails[6]=new NameValuePair("login_action","");
		authDetails[7]=new NameValuePair("login_record","");
		authDetails[8]=new NameValuePair("user_name",sugarUsername);
		authDetails[9]=new NameValuePair("user_password",sugarPassword);
		authDetails[10]=new NameValuePair("login_theme","Sugar");
		authDetails[11]=new NameValuePair("login_language","en_us");
		authDetails[12]=new NameValuePair("Login","++Login++");
		
		httpMethod.setQueryString(authDetails);
		HttpClient httpClient=new HttpClient();
		httpClient.executeMethod(httpMethod);
		LOG.debug("START:<<doLogin>>");
		return httpClient;
	}
}
