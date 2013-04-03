#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.sugarcrm.adapter;

import ${package}.adapter.Authentication;
import ${package}.dataobject.AuthInfo;
import ${package}.exception.AuthenticationException;

public class AuthenticationImpl implements Authentication {

	public void authenticate(AuthInfo authInfo) throws AuthenticationException {
		String authLogin = authInfo.getUserName();
		String authPassword = authInfo.getPassword();
		//If the auth info is not valid throw exception
		
		//throw new AuthenticationException(1000,"Autherization failed");
	}

}
