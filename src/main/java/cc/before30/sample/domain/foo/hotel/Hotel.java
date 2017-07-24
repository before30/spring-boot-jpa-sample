package cc.before30.sample.domain.foo.hotel;

import cc.before30.sample.domain.foo.review.Review;
import cc.before30.sample.domain.foo.city.City;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by before30 on 24/07/2017.
 */
@Entity
@Table(name = "hotels")
@Getter
@Setter
@EqualsAndHashCode
public class Hotel {

    @Id
    @SequenceGenerator(name="hotel_generator", sequenceName="hotel_sequence", initialValue = 28)
    @GeneratedValue(generator = "hotel_generator")
    private Long id;

    @ManyToOne(optional = false)
    @NaturalId
    private City city;

    @Column(nullable = false)
    @NaturalId
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String zip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private Set<Review> reviews;

    protected Hotel() {
    }

    public Hotel(City city, String name) {
        this.city = city;
        this.name = name;
    }
}
