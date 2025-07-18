package note;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
    private Map<Long, Note> notes = new HashMap<>();
    private Long id = 0L;

    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note){
        note.setId(id);
        notes.put(id, note);
        id++;
        return note;
    }

    public void deleteById(long id){
        if (id > this.id){
            throw new IllegalArgumentException();
        }
        notes.remove(id);
    }

    public void update(Note note){
        notes.replace(note.getId(), note);
    }

    public Note getById(long id){
        if (id > this.id){
            throw new IllegalArgumentException();
        }
        return notes.get(id);
    }
}
