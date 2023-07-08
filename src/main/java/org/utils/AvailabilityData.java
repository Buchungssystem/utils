package org.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AvailabilityData {
    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    public AvailabilityData(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AvailabilityData(){

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
