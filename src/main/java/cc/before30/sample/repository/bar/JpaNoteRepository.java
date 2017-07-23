package cc.before30.sample.repository.bar;

import cc.before30.sample.domain.bar.Note;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by before30 on 24/07/2017.
 */
@Repository
class JpaNoteRepository implements NoteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Note> findAll() {
        return this.entityManager.createQuery("SELECT n FROM Note n", Note.class)
                .getResultList();
    }

}