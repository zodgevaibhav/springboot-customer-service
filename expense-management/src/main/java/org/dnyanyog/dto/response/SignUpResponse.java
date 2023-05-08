package org.dnyanyog.dto.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpResponse {

	private String status;
	private String message;
	
	@Autowired
	private UserData data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserData getData() {
		return data;
	}

	public void setData(UserData data) {
		this.data = data;
	}
	
	public static SignUpResponse getSignUpObject() {
		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse.setData(new UserData());

		return signUpResponse;
	}
	
	public SignUpResponse()
	{
		data = new UserData();
	}
}
