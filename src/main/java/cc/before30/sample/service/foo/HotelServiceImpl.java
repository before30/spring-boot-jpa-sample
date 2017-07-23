package cc.before30.sample.service.foo;

import cc.before30.sample.domain.foo.*;
import cc.before30.sample.repository.foo.HotelRepository;
import cc.before30.sample.repository.foo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by before30 on 24/07/2017.
 */
@Component("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Hotel getHotel(City city, String name) {
        Assert.notNull(city, "City must not be null");
        Assert.hasLength(name, "Name must not be empty");
        return this.hotelRepository.findByCityAndName(city, name);
    }

    @Override
    public Page<Review> getReviews(Hotel hotel, Pageable pageable) {
        Assert.notNull(hotel, "Hotel must not be null");
        return this.reviewRepository.findByHotel(hotel, pageable);
    }

    @Override
    public Review getReview(Hotel hotel, int reviewNumber) {
        Assert.notNull(hotel, "Hotel must not be null");
        return this.reviewRepository.findByHotelAndIndex(hotel, reviewNumber);
    }

    @Override
    public Review addReview(Hotel hotel, ReviewDetails details) {
        Review review = new Review(hotel, 1, details);
        return this.reviewRepository.save(review);
    }

    @Override
    public ReviewsSummary getReviewSummary(Hotel hotel) {
        List<RatingCount> ratingCounts = this.hotelRepository.findRatingCounts(hotel);
        return new ReviewsSummaryImpl(ratingCounts);
    }
}