package cc.before30.sample.service.foo;

import cc.before30.sample.domain.foo.city.City;
import cc.before30.sample.domain.foo.hotel.Hotel;
import cc.before30.sample.domain.foo.review.Review;
import cc.before30.sample.domain.foo.review.ReviewDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by before30 on 24/07/2017.
 */
public interface HotelService {

    Hotel getHotel(City city, String name);

    Page<Review> getReviews(Hotel hotel, Pageable pageable);

    Review getReview(Hotel hotel, int index);

    Review addReview(Hotel hotel, ReviewDetails details);

    ReviewsSummary getReviewSummary(Hotel hotel);
}
