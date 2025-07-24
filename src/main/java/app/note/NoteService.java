package app.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public List<Note> listAll(){
        return repository.findAll();
    }

    public Note add(Note note) {
        return repository.save(note);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public void update(Note note){
        repository.save(note);
    }

    public Note getById(long id){
        return repository.findById(id).orElse(null);
    }
}
