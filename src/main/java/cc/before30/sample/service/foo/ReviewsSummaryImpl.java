package cc.before30.sample.service.foo;

import cc.before30.sample.domain.foo.review.Rating;
import cc.before30.sample.domain.foo.review.RatingCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by before30 on 24/07/2017.
 */
public class ReviewsSummaryImpl implements ReviewsSummary {
    private final Map<Rating, Long> ratingCount;

    public ReviewsSummaryImpl(List<RatingCount> ratingCounts) {
        this.ratingCount = new HashMap<>();
        for (RatingCount ratingCount : ratingCounts) {
            this.ratingCount.put(ratingCount.getRating(), ratingCount.getCount());
        }
    }

    @Override
    public long getNumberOfReviewsWithRating(Rating rating) {
        Long count = this.ratingCount.get(rating);
        return count == null ? 0 : count;
    }
}
