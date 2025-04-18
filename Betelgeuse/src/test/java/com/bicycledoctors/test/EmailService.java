package com.bicycledoctors.test;


public class EmailService {

//	@Autowired
//	private JavaMailSender javaMailSender;
//	
//	@Autowired
//	TemplateService templateService;
//	
//	@Autowired
//	MemberDao memberDao;
//
//	
////	테스트
//	public void sendMailTest(TemplateVo templateVo) throws Exception{
//		
//		TemplateDto templateDto = templateService.selectOne(templateVo);
//		String contentsHtml = templateDto.getIftpContents();
//		System.out.println("templateVo.getXdTestTarget(): " + templateVo.getXdTestTarget());
//		System.out.println("templateDto.getIftpTitle(): " + templateDto.getIftpTitle());
//		System.out.println("contentsHtml: " + contentsHtml);
//		
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
//		mimeMessageHelper.setFrom(Constants.GOOGLE_ACCOUNT_FOR_SMTP);
//		mimeMessageHelper.setTo(templateVo.getXdTestTarget()); 
//		mimeMessageHelper.setSubject(templateDto.getIftpTitle());
//		mimeMessageHelper.setText(contentsHtml, true); 
//		javaMailSender.send(mimeMessage);
//		
//	}
//	
////	회원가입 축하 메일
//    public void sendMailWelcome(MemberDto memberDto, TemplateVo templateVo) throws Exception{
////        템플릿 시퀀스 설정
//    	templateVo.setIftpSeq("1");
//    	
//    	TemplateDto templateDto = templateService.selectOne(templateVo);
//    	String contentsHtml = templateDto.getIftpContents();
//    	
//    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
//    	mimeMessageHelper.setTo(memberDto.getIfmeEmailFull()); 
//    	mimeMessageHelper.setSubject(templateDto.getIftpTitle());
//    	mimeMessageHelper.setText(contentsHtml, true); 
//    	javaMailSender.send(mimeMessage);
//    	
//    }
//
//
////	이메일 인증
//    public void sendMailCertification(MemberDto memberDto, TemplateVo templateVo) throws Exception{
////        템플릿 시퀀스 설정
//    	templateVo.setIftpSeq("2");
//        Context context = new Context();
////        데이터 뭐 넘겨줄지 설정
//        String key = createRandomNumber();
//        context.setVariable("randomNum", key);
//        memberDto.setIfcfKey(key);
//        memberDao.insertCertification(memberDto);
//        
//        TemplateDto templateDto = templateService.selectOne(templateVo);
//        String contentsHtml = templateDto.getIftpContents();
//        
//        // html에서 인증번호라는 곳에 key를 넣는다
//        String template = contentsHtml.replace("인증번호", key);
//        
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
//        mimeMessageHelper.setTo(memberDto.getIfmeEmailFull()); 
//        mimeMessageHelper.setSubject(templateDto.getIftpTitle()); 
//        mimeMessageHelper.setText(template, true); 
//        javaMailSender.send(mimeMessage);
//
//    }
//    
//    
//    public String createRandomNumber() {
////    	6자리 난수
//    	int randomKey = (int)(Math.random() * 899999) + 100000;
//    	String randomKeyString = String.valueOf(randomKey);
//    	return randomKeyString;
//    }
	
}
