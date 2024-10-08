package com.hsm.tourguideapp;

/**
 * Created by HSM on 26/3/2018.
 */

public class Cafe {
    private int cafeImage;
    private String cafeName;
    private String cafeAddress;
    private String cafeGeo;
    private String cafePhone;

    public Cafe(int cafeImage, String cafeName, String cafeAddress, String cafeGeo, String cafePhone) {
        this.cafeImage = cafeImage;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.cafeGeo = cafeGeo;
        this.cafePhone = cafePhone;
    }

    public int getCafeImage() {
        return cafeImage;
    }

    public String getCafeName() {
        return cafeName;
    }

    public String getCafeAddress() {
        return cafeAddress;
    }

    public String getCafeGeo() {
        return cafeGeo;
    }

    public String getCafePhone() {
        return cafePhone;
    }
}
