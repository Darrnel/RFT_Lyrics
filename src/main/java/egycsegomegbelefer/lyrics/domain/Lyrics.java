package egycsegomegbelefer.lyrics.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name="LYRICS_SEQ", sequenceName="lyrics_sequence", allocationSize = 1)
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="LYRICS_SEQ")
    @Column(name = "lyrics_id")
    private long id;

    private String author;
    private String album;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String lyricstext;

    private String activeRadio = "author";

    private String searchText;

    private int searchCounter;

    @ManyToOne
    private User user;

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    public String getLyricstext() {
        return lyricstext;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLyricstext(String lyrics) {
        this.lyricstext = lyrics;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getActiveRadio() {
        return activeRadio;
    }

    public void setActiveRadio(String activeRadio) {
        this.activeRadio = activeRadio;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int getSearchCounter() {
        return searchCounter;
    }

    public void setSearchCounter(int searchCounter) {
        this.searchCounter = searchCounter;
    }

    @Override
    public String toString() {
        return "Lyrics{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", album='" + album + '\'' +
                ", title='" + title + '\'' +
                ", lyricstext='" + lyricstext + '\'' +
                ", activeRadio='" + activeRadio + '\'' +
                ", searchText='" + searchText + '\'' +
                ", searchCounter=" + searchCounter +
                ", user=" + user +
                '}';
    }
}



