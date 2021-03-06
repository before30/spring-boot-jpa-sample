package cc.before30.sample.service.foo;

import cc.before30.sample.domain.foo.city.City;
import cc.before30.sample.domain.foo.hotel.HotelSummary;
import cc.before30.sample.domain.foo.city.CityRepository;
import cc.before30.sample.domain.foo.city.CitySearchCriteria;
import cc.before30.sample.domain.foo.hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Created by before30 on 24/07/2017.
 */
@Component("cityService")
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Page<City> findCities(CitySearchCriteria criteria, Pageable pageable) {

        Assert.notNull(criteria, "Criteria must not be null");
        String name = criteria.getName();

        if (!StringUtils.hasLength(name)) {
            return this.cityRepository.findAll(null);
        }

        String country = "";
        int splitPos = name.lastIndexOf(",");

        if (splitPos >= 0) {
            country = name.substring(splitPos + 1);
            name = name.substring(0, splitPos);
        }

        return this.cityRepository
                .findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(),
                        country.trim(), pageable);
    }

    @Override
    public City getCity(String name, String country) {
        Assert.notNull(name, "Name must not be null");
        Assert.notNull(country, "Country must not be null");
        return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
    }

    @Override
    public Page<HotelSummary> getHotels(City city, Pageable pageable) {
        Assert.notNull(city, "City must not be null");
        return this.hotelRepository.findByCity(city, pageable);
    }

}
