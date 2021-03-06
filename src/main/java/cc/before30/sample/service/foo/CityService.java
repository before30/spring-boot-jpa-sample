package cc.before30.sample.service.foo;

import cc.before30.sample.domain.foo.city.City;
import cc.before30.sample.domain.foo.hotel.HotelSummary;
import cc.before30.sample.domain.foo.city.CitySearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by before30 on 24/07/2017.
 */
public interface CityService {

    Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

    City getCity(String name, String country);

    Page<HotelSummary> getHotels(City city, Pageable pageable);
}
