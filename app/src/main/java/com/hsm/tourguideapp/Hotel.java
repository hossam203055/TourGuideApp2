package com.hsm.tourguideapp;

/**
 * Created by HSM on 17/3/2018.
 */

public class Hotel {
    private int hotelImage;
    private String hotelName;
    private String hotelAddress;
    private String hotelGeo;
    private float hotelCostPerDay;
    private int hotelNumStars;
    private String hotelPhone;

    public Hotel(int hotelImage, String hotelName, String hotelAddress, String hotelGeo, float hotelCostPerDay, int hotelNumStars, String hotelPhone) {
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelGeo = hotelGeo;
        this.hotelCostPerDay = hotelCostPerDay;
        this.hotelNumStars = hotelNumStars;
        this.hotelPhone = hotelPhone;
    }

    public int getHotelImage() {
        return hotelImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getHotelGeo() {
        return hotelGeo;
    }

    public float getHotelCostPerDay() {
        return hotelCostPerDay;
    }

    public int getHotelNumStars() {
        return hotelNumStars;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

}
