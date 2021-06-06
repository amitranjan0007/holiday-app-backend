package com.neosoft.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neosoft.model.holiday.HolidayItem;

import javax.persistence.*;
import java.util.List;
//https://www.youtube.com/watch?v=DQcnG2is0Ec&list=PL5mjp3QjkuoK0Et76tgeNWhqHofaKSULj&index=13
@Entity
@Table(name="holiday_tbl")
@JsonIgnoreProperties(ignoreUnknown=true)
public class HolidayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name="toDate")
    String toDate;
    @Column(name="fromDate")
    String fromDate;
    @Column(name="country")
    String country;
    @Column(name="region" )
    String region;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mholiday_item")
    List<HolidayItem> mHolidayItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
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

    public List<HolidayItem> getmHolidayItem() {
        return mHolidayItem;
    }

    public void setmHolidayItem(List<HolidayItem> mHolidayItem) {
        this.mHolidayItem = mHolidayItem;
    }
}
