package org.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.time.LocalDate;

public class BookingData {
    @JsonProperty("startDate")
    public LocalDate startDate;
    @JsonProperty("endDate")
    public LocalDate endDate;

    @JsonProperty("selectedCar")
    public int selectedCar;

    @JsonProperty("selectedRoom")
    public int selectedRoom;

    public BookingData(){

    }

    public BookingData(LocalDate startDate, LocalDate endDate, int selectedCar, int selectedRoom) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.selectedCar = selectedCar;
        this.selectedRoom = selectedRoom;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(int selectedCar) {
        this.selectedCar = selectedCar;
    }

    public int getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(int selectedRoom) {
        this.selectedRoom = selectedRoom;
    }
}

