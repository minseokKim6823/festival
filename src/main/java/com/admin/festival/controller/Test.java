package com.admin.festival.controller;

import com.admin.festival.dto.MemberDTO;
import com.admin.festival.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Controller
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
public class Test {

    private final MemberService memberService;

    @PostMapping("/admin/event")
    public String eventPage(@ModelAttribute MemberDTO memberDTO, HttpSession session)
    {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null){
            //login 성공
            session.setAttribute("loginName", loginResult.getUserid());
            return "event";
        } else {
            // login 실패
            return "login";
        }
    }

}
