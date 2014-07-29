package com.cnpat.pdsc.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {

	@Around("within(com.cnpat.pdsc.rmi.impl.*)")
	public Object serviceInOutLogger(ProceedingJoinPoint pjp) throws Throwable {

		Logger logger = LogManager.getLogger(pjp.getTarget().getClass());

		logger.info("====================== Service In =====================");
		logger.debug(pjp.getSignature().getName());
		logger.debug("params:");
		for (Object ins : pjp.getArgs()) {
			logger.debug(ins);
		}

		Object retVal = pjp.proceed();

		logger.debug("result:");
		logger.debug(retVal);
		logger.info("====================== Service Out =====================");

		return retVal;
	}
}
