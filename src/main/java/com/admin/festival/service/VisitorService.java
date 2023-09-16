package com.admin.festival.service;

import com.admin.festival.entity.VisitorEntity;
import com.admin.festival.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;
    private Long countset=0L;
    @Cacheable("countset")
    public Long getVisitorCount() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        return visitorEntity.getCount();
    }

    public Long incrementVisitorCount() {
        VisitorEntity visitorEntity = visitorRepository.findById(1L).orElse(new VisitorEntity());
        countset=countset + 1;
        if(countset%5==0){
            visitorEntity.setCount(visitorEntity.getCount() + 5);
            visitorRepository.save(visitorEntity);
        }
        return visitorEntity.getCount();
    }
}

