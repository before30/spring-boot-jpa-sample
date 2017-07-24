package cc.before30.sample.domain.bar;

import cc.before30.sample.domain.bar.Note;

import java.util.List;

/**
 * Created by before30 on 24/07/2017.
 */
public interface NoteRepository {
    List<Note> findAll();
}
