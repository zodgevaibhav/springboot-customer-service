package org.openvz.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/application-qa.properties")
public class AppConfig {
	
	   @Autowired
	    private Environment env;
	   
	   public String getProperty(String propertyName)
	   {
		   if(null!=System.getenv(propertyName))
			   return System.getenv(propertyName);
		   else if(null!=System.getProperty(propertyName))
			   return System.getProperty(propertyName);
		   else if(null!=env.getProperty(propertyName))
			   return env.getProperty(propertyName);
		   else 
		   {
			   System.out.println("!!!!!!!!!! Property Not found returning null - "+propertyName);
			   return null;
		   }
	   }

}
