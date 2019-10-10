package com.provise.birthday.message.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.provise.birthday.message.config.ApplicationConfig;
import com.provise.birthday.message.model.Mail;
import com.provise.birthday.message.service.MailService;
import com.provise.birthday.message.util.OrientDbUtil;
import com.provise.birthday.message.viewobject.EmployeeDetailsModel;

public class App {
	public static void main(String[] args) {
		OrientDbUtil dbUtil =new OrientDbUtil();
		ODatabaseSession db =dbUtil.getClientConnection();

		
		Mail mail = new Mail();
        mail.setMailFrom("koteswar.rao@proviseconsulting.com");
        mail.setMailTo("shreegowri.jayashankar@proviseconsulting.com");
        mail.setMailSubject("Birthday Wishes ");
 

      EmployeeDetailsModel empModel=  dbUtil.getDetails(db,"2019-06-11");
        Map < String, Object > model = new HashMap < String, Object > ();
        model.put("firstName",empModel.getFirstName());
        model.put("lastName", empModel.getLastName());
        
        model.put("location", "Bangalore");
        model.put("signature", "ProVise ");
        mail.setModel(model);
 
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MailService mailService = (MailService) context.getBean("mailService");
        mailService.sendEmail(mail);
        context.close();
	}

}
