package com.provise.birthday.message.service.impl;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.provise.birthday.message.model.Mail;
import com.provise.birthday.message.service.MailService;

import freemarker.template.Configuration;

@Service("mailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
    JavaMailSender mailSender;
	 
    @Autowired
    Configuration fmConfiguration;
   
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendEmail(Mail mail) {
		
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
		 
	        try {
	 
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	 
	            mimeMessageHelper.setSubject(mail.getMailSubject());
	            mimeMessageHelper.setFrom(mail.getMailFrom());
	            mimeMessageHelper.setTo(mail.getMailTo());
	            mail.setMailContent(getContentFromTemplate(mail.getModel()));
	            mimeMessageHelper.setText(mail.getMailContent(), true);
	            FileSystemResource file = new FileSystemResource("D:\\PracticeWorkSpace\\birthday-app\\birthdaypic.jpg");
	            mimeMessageHelper.addAttachment(file.getFilename(), file);
	         //   mimeMessageHelper.
	            mailSender.send(mimeMessageHelper.getMimeMessage());
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
		
	}
	
    public String getContentFromTemplate(Map < String, Object > model) {
        StringBuffer content = new StringBuffer();
 
        try {
            content.append(FreeMarkerTemplateUtils
                .processTemplateIntoString(fmConfiguration.getTemplate("email-template.html"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
