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
@Table(name = "notes")
@Getter
@Setter
@EqualsAndHashCode
public class Note {
    @Id
    @SequenceGenerator(name="note_generator", sequenceName="note_sequence", initialValue = 5)
    @GeneratedValue(generator = "note_generator")
    private long id;

    private String title;

    private String body;

    @ManyToMany
    private List<Tag> tags;

    public Note(String title, String body, List<Tag> tags) {
        this.title = title;
        this.body = body;
        this.tags = tags;
    }

    public Note() {
    }
}
