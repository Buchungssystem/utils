package org.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AvailabilityData {
    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("sendRentalCar")
    private boolean sendRentalCar;

    @JsonProperty("sendHotel")
    private boolean sendHotel;

    public AvailabilityData(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AvailabilityData(LocalDate startDate, LocalDate endDate, boolean sendRentalCar, boolean sendHotel) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.sendRentalCar = sendRentalCar;
        this.sendHotel = sendHotel;
    }

    public AvailabilityData(){

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isSendRentalCar() {
        return sendRentalCar;
    }

    public boolean isSendHotel() {
        return sendHotel;
    }
}
