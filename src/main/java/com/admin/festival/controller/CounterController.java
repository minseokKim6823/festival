package com.admin.festival.controller;

import com.admin.festival.response.VisitorResponse;
import com.admin.festival.entity.VisitorEntity;
import com.admin.festival.repository.VisitorRepository;
import com.admin.festival.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visitor")
public class CounterController {
    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private VisitorService visitorService;

    @GetMapping("/count")
    public VisitorResponse getVisitorCount() {
        visitorService.incrementVisitorCount();
        return new VisitorResponse(visitorService.countset);
    }
}


