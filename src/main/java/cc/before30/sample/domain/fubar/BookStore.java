package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by before30 on 23/07/2017.
 */
@Entity
@Table(name = "book_store")
@Getter
@Setter
@EqualsAndHashCode
public class BookStore {

    @Id
    @Column(name = "name")
    private String name;
}
