package org.openvz.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain {
	
	private static LiquibaseMigrations liquibaseMigrations;
	private static AppConfig appConfig;
	
	@Autowired
	public ApplicationMain(LiquibaseMigrations liquibaseMigrations, AppConfig appConfig)
	{
		ApplicationMain.liquibaseMigrations=liquibaseMigrations;
		ApplicationMain.appConfig=appConfig;
	}
	
	public static void main(String[] args) {
		

		SpringApplication.run(ApplicationMain.class, args);
				
		if(null!=appConfig.getProperty("liquibase.init.container") && appConfig.getProperty("liquibase.init.container").equalsIgnoreCase("true"))
		{
			liquibaseMigrations.run();
			System.out.println("***** Exiting application since invoked as init-container");
			System.exit(0);
		}
	}

}
