package com.iu.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.b1.interceptor.CustomInterceptor;
import com.iu.b1.interceptor.MemberInterceptor;

@Configuration // XML
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private CustomInterceptor customInterceptor;
	@Autowired
	private MemberInterceptor memberInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// interceptor를 등록
		registry.addInterceptor(customInterceptor)
				// interceptor를 사용할 Url 패턴 등록
				.addPathPatterns("/member/*")
				// .addPathPatterns("/member/memberMyPage");
				// interceptor를 제외할 URL 패턴 등록
				.excludePathPatterns("/member/memberLogin").excludePathPatterns("/member/memberJoin");

		registry.addInterceptor(memberInterceptor).addPathPatterns("/member/*")
				.excludePathPatterns("/member/memberLogin").excludePathPatterns("/member/memberJoin");

		WebMvcConfigurer.super.addInterceptors(registry);

	}
}
