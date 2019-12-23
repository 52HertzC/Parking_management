package com.park.bean;

public class ParkingOwner {
    private Long ownId;

    private String carId;

    private String carStaId;

    private String carName;

    private String carSite;

    private String carAge;

    private String carPhone;

    private String carColor;

    private String carMoney;

    public Long getOwnId() {
        return ownId;
    }

    public void setOwnId(Long ownId) {
        this.ownId = ownId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getCarStaId() {
        return carStaId;
    }

    public void setCarStaId(String carStaId) {
        this.carStaId = carStaId == null ? null : carStaId.trim();
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public String getCarSite() {
        return carSite;
    }

    public void setCarSite(String carSite) {
        this.carSite = carSite == null ? null : carSite.trim();
    }

    public String getCarAge() {
        return carAge;
    }

    public void setCarAge(String carAge) {
        this.carAge = carAge == null ? null : carAge.trim();
    }

    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone == null ? null : carPhone.trim();
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    public String getCarMoney() {
        return carMoney;
    }

    public void setCarMoney(String carMoney) {
        this.carMoney = carMoney == null ? null : carMoney.trim();
    }
}