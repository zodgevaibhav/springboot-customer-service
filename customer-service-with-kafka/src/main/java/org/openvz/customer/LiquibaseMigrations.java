package org.openvz.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@Component
public class LiquibaseMigrations {

	private ApplicationContext context;	
	private AppConfig appConfig;
	
	@Autowired
	public LiquibaseMigrations(ApplicationContext context,AppConfig appConfig)
	{
		this.appConfig=appConfig;
		this.context=context;
	}
	
	public void run() {


		try {

			Connection c = DriverManager.getConnection(appConfig.getProperty("spring.datasource.url"),appConfig.getProperty("spring.datasource.username"), appConfig.getProperty("spring.datasource.password"));


			Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(c));

			Liquibase liquibase = new Liquibase(appConfig.getProperty("spring.liquibase.change-log"), new ClassLoaderResourceAccessor(),database);

			liquibase.update(new Contexts(), new LabelExpression());

		} catch (SQLException | LiquibaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
