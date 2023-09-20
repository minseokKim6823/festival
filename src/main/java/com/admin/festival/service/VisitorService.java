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
    public long countset=0L;// 9/18 22시 update
    @Cacheable("countset")
    public Long getVisitorCount() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        return visitorEntity.getCount();
    }
    // 9/18 22시 update 시작
    public void incrementVisitorCount() {
        countset=countset + 1;
    }
    @Scheduled(fixedRate = 10000)//900초 기준
    public void updateDB() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        visitorEntity.setCount(countset);
        visitorRepository.save(visitorEntity);
    }
    // 9/18 22시 update 끝
}

