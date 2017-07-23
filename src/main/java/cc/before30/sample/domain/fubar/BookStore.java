package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by before30 on 23/07/2017.
 */
//@Entity
//@Table(name = "bookstoreas")
@Getter
@Setter
@EqualsAndHashCode
public class BookStore {
    String name;
}

/*
CREATE TABLE book_store (
  name VARCHAR(400) NOT NULL,

  CONSTRAINT uk_t_book_store_name PRIMARY KEY(name)
);

 */