package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by before30 on 23/07/2017.
 */
@Entity
@Table(name = "author")
@Getter
@Setter
@EqualsAndHashCode
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy="author", fetch = FetchType.EAGER)
    private List<Book> book;


}
