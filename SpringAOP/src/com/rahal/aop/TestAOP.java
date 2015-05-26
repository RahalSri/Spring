package com.rahal.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rahal.aop.service.OperaService;

public class TestAOP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "com\\rahal\\aop\\config.xml" });
		// Get the proxyBean which was applied the advice to target service
		OperaService operaService = (OperaService) appContext.getBean("operaServiceProxy");
		
		// Note only perform() and performBadPerformance() methods are advised since pointcut is defined in config.xml (See "performPointcut" bean configuration)
		System.out.println("*************************************");
		operaService.perform();
		System.out.println("*************************************");
		operaService.withoutAudiencePerform();
		System.out.println("*************************************");
		try {
			operaService.performBadPerformance();
		} catch (Exception e) {
			
		}
		System.out.println("*************************************");
	}

}
