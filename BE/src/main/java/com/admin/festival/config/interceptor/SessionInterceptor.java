package com.admin.festival.config.interceptor;

import com.admin.festival.service.MemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Configuration
public class SessionInterceptor implements HandlerInterceptor {

    private final MemberService memberService;

    public SessionInterceptor(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("loginName");

        if (loginName != null && memberService.isSessionUserValid(loginName)) {
            // 세션에 로그인 정보가 있고, 유효한 사용자인 경우 요청 허용
            return true;
        } else {
            // 세션이 유효하지 않거나 사용자가 인증되지 않은 경우 요청 차단
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

}
