package com.park.bean;

public class ParkingStall {
    private Long id;

    private String staId;

    private Long staPlace;

    private Long staFixation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }

    public Long getStaPlace() {
        return staPlace;
    }

    public void setStaPlace(Long staPlace) {
        this.staPlace = staPlace;
    }

    public Long getStaFixation() {
        return staFixation;
    }

    public void setStaFixation(Long staFixation) {
        this.staFixation = staFixation;
    }
}