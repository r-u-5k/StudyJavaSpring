package com.itwill.user.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

//@Configuration
public class WebAppInitConf implements ServletContextInitializer {
	public WebAppInitConf() {
		System.out.println("### WebApplicationInitializer()생성자");
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("### onStartup()메쏘드");
		/*
		AnnotationConfigWebApplicationContext context = 
				new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		ServletRegistration.Dynamic dynamic=
				servletContext.addServlet("dispatcherSevlet", new DispatcherServlet(context));
		dynamic.setLoadOnStartup(0);
		dynamic.addMapping("*.do");
		
		//ApplicationConfig.java : config 설정 클래스를 지정해주는 것
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(ApplicationConfig.class);
		//Listener
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		//WebConfig.java
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		servletConfig.register(WebConfig.class);
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");
		//encodingFilter
		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
		*/
	}

}
