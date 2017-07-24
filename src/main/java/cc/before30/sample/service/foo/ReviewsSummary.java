package cc.before30.sample.service.foo;

import cc.before30.sample.domain.foo.review.Rating;

/**
 * Created by before30 on 24/07/2017.
 */
public interface ReviewsSummary {
    long getNumberOfReviewsWithRating(Rating rating);
}
