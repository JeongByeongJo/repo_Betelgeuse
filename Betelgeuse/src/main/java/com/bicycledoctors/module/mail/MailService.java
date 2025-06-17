package com.bicycledoctors.module.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bicycledoctors.module.member.MemberDao;
import com.bicycledoctors.module.member.MemberDto;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	MemberDao memberDao;
	
//	회원가입 축하 메일
    public void sendMailWelcome(MemberDto memberDto) throws Exception{

    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo(memberDto.getUserEmail()); 
    	mimeMessageHelper.setSubject("되는데 ");
    	mimeMessageHelper.setText("좀 되라 ", true); 
    	javaMailSender.send(mimeMessage);
    	
    }
    
//	회원가입 축하 메일
    public void sendMailPWRecovery(MemberDto memberDto) throws Exception{
    	
    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo(memberDto.getUserEmail()); 
    	mimeMessageHelper.setSubject("BicycleDoctors 계정 안내");
    	mimeMessageHelper.setText("가입하신 ID는 " + memberDto.getUserId() + "입니다.\n" + "비밀번호는 가입시 사용한 이름으로 초기화되었습니다. \n 회원정보 변경에서 비밀번호를 꼭 변경해주세요.", true); 
    	javaMailSender.send(mimeMessage);
    	
    }
	
}
