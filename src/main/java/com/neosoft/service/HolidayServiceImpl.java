package com.neosoft.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.entity.HolidayEntity;
import com.neosoft.model.holiday.Date;
import com.neosoft.model.holiday.HolidayItem;
import com.neosoft.model.holiday.Name;
import com.neosoft.repo.HolidayRepository;
import com.neosoft.request.HolidayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HolidayRepository holidayRepository;

    ObjectMapper mapper;

    @Override
    public List<HolidayItem> getHolidayList(HolidayRequest holidayRequest) throws Exception {
        try{
            HttpHeaders headers = new HttpHeaders();
            //headers.set("auth-token", authToken);
           // HttpEntity<Object> request = new HttpEntity<>(headers);
            List<HolidayEntity> holidayItemList=holidayRepository.findByCountryAndFromDateAndToDateAndRegion(holidayRequest.getCountry(),holidayRequest.getFromDate(),holidayRequest.getToDate(),holidayRequest.getRegion());
            if(holidayItemList!=null && holidayItemList.size()>0){
                List<HolidayItem> holidayItems = holidayItemList.get(0).getmHolidayItem();
                System.out.println(holidayItems.get(0).getName().get(0).getLang());

                return holidayItems;
            }
            String apiurl = "https://kayaposoft.com/enrico/json/v2.0?action=getHolidaysForDateRange&fromDate="+holidayRequest.getFromDate()+"&toDate="+holidayRequest.getToDate()+"&country="+holidayRequest.getCountry()+"&region="+holidayRequest.getRegion()+"&holidayType=public_holiday";

            ResponseEntity<List<HolidayItem>> holidayResponse =
                    restTemplate.exchange(apiurl,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<HolidayItem>>() {
                            });

            HolidayEntity holidayEntity=new HolidayEntity();
            holidayEntity.setFromDate(holidayRequest.getFromDate());
            holidayEntity.setToDate(holidayRequest.getToDate());
            holidayEntity.setRegion(holidayRequest.getRegion());
            holidayEntity.setCountry(holidayRequest.getCountry());
            holidayEntity.setmHolidayItem(holidayResponse.getBody());
            holidayRepository.save(holidayEntity);

            return holidayResponse.getBody();
        }catch (Exception e){
            throw e;
        }

    }


}
