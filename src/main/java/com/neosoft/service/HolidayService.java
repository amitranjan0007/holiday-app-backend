package com.neosoft.service;

import com.neosoft.entity.HolidayEntity;
import com.neosoft.model.holiday.HolidayItem;
import com.neosoft.request.HolidayRequest;

import java.util.List;

public interface HolidayService {
    List<HolidayItem> getHolidayList(HolidayRequest holidayRequest) throws Exception;
}
