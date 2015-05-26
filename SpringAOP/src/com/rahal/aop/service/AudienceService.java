package com.rahal.aop.service;

public class AudienceService {
	public AudienceService(){
		
	}
	
	public void takeSeats(){
		System.out.println("ADVICE: The audience is taking their seats.");
	}
	
	public void turnOffCellPhones(){
		System.out.println("ADVICE: The audience is turning off their cell phones.");
	}
	
	public void applaud(){
		System.out.println("ADVICE: CLAP CLAP CLAP");
	}
	
	public void demandRefund(){
		System.out.println("ADVICE: BOOO ! We want our money bank.");
	}
}
