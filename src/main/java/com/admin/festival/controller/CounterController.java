package com.admin.festival.controller;

import com.admin.festival.Response.VisitorResponse;
import com.admin.festival.entity.VisitorEntity;
import com.admin.festival.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visitor")
public class CounterController {
    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping("/count")
    public VisitorResponse getVisitorCount() {
        Long visitorId = 1L;
        VisitorEntity visitorEntity = visitorRepository.findById(visitorId).orElse(new VisitorEntity());
        return new VisitorResponse(visitorEntity.getCount());
    }
}