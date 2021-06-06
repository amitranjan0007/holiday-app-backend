package com.neosoft.repo;

import com.neosoft.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface HolidayRepository extends JpaRepository<HolidayEntity,Integer> {
    List<HolidayEntity> findByCountryAndFromDateAndToDateAndRegion(String country,String fromDate,String toDate,String region);
}
