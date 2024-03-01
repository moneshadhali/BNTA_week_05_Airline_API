package com.example.airline_api.models;

import java.util.ArrayList;
import java.util.List;

public class BookingDTO {

    private List<Long> passengerID;

    public BookingDTO(List<Long> passengerID) {
        this.passengerID = passengerID;
    }

    public BookingDTO() {

    }

    public List<Long> getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(List<Long> passengerID) {
        this.passengerID = passengerID;
    }
}
