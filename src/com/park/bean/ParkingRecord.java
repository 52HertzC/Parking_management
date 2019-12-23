package com.park.bean;

import java.util.Date;

public class ParkingRecord {
    private Long recId;

    private String recCarId;

    private Date recEntryDate;

    private Date recLeaveDate;

    private Long recTime;

    private String recCharge;

    private String recCost;

    private Long recOwnId;

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getRecCarId() {
        return recCarId;
    }

    public void setRecCarId(String recCarId) {
        this.recCarId = recCarId == null ? null : recCarId.trim();
    }

    public Date getRecEntryDate() {
        return recEntryDate;
    }

    public void setRecEntryDate(Date recEntryDate) {
        this.recEntryDate = recEntryDate;
    }

    public Date getRecLeaveDate() {
        return recLeaveDate;
    }

    public void setRecLeaveDate(Date recLeaveDate) {
        this.recLeaveDate = recLeaveDate;
    }

    public Long getRecTime() {
        return recTime;
    }

    public void setRecTime(Long recTime) {
        this.recTime = recTime;
    }

    public String getRecCharge() {
        return recCharge;
    }

    public void setRecCharge(String recCharge) {
        this.recCharge = recCharge == null ? null : recCharge.trim();
    }

    public String getRecCost() {
        return recCost;
    }

    public void setRecCost(String recCost) {
        this.recCost = recCost == null ? null : recCost.trim();
    }

    public Long getRecOwnId() {
        return recOwnId;
    }

    public void setRecOwnId(Long recOwnId) {
        this.recOwnId = recOwnId;
    }
}