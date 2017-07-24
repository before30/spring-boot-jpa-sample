package cc.before30.sample.domain.foo.city;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by before30 on 24/07/2017.
 */
@Entity
@Table(name = "cities")
@Getter
@Setter
@EqualsAndHashCode
public class City {
    @Id
    @SequenceGenerator(name="city_generator", sequenceName="city_sequence", initialValue = 23)
    @GeneratedValue(generator = "city_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String map;

    protected City() {
    }

    public City(String name, String country) {
        super();
        this.name = name;
        this.country = country;
    }
}
