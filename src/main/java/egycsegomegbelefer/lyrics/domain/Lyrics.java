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
@SequenceGenerator(name="LYRICS_SEQ", sequenceName="lyrics_sequence")
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="LYRICS_SEQ")
    @Column(name = "lyrics_id")
    private long id;

    private String author;
    private String album;
    private String title;

    //@Column(columnDefinition = "TEXT")
    private String lyricstext;

    private int voteCounter;

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

    public int getVoteCounter() {
        return voteCounter;
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

    public void setVoteCounter(int voteCounter) {
        this.voteCounter = voteCounter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}



