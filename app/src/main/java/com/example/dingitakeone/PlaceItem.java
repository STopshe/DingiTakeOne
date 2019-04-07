package com.example.dingitakeone;

public class PlaceItem {
    private String placeName;
    private String placeAddress;

    public PlaceItem(String placeName, String placeAddress) {
        this.placeName = placeName;
        this.placeAddress = placeAddress;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }
}
