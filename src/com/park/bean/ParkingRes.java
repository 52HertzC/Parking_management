package com.park.bean;

import java.util.Date;

public class ParkingRes {
    private Long id;

    private String resCarId;

    private String resStaId;

    private Date resStartTime;

    private Date resEndTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResCarId() {
        return resCarId;
    }

    public void setResCarId(String resCarId) {
        this.resCarId = resCarId == null ? null : resCarId.trim();
    }

    public String getResStaId() {
        return resStaId;
    }

    public void setResStaId(String resStaId) {
        this.resStaId = resStaId == null ? null : resStaId.trim();
    }

    public Date getResStartTime() {
        return resStartTime;
    }

    public void setResStartTime(Date resStartTime) {
        this.resStartTime = resStartTime;
    }

    public Date getResEndTime() {
        return resEndTime;
    }

    public void setResEndTime(Date resEndTime) {
        this.resEndTime = resEndTime;
    }
}