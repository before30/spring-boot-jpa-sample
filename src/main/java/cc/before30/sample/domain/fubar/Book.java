package cc.before30.sample.domain.fubar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by before30 on 23/07/2017.
 */
@Entity
@Table(name = "book")
@Getter
@Setter
@EqualsAndHashCode
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable=false, updatable=false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "coauthor_id", insertable=false, updatable=false)
    private Author coAuthor;
}
