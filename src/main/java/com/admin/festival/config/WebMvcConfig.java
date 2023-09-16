package com.admin.festival.config;

import com.admin.festival.config.interceptor.SessionInterceptor;
import com.admin.festival.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final MemberService memberService;

    @Autowired
    public WebMvcConfig(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor(memberService))
                .addPathPatterns("/admin/festival/api/**")
                .addPathPatterns("/event/**");
    }
}
