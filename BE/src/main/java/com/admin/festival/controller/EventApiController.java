package com.admin.festival.controller;

import com.admin.festival.dto.MemberDTO;
import com.admin.festival.dto.event.*;
import com.admin.festival.entity.EventEntity;
import com.admin.festival.service.EventService;
import com.admin.festival.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/festival/api")
public class EventApiController {

    private final EventService eventService;
    private final MemberService memberService;

    // 모든 정보 요청
    // 관리자 페이지 api
    @GetMapping("/all")
    public ResponseEntity<EventEntity> getEventById() {
        EventEntity eventEntity = eventService.getAllEventInfo();
        if (eventEntity != null) {
            return ResponseEntity.ok(eventEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get_ticket")
    public ResponseEntity<TicketDTO> getTicketInfo(){
        TicketDTO ticketDTO = eventService.getAllTicketInfo();
        return ResponseEntity.ok(ticketDTO);
    }

    @GetMapping("/get_box")
    public ResponseEntity<BoxDTO> getBoxInfo(){
        BoxDTO boxDTO = eventService.getAllBoxInfo();
        return ResponseEntity.ok(boxDTO);
    }

    @GetMapping("/get_dress")
    public ResponseEntity<DressDTO> getDressInfo(){
        DressDTO dressDTO = eventService.getAllDressInfo();
        return ResponseEntity.ok(dressDTO);
    }

    @PatchMapping("/ticket_change/{count}")
    public Map<String, Integer> ticket (@PathVariable("count") int count){

        // ticket_update 메서드 호출
        eventService.ticket_update(count);

        // count 값을 Map에 담아서 JSON으로 반환
        Map<String, Integer> response = new HashMap<>();
        response.put("ticket", count);
        return response;
    }

    @PatchMapping("/box_toggle/{idx}")
    public Map<String, Integer> toggleTreasure(@PathVariable("idx") int idx){

        // 박스 번호만 넘어오면
        // entity에서 번호 조회해서
        // 그값을 토글해서 바꿔준다.

        // treasure_toggle 메서드 호출
        eventService.box_toggle(idx);

        // value를 int로 파싱하여 사용
        Map<String, Integer> response = new HashMap<>();
        response.put("value", idx);
        return response;
    }

    // 박스 API
    @PatchMapping("/dress_toggle/{idx}")
    public Map<String, Integer> toggleDress(@PathVariable("idx") int idx){

        // treasure_toggle 메서드 호출
        eventService.dress_toggle(idx);

        // value를 int로 파싱하여 사용
        Map<String, Integer> response = new HashMap<>();
        response.put("value", idx);
        return response;
    }

}
