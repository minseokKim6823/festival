package com.admin.festival.controller;

import com.admin.festival.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @GetMapping("/getCount")
    public Long getVisitorCount() {
        return visitorService.getVisitorCount();
    }

    @GetMapping("/increment")
    public Long incrementVisitorCount() {
        return visitorService.incrementVisitorCount();
    }
}

