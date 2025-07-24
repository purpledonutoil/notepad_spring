package app.controller;

import app.note.Note;
import app.note.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    private final Map<Long, Note> noteStorage = new LinkedHashMap<>();
    private long nextId = 1;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note-list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam(required = false) Long id, Model model) {
        Note note = id != null ? noteService.getById(id) : new Note();
        model.addAttribute("note", note);
        return "note-edit";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute Note note) {
        if (note.getId() == null) {
            noteService.add(note);
        } else {
            noteService.update(note);
        }
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());
        return "note-edit";
    }
}
