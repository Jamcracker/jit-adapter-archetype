#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.sugarcrm.dataobject;



public class SugarAccount {
	
	private String accountName;
	private String website;
	private String billingAddress;
	private String billingAddressCity;
	private String billingAddressStreet;
	private String billingAddressCountry;
	private String billingAddressPostalCode;
	private String description;
	private String billingAddressState;
	private String recordID;
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingAddressCity() {
		return billingAddressCity;
	}

	public void setBillingAddressCity(String billingAddressCity) {
		this.billingAddressCity = billingAddressCity;
	}

	public String getBillingAddressCountry() {
		return billingAddressCountry;
	}

	public void setBillingAddressCountry(String billingAddressCountry) {
		this.billingAddressCountry = billingAddressCountry;
	}

	public String getBillingAddressPostalCode() {
		return billingAddressPostalCode;
	}

	public void setBillingAddressPostalCode(String billingAddressPostalCode) {
		this.billingAddressPostalCode = billingAddressPostalCode;
	}

	public String getBillingAddressStreet() {
		return billingAddressStreet;
	}

	public void setBillingAddressStreet(String billingAddressStreet) {
		this.billingAddressStreet = billingAddressStreet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBillingAddressState() {
		return billingAddressState;
	}

	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}
	
}
