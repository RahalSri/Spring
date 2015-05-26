package com.rahal.aop.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AudienceAroundAdvice implements MethodInterceptor{

	private AudienceService audience;
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try{
			audience.takeSeats();
			audience.turnOffCellPhones();
			
			Object returnValue = invocation.proceed();
			
			audience.applaud();
			
			return returnValue;
		} catch (Exception e){
			audience.demandRefund();
			throw e;
		}
		
	}

	public AudienceService getAudience() {
		return audience;
	}

	// Instance will injected by in bean configuration
	public void setAudience(AudienceService audience) {
		this.audience = audience;
	}



}
