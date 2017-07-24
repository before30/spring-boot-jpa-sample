package cc.before30.sample.domain.foo.review;

import cc.before30.sample.domain.foo.hotel.Hotel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by before30 on 24/07/2017.
 */
@Entity
@Table(name = "reviews")
@Getter
@Setter
@EqualsAndHashCode
public class Review {
    @Id
    @SequenceGenerator(name="review_generator", sequenceName="review_sequence", initialValue = 64)
    @GeneratedValue(generator = "review_generator")
    private Long id;

    @ManyToOne(optional = false)
    private Hotel hotel;

    @Column(nullable = false, name = "idx")
    private int index;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkInDate;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TripType tripType;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String details;

    protected Review() {
    }

    public Review(Hotel hotel, int index, ReviewDetails details) {
        this.hotel = hotel;
        this.index = index;
        this.rating = details.getRating();
        this.checkInDate = details.getCheckInDate();
        this.tripType = details.getTripType();
        this.title = details.getTitle();
        this.details = details.getDetails();
    }
}
