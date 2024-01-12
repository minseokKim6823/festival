package com.admin.festival.service;

import com.admin.festival.entity.VisitorEntity;
import com.admin.festival.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    public double countset = 0;

    @Cacheable("countset")
    public Long getVisitorCount() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        return visitorEntity.getCount();
    }

    public Long incrementVisitorCount() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        countset = countset + 0.5;
        return visitorEntity.getCount();
    }

    @Scheduled(fixedRate = 10000)
    public void updateDB() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        visitorEntity.setCount((long) countset);
        visitorRepository.save(visitorEntity);
    }
}
