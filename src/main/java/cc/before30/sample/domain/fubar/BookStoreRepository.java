package cc.before30.sample.domain.fubar;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by before30 on 24/07/2017.
 */
public interface BookStoreRepository extends CrudRepository<BookToBookStore, BookToBookStorePrimaryKey> {
    List<BookToBookStore> findAll();
}
