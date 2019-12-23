package com.park.bean;

public class ParkingManage {
    private Long id;

    private String manageStaId;

    private String manageArea;

    private String managePs;

    private String manageCarId;
    
    private ParkingRecord parkingRecord;

    public ParkingRecord getParkingRecord() {
		return parkingRecord;
	}

	public void setParkingRecord(ParkingRecord parkingRecord) {
		this.parkingRecord = parkingRecord;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManageStaId() {
        return manageStaId;
    }

    public void setManageStaId(String manageStaId) {
        this.manageStaId = manageStaId == null ? null : manageStaId.trim();
    }

    public String getManageArea() {
        return manageArea;
    }

    public void setManageArea(String manageArea) {
        this.manageArea = manageArea == null ? null : manageArea.trim();
    }

    public String getManagePs() {
        return managePs;
    }

    public void setManagePs(String managePs) {
        this.managePs = managePs == null ? null : managePs.trim();
    }

    public String getManageCarId() {
        return manageCarId;
    }

    public void setManageCarId(String manageCarId) {
        this.manageCarId = manageCarId == null ? null : manageCarId.trim();
    }
}