package com.provise.birthday.message.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
@ComponentScan(basePackages="com.provise")
public class ApplicationConfig {
	
	 @Bean
	    public JavaMailSender getMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 
	        mailSender.setHost("smtp.outlook.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("koteswar.rao@proviseconsulting.com");
	        mailSender.setPassword("");
	 
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");
	 
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }
	 
	    @Bean
	    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
	        FreeMarkerConfigurationFactoryBean fmConfigFactoryBean = new FreeMarkerConfigurationFactoryBean();
	        fmConfigFactoryBean.setTemplateLoaderPath("/templates/");
	        return fmConfigFactoryBean;
	    }

}
