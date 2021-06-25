package com.infy.util;

import java.text.DateFormat;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.infy.dto.EmployeeDTO;

@Component
@Aspect
public class LoggingAspect { // Aspect class
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// AfterThrowing Advice
	@AfterThrowing("execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logAfterThrowingAdvice(JoinPoint joinPoint) {
		logger.info("In after throwing advice 1, Joinpoint signature :{}",joinPoint.getSignature());
	}
	
	// AfterThrowing Advice with Exception
	@AfterThrowing(pointcut="execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))", throwing = "exception")
	public void logAfterThrowingAdviceDetail(JoinPoint joinPoint, Exception exception) {
		logger.info("In after throwing advice 2, Joinpoint signature :{}",joinPoint.getSignature());
		logger.error(exception.getMessage(),exception);
	}
	
	// After Advice
	@After("execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logAfterAdvice(JoinPoint joinPoint) {
		logger.info("In after advice, JoinPoint Signature :{}",joinPoint.getSignature());
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateInstance().format(time);
		logger.info("Report generated at time {}",date);
	}
	
	// Before Advice
	@Before("execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		logger.info("In before advice, JoinPoint signature :{}", joinPoint.getSignature());
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateInstance().format(time);
		logger.info("Report generated at time {}",date);
	}
	
	// AfterReturning Advice
	@AfterReturning(pointcut="execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logAfterReturningAdvice(JoinPoint joinPoint) {
		logger.info("In after-returning advice, JoinPoint signature :{}", joinPoint.getSignature());
	}
	
	// AfterReturning Advice with returning value
	@AfterReturning(pointcut="execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))", returning = "result")
	public void logAfterReturningDetails(JoinPoint joinPoint, List<EmployeeDTO> result) {
		logger.info("In after-returning advice 2, JoinPoint Signature :{}",joinPoint.getSignature());
		System.out.println(result);
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateInstance().format(time);
		logger.info("Report generated at time {}",date);
	}
	
	// Around Advice
	@Around("execution(* com.infy.service.EmployeeServiceImpl.getAllEmployees(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Before proceeding part of the Around Advice.");
		Object emp = joinPoint.proceed();
		System.out.println("After proceeding part of the Around advice.");
		return emp;
	}
	
	
	
}
