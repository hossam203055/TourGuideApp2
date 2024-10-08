package com.hsm.tourguideapp;

/**
 * Created by HSM on 26/3/2018.
 */

public class Hospital {
    private int hospitalImage;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalGeo;
    private String hospitalPhone;

    public Hospital(int hospitalImage, String hospitalName, String hospitalAddress, String hospitalGeo, String hospitalPhone) {
        this.hospitalImage = hospitalImage;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.hospitalGeo = hospitalGeo;
        this.hospitalPhone = hospitalPhone;
    }

    public int getHospitalImage() {
        return hospitalImage;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public String getHospitalGeo() {
        return hospitalGeo;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }
}
