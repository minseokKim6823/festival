package com.admin.festival.response;

public class VisitorResponse {
    private Long count;


    public VisitorResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}