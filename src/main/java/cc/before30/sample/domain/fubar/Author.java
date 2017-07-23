package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by before30 on 23/07/2017.
 */
@Entity
@Table(name = "authors")
@Getter
@Setter
@EqualsAndHashCode
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private Integer yearOfBirth;

    private String address;

    public Author(String firstName, String lastName, Date dateOfBirth, int yearOfBirth, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public Author() {
    }
}

/*
CREATE TABLE author (
  id INT NOT NULL,
  first_name VARCHAR(50),
  last_name VARCHAR(50) NOT NULL,
  date_of_birth DATE,
  year_of_birth INT,
  address VARCHAR(50),

  CONSTRAINT pk_t_author PRIMARY KEY (ID)
);
 */