package cc.before30.sample.repository.bar;

import cc.before30.sample.domain.bar.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by before30 on 24/07/2017.
 */
@Repository
public class JpaTagRepository implements TagRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tag> findAll() {
        return this.entityManager.createQuery("SELECT t FROM TAGS t", Tag.class)
                .getResultList();
    }
}
