package com.neosoft.service;

import com.neosoft.model.country.CountryResponse;

import java.util.List;

public interface CountryService {
    List<CountryResponse> getCountryList();
}
