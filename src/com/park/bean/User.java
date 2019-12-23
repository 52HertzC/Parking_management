package com.park.bean;

public class User {
    private Long userId;

    private String username;

    private String password;

    private Long userRoleId;

    private String userCarId;
    
    private UserRole userRole;
    
    public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public ParkingOwner getParkingOwner() {
		return parkingOwner;
	}

	public void setParkingOwner(ParkingOwner parkingOwner) {
		this.parkingOwner = parkingOwner;
	}

	private ParkingOwner parkingOwner;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(String userCarId) {
        this.userCarId = userCarId == null ? null : userCarId.trim();
    }
}