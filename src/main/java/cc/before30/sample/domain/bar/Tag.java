package cc.before30.sample.domain.bar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by before30 on 23/07/2017.
 */
@Entity
@Table(name = "tags")
@Getter
@Setter
@EqualsAndHashCode
public class Tag {
    @Id
    @SequenceGenerator(name = "tag_generator", sequenceName = "tag_sequence", initialValue = 4)
    @GeneratedValue(generator = "tag_generator")
    private long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Note> notes;
}

