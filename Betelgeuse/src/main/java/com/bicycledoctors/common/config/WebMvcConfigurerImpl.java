package com.bicycledoctors.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bicycledoctors.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//				.order(1)
				.addPathPatterns("/*/*Xdm*", "/*/*Usr*")
				.excludePathPatterns(
//						"/resources/**",
						"/usr/**",
						"/member/signupUsrForm",
						"/member/signinUsrForm",
						"/member/signinUsrProc",
						"/member/idChkUsrProc",
						"/member/emailChkUsrProc",
						"/member/memberUsrInst",
						"/member/signupXdmForm",
						"/member/signinXdmForm",
						"/member/signinXdmProc",
						"/member/passwordrecoveryUsrForm",
						"/member/pswdfindUsrProc"
		);
	}

}