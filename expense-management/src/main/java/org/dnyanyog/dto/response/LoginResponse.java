package org.dnyanyog.dto.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginResponse {

		private String status;
		private String message;
		private String jwt;
		
		@Autowired
		private UserData data;
		
		@Autowired
		private UserFails errors;
		
		public UserFails getErrors() {
			return errors;
		}	public void setErrors(UserFails errors) {
			this.errors = errors;
		}
		public String getStatus() {
			return status;
		}
		public UserData getData() {
			return data;
		}
		public void setData(UserData data) {
			this.data = data;
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
		public String getJwt() {
			return jwt;
		}
		public void setJwt(String jwt) {
			this.jwt = jwt;
		}
			

	}


