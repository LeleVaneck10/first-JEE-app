package com.in28Minutes.Login;

public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if(user.equals("LeleVaneck")&& password.equals("auriol"))
			return true;
		
		return false; 
	} 
}
