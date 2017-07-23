package cc.before30.sample.repository.foo;

import cc.before30.sample.domain.foo.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by before30 on 24/07/2017.
 */
public interface CityRepository extends Repository<City, Long> {

    Page<City> findAll(Pageable pageable);

    Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
                                                                       String country, Pageable pageable);

    City findByNameAndCountryAllIgnoringCase(String name, String country);

}