package com.rahal.aop.service;

public class OperaService {
	
	public void perform(){
		System.out.println("Performing Opera...");
	}
	
	public void withoutAudiencePerform(){
		System.out.println("Performing Opera without audience...");
	}
	
	public void performBadPerformance() throws Exception{
		System.out.println("Performing Bad Opera...");
		throw new Exception();
	}
}
