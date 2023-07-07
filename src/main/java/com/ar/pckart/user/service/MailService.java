package com.ar.pckart.user.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ar.pckart.user.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public String sendOTPMail(User user, String OTP) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		String subject = "Here's your One-Time-Password (OTP) - Expires in 5 minutes!";
		String content = "<p><b>Hello </b>" + user.getFullname() + ",</p>"
				+ "<p>For security reason,you're required to use the following One-Time-Password to login:</p>"
				+ "<p><b>" + OTP + "</b></p>" 
				+ "<br>" 
				+ "<p>Note: this OTP is set to expire in 5 minutes.</p>";

		helper.setFrom("donrahman6@gmail.com", "pckart support");
		helper.setTo(user.getEmail());
		helper.setSubject(subject);
		helper.setText(content, true);

		mailSender.send(message);
		
		return "Mail Send Successfuly";
	}

}


/*
	@PostMapping("/contact")
	public String submitContact(HttpServletRequest request) {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
//		String fullname = "David beckam";
//		String email = "abdulrahmankm1712@gmail.com";
//		String subject = "Sample subject";
//		String content = "Sample Content";
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("donrahman6@gmail.com");
		message.setTo("abdulrahmankm1712@gmail.com");
		
		String mailSubject = fullname+" has sent a message";
		String mailContent = "Sender Name:"+fullname+"\n";
		mailContent += "Sender Email:"+email+"\n";
		mailContent += "Subject:"+subject+"\n";
		mailContent += "Content:"+content+"\n";
		
		message.setSubject(mailSubject);
		message.setText(mailContent);
		
		mailSender.send(message);
		
		return "message";
	}
	
	@PostMapping("/contact2")
	public String submitContact2HTMLMode(HttpServletRequest request,
			@RequestParam("attachment") MultipartFile multipartFile) throws UnsupportedEncodingException, MessagingException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
//		String fullname = "David beckam";
//		String email = "abdulrahmankm1712@gmail.com";
//		String subject = "Sample subject";
//		String content = "Sample Content";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		String mailSubject = fullname+" has sent a message";
		String mailContent = "<p><b>Sender Name:</b>"+fullname+"</p>";
		mailContent += "<p><b>Sender Email:</b>"+email+"</p>";
		mailContent += "<p><b>Subject:</b>"+subject+"</p>";
		mailContent += "<p><b>Content:</b>"+content+"</p>";
		mailContent += "<hr><img src='cid:logoImage'/>";
		mailContent += "<hr><a href='https://www.google.com'>"
				+ "<img src='cid:googleImage'/></a>";
		
		helper.setFrom("donrahman6@gmail.com", "Shopme Contact");
		helper.setTo("abdulrahmankm1712@gmail.com");
		helper.setSubject(mailSubject);
		helper.setText(mailContent, true);
		
		ClassPathResource resource = new ClassPathResource("/static/images/insta.png");
		helper.addInline("logoImage", resource);
		
		ClassPathResource resourceGoogle = new ClassPathResource("/static/images/google.png");
		helper.addInline("googleImage", resourceGoogle);
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			InputStreamSource source = new InputStreamSource() {
				@Override
				public InputStream getInputStream() throws IOException {
					return multipartFile.getInputStream();
				}
			};
			helper.addAttachment(fileName, source);
		}
		
		mailSender.send(message);
		
		return "message";
	}

*/