package com.neosoft.service;

import com.neosoft.model.country.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<CountryResponse> getCountryList() {
        try{
            String apiurl = "https://kayaposoft.com/enrico/json/v2.0?action=getSupportedCountries";

            ResponseEntity<List<CountryResponse>> holidayResponse =
                    restTemplate.exchange(apiurl,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<CountryResponse>>() {
                            });

            return holidayResponse.getBody();
        }catch (Exception e){
            throw e;
        }
    }
}
