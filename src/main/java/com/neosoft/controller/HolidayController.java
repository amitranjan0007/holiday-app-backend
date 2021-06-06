package com.neosoft.controller;

import com.neosoft.model.country.CountryResponse;
import com.neosoft.model.holiday.HolidayItem;
import com.neosoft.request.HolidayRequest;
import com.neosoft.service.CountryService;
import com.neosoft.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HolidayController {


    @Autowired
    private HolidayService holidayService;

    @Autowired
    private CountryService countryService;

    @CrossOrigin
    @PostMapping("/api/posts/getHolidayList")
    public ResponseEntity getHolidays(@RequestBody HolidayRequest holidayRequest){
        List<HolidayItem> responseObj=null;
        HttpHeaders headers = new HttpHeaders();
        try {
            responseObj=holidayService.getHolidayList(holidayRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(200).body(responseObj);
    }

    @CrossOrigin
    @GetMapping("/api/posts/getCountry")
    public ResponseEntity getCountryList(){
        List<CountryResponse> responseObj=null;
        try {
            responseObj=countryService.getCountryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(200).body(responseObj);
    }
}
