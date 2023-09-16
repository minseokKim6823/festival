package com.admin.festival.controller;

import com.admin.festival.dto.MemberDTO;
import com.admin.festival.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
@RequestMapping("/admin_member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);

        if (loginResult != null) {
            // 로그인 성공
            session.setAttribute("loginName", loginResult.getUserid());
            System.out.println("하하" + loginResult.getUserid()); // id가 저장됨 "이용우"이런식으로 즉 "loginName":"이용우" 저장됨.
            // 200 ok 응답 반환
            return ResponseEntity.ok().body("{\"response\": 200}");
        } else{
            // 로그인 실패
            // 402
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("{\"response\": 402}");
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
}
