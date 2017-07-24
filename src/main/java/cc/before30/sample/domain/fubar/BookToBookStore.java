package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by before30 on 24/07/2017.
 */
@Entity
@Table(name = "book_to_book_store")
@Getter
@Setter
@EqualsAndHashCode
@IdClass(BookToBookStorePrimaryKey.class)
public class BookToBookStore {

    @Id
    @ManyToOne
    @JoinColumn(name = "book_store_name")
    private BookStore bookStoreName;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @Column
    private Integer stock;

}
