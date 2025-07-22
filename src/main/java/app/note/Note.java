package app.note;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Note {
    private Long id;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
