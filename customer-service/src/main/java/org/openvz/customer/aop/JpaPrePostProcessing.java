package org.openvz.customer.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.openvz.customer.LiquibaseMigrations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JpaPrePostProcessing {

	private static final Logger logger = LoggerFactory.getLogger(JpaPrePostProcessing.class);
	
	@After("execution(* org.openvz.customer.dao.*.save(..))")
	public void afterExecution(JoinPoint jointPoint)
	{
		logger.info("Saved object - "+jointPoint.getArgs()[0]);
	}

	@Before("execution(* org.openvz.customer.dao.*.save(..))")
	public void beforeExecution(JoinPoint jointPoint)
	{
		logger.info("Saving object - "+jointPoint.getArgs()[0]);
	}
	
}
