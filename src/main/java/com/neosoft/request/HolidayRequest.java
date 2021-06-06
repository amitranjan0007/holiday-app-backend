package com.neosoft.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class HolidayRequest {
    @NotNull(message = "fromDate is mandatory")
    @NotEmpty(message="fromDate is mandatory")
    String fromDate;

    @NotNull(message = "toDate is mandatory")
    @NotEmpty(message="toDate is mandatory")
    String toDate;

    @NotNull(message = "country is mandatory")
    @NotEmpty(message="country is mandatory")
    String country;

    String region;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
