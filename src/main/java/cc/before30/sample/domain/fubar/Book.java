package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by before30 on 23/07/2017.
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@EqualsAndHashCode
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private Long authorId;

    private Long coAuthorId;

    private String title;
}

/*
CREATE TABLE book (
  id INT NOT NULL,
  author_id INT NOT NULL,
  co_author_id INT,
  title VARCHAR(400) NOT NULL,

  CONSTRAINT pk_t_book PRIMARY KEY (id),
  CONSTRAINT fk_t_book_author_id FOREIGN KEY (author_id) REFERENCES author(id),
  CONSTRAINT fk_t_book_co_author_id FOREIGN KEY (co_author_id) REFERENCES author(id)
);
 */