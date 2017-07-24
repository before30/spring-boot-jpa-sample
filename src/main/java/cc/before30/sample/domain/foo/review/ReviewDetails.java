package cc.before30.sample.domain.foo.review;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * Created by before30 on 24/07/2017.
 */
@Getter
@Setter
public class ReviewDetails {
    private Rating rating;

    private Date checkInDate;

    private TripType tripType;

    private String title;

    private String details;

    public ReviewDetails() {
    }
}
