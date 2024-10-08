package com.hsm.tourguideapp;

/**
 * Created by HSM on 26/3/2018.
 */

public class Restaurant {
    private int restaurantImage;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantGeo;
    private String restaurantPhone;

    public Restaurant(int restaurantImage, String restaurantName, String restaurantAddress, String restaurantGeo, String restaurantPhone) {
        this.restaurantImage = restaurantImage;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantGeo = restaurantGeo;
        this.restaurantPhone = restaurantPhone;
    }

    public int getRestaurantImage() {
        return restaurantImage;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public String getRestaurantGeo() {
        return restaurantGeo;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }
}
