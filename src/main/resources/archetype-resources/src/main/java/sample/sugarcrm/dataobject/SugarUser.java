#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.sugarcrm.dataobject;

public class SugarUser {
	private String firstName;
	private String lastName;
	private String phoneWork;	        
	private String phoneMobile;
	private String phoneHome;
	private String title;
	private String phoneFax;
	private String email1;
	private String birthdate;
	private String assistant;
	private String assistantPhone;
	private String primaryAddressStreet;
	private String altAddressStreet;
	private String primaryAddressCity;
	private String altAddressCity;
	private String primaryAddressState;
	private String altAddressState;
	private String primaryAddressPostalcode;
	private String altAddressPostalcode;
	private String primaryAddressCountry;
	private String altAddressCountry;
	private String description;
	
	private String recordID;
	

	private String email2;
	private String loginName;
	private String deptName;

	private String mobile;
	private String fax;
	private String email;
	private String otherEmail;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String primaryAddress;
	private String password;
	/**
	 * @return Returns the altAddressCity.
	 */
	public String getAltAddressCity() {
		return altAddressCity;
	}
	/**
	 * @param altAddressCity The altAddressCity to set.
	 */
	public void setAltAddressCity(String altAddressCity) {
		this.altAddressCity = altAddressCity;
	}
	/**
	 * @return Returns the altAddressCountry.
	 */
	public String getAltAddressCountry() {
		return altAddressCountry;
	}
	/**
	 * @param altAddressCountry The altAddressCountry to set.
	 */
	public void setAltAddressCountry(String altAddressCountry) {
		this.altAddressCountry = altAddressCountry;
	}
	/**
	 * @return Returns the altAddressPostalcode.
	 */
	public String getAltAddressPostalcode() {
		return altAddressPostalcode;
	}
	/**
	 * @param altAddressPostalcode The altAddressPostalcode to set.
	 */
	public void setAltAddressPostalcode(String altAddressPostalcode) {
		this.altAddressPostalcode = altAddressPostalcode;
	}
	/**
	 * @return Returns the altAddressState.
	 */
	public String getAltAddressState() {
		return altAddressState;
	}
	/**
	 * @param altAddressState The altAddressState to set.
	 */
	public void setAltAddressState(String altAddressState) {
		this.altAddressState = altAddressState;
	}
	/**
	 * @return Returns the altAddressStreet.
	 */
	public String getAltAddressStreet() {
		return altAddressStreet;
	}
	/**
	 * @param altAddressStreet The altAddressStreet to set.
	 */
	public void setAltAddressStreet(String altAddressStreet) {
		this.altAddressStreet = altAddressStreet;
	}
	/**
	 * @return Returns the assistant.
	 */
	public String getAssistant() {
		return assistant;
	}
	/**
	 * @param assistant The assistant to set.
	 */
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	/**
	 * @return Returns the assistantPhone.
	 */
	public String getAssistantPhone() {
		return assistantPhone;
	}
	/**
	 * @param assistantPhone The assistantPhone to set.
	 */
	public void setAssistantPhone(String assistantPhone) {
		this.assistantPhone = assistantPhone;
	}
	/**
	 * @return Returns the birthdate.
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/**
	 * @param birthdate The birthdate to set.
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return Returns the email1.
	 */
	public String getEmail1() {
		return email1;
	}
	/**
	 * @param email1 The email1 to set.
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return Returns the phoneFax.
	 */
	public String getPhoneFax() {
		return phoneFax;
	}
	/**
	 * @param phoneFax The phoneFax to set.
	 */
	public void setPhoneFax(String phoneFax) {
		this.phoneFax = phoneFax;
	}
	/**
	 * @return Returns the phoneHome.
	 */
	public String getPhoneHome() {
		return phoneHome;
	}
	/**
	 * @param phoneHome The phoneHome to set.
	 */
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	/**
	 * @return Returns the phoneMobile.
	 */
	public String getPhoneMobile() {
		return phoneMobile;
	}
	/**
	 * @param phoneMobile The phoneMobile to set.
	 */
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	/**
	 * @return Returns the phoneWork.
	 */
	public String getPhoneWork() {
		return phoneWork;
	}
	/**
	 * @param phoneWork The phoneWork to set.
	 */
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	/**
	 * @return Returns the primaryAddressCity.
	 */
	public String getPrimaryAddressCity() {
		return primaryAddressCity;
	}
	/**
	 * @param primaryAddressCity The primaryAddressCity to set.
	 */
	public void setPrimaryAddressCity(String primaryAddressCity) {
		this.primaryAddressCity = primaryAddressCity;
	}
	/**
	 * @return Returns the primaryAddressCountry.
	 */
	public String getPrimaryAddressCountry() {
		return primaryAddressCountry;
	}
	/**
	 * @param primaryAddressCountry The primaryAddressCountry to set.
	 */
	public void setPrimaryAddressCountry(String primaryAddressCountry) {
		this.primaryAddressCountry = primaryAddressCountry;
	}
	/**
	 * @return Returns the primaryAddressPostalcode.
	 */
	public String getPrimaryAddressPostalcode() {
		return primaryAddressPostalcode;
	}
	/**
	 * @param primaryAddressPostalcode The primaryAddressPostalcode to set.
	 */
	public void setPrimaryAddressPostalcode(String primaryAddressPostalcode) {
		this.primaryAddressPostalcode = primaryAddressPostalcode;
	}
	/**
	 * @return Returns the primaryAddressState.
	 */
	public String getPrimaryAddressState() {
		return primaryAddressState;
	}
	/**
	 * @param primaryAddressState The primaryAddressState to set.
	 */
	public void setPrimaryAddressState(String primaryAddressState) {
		this.primaryAddressState = primaryAddressState;
	}
	/**
	 * @return Returns the primaryAddressStreet.
	 */
	public String getPrimaryAddressStreet() {
		return primaryAddressStreet;
	}
	/**
	 * @param primaryAddressStreet The primaryAddressStreet to set.
	 */
	public void setPrimaryAddressStreet(String primaryAddressStreet) {
		this.primaryAddressStreet = primaryAddressStreet;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
  /**
   * @return Returns the alternate email.
   */
	
	public String getEmail2(){
	    return email2;
	}
	
	/**
	 * @param email2 to set alternate email.
	 */
	public void setEmail2(String email2){
	    this.email2 = email2;
	}
	
	
	
    /**
     * @return Returns the loginName.
     */
    public String getLoginName() {
        return loginName;
    }
    /**
     * @param loginName The loginName to set.
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    /**
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return Returns the deptName.
     */
    public String getDeptName() {
        return deptName;
    }
    /**
     * @param deptName The deptName to set.
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return Returns the fax.
     */
    public String getFax() {
        return fax;
    }
    /**
     * @param fax The fax to set.
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * @return Returns the mobile.
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * @param mobile The mobile to set.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * @return Returns the otherEmail.
     */
    public String getOtherEmail() {
        return otherEmail;
    }
    /**
     * @param otherEmail The otherEmail to set.
     */
    public void setOtherEmail(String otherEmail) {
        this.otherEmail = otherEmail;
    }
   
    /**
     * @return Returns the state.
     */
    public String getState() {
        return state;
    }
    /**
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @return Returns the zip.
     */
    public String getZip() {
        return zip;
    }
    /**
     * @param zip The zip to set.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    /**
     * @return Returns the primaryAddress.
     */
    public String getPrimaryAddress() {
        return primaryAddress;
    }
    /**
     * @param primaryAddress The primaryAddress to set.
     */
    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
	public String getRecordID() {
		return recordID;
	}
	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}
}
