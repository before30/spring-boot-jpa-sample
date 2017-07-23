package cc.before30.sample.repository.bar;

import cc.before30.sample.domain.bar.Tag;

import java.util.List;

/**
 * Created by before30 on 24/07/2017.
 */
public interface TagRepository {
    List<Tag> findAll();
}
