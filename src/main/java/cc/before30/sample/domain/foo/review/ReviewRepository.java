package cc.before30.sample.domain.foo.review;

import cc.before30.sample.domain.foo.hotel.Hotel;
import cc.before30.sample.domain.foo.review.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by before30 on 24/07/2017.
 */
public interface ReviewRepository extends Repository<Review, Long> {

    Page<Review> findByHotel(Hotel hotel, Pageable pageable);

    Review findByHotelAndIndex(Hotel hotel, int index);

    Review save(Review review);

}