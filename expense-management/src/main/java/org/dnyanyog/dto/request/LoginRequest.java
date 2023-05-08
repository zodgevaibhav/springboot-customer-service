package org.dnyanyog.dto.request;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
		private String email;
		private String password;
		private String mobile;
		
		
	public String getPassword() {
			return password;
		}
	public String getEmail() {
			return email;
		}
	public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	}


