package org.dnyanyog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.dnyanyog.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrePostProcessHook {

	
	private static final Logger logger = LoggerFactory.getLogger(PrePostProcessHook.class);
	
	@After("execution(* org.dnyanyog.repository.*.save(..))")
	public void afterExecution(JoinPoint jointPoint)
	{
		logger.info("\n *************** Saved object - "+jointPoint.getArgs()[0]);
		
		Users users = (Users)jointPoint.getArgs()[0];
		logger.info(users.getCountry());
		logger.info(users.getCurrency());
		logger.info(users.getEmail());
		logger.info(users.getPassword());

	}

// * org.dynanyog.repository.*.save(..)
	
	@Before("execution(* org.dnyanyog.repository.*.save(..))")
	public void beforeExecution(JoinPoint jointPoint)
	{
		logger.info("\n *************** saving object - "+jointPoint.getArgs()[0]);
		Users users = (Users)jointPoint.getArgs()[0];
		logger.info(users.getCountry());
		logger.info(users.getCurrency());
		System.out.println(users.getEmail());
		if(users.getPassword().length()<12)
		{
			System.out.println("Password is less than 12 char");
		}
	}	
}