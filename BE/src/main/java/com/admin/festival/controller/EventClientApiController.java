package com.admin.festival.controller;


import com.admin.festival.dto.event.*;
import com.admin.festival.service.*;
import com.admin.festival.entity.EventEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor // lombok에서 제공하는 어노테이션
@RequestMapping("/event")
public class EventClientApiController {

    private final EventService eventService;
    private final MemberService memberService;

    @GetMapping("/event_all")
    public ResponseEntity<EventEntity> getEventById(HttpSession session) {
        String loginName = (String) session.getAttribute("loginName");

        System.out.println("하이"+loginName);

        if (loginName != null && memberService.isSessionUserValid(loginName)) {
            // 세션에 로그인 정보가 있을 때만 실행
            EventEntity eventEntity = eventService.getAllEventInfo();
            if (eventEntity != null) {
                return ResponseEntity.ok(eventEntity);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // 1. 티켓 API
    @GetMapping("/ticket")
    public ResponseEntity<TicketDTO> getTicketInfo(){
        TicketDTO ticketDTO = eventService.getAllTicketInfo();
        return ResponseEntity.ok(ticketDTO);
    }

    // 2. 보물상자 API
    @GetMapping("/box")
    public ResponseEntity<BoxDTO> getBoxInfo(){
        BoxDTO boxDTO = eventService.getAllBoxInfo();
        return ResponseEntity.ok(boxDTO);
    }

    // 3. 드레스코드 API
    @GetMapping("/dress")
    public ResponseEntity<DressDTO> getDressInfo(){
        DressDTO dressDTO = eventService.getAllDressInfo();
        return ResponseEntity.ok(dressDTO);
    }

}
