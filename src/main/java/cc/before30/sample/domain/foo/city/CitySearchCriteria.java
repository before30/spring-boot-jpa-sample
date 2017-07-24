package cc.before30.sample.domain.foo.city;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by before30 on 24/07/2017.
 */
@Setter
@Getter
public class CitySearchCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public CitySearchCriteria() {
    }

    public CitySearchCriteria(String name) {
        this.name = name;
    }
}
