package com.nearbuy.backend.dto;

import jakarta.persistence.Column;
import lombok.*;


public class InviteAdminDto {
    private String name;
    private String email;
    private Long phoneNumber;
    private int pincode;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String gender;

    public InviteAdminDto(String name, String email, Long phoneNumber, int pincode, String addressLine1, String addressLine2, String addressLine3, String gender) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.gender = gender;
    }

    public InviteAdminDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
