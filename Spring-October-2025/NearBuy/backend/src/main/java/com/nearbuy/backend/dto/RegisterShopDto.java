package com.nearbuy.backend.dto;

import jakarta.persistence.Column;



public class RegisterShopDto {
    // shop Information
    private String shopName;
    private String gstNumber;
    private String state;
    private int shopPincode;
    private String shopAddressLine1;
    private String shopAddressLine2;
    private String shopAddressLine3;
    private Long shopPhoneNumber;

    // Shopkeeper Info
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private int pincode;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String userType;
    private String gender;
    private String status;

    public RegisterShopDto(String shopName, String gstNumber, String state, int shopPincode, String shopAddressLine1, String shopAddressLine2, String shopAddressLine3, Long shopPhoneNumber, String name, String email, String password, Long phoneNumber, int pincode, String addressLine1, String addressLine2, String addressLine3, String userType, String gender, String status) {
        this.shopName = shopName;
        this.gstNumber = gstNumber;
        this.state = state;
        this.shopPincode = shopPincode;
        this.shopAddressLine1 = shopAddressLine1;
        this.shopAddressLine2 = shopAddressLine2;
        this.shopAddressLine3 = shopAddressLine3;
        this.shopPhoneNumber = shopPhoneNumber;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.userType = userType;
        this.gender = gender;
        this.status = status;
    }

    public RegisterShopDto() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getShopPincode() {
        return shopPincode;
    }

    public void setShopPincode(int shopPincode) {
        this.shopPincode = shopPincode;
    }

    public String getShopAddressLine1() {
        return shopAddressLine1;
    }

    public void setShopAddressLine1(String shopAddressLine1) {
        this.shopAddressLine1 = shopAddressLine1;
    }

    public String getShopAddressLine2() {
        return shopAddressLine2;
    }

    public void setShopAddressLine2(String shopAddressLine2) {
        this.shopAddressLine2 = shopAddressLine2;
    }

    public String getShopAddressLine3() {
        return shopAddressLine3;
    }

    public void setShopAddressLine3(String shopAddressLine3) {
        this.shopAddressLine3 = shopAddressLine3;
    }

    public Long getShopPhoneNumber() {
        return shopPhoneNumber;
    }

    public void setShopPhoneNumber(Long shopPhoneNumber) {
        this.shopPhoneNumber = shopPhoneNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
