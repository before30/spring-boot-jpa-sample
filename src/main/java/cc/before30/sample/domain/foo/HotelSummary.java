package cc.before30.sample.domain.foo;

/**
 * Created by before30 on 24/07/2017.
 */
public interface HotelSummary {
    City getCity();

    String getName();

    Double getAverageRating();

    default Integer getAverageRatingRounded() {
        return getAverageRating() == null ? null : (int) Math.round(getAverageRating());
    }

}
