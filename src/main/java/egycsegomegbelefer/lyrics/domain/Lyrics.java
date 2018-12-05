package egycsegomegbelefer.lyrics.domain;

import javax.persistence.*;

@Entity
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String author;
    private String album;
    private String title;
    private String genre;
    private String lyrics;
    private int voteCounter;
    @ManyToOne
    private User user;

    public Lyrics(){
    }

    public Lyrics(String author, String album, String title, String genre, String lyrics, String uploaderID, int voteCounter, User user) {
        this.author = author;
        this.album = album;
        this.title = title;
        this.genre = genre;
        this.lyrics = lyrics;
        this.voteCounter = voteCounter;
        this.user = user;
    }

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

    public String getGenre() {
        return genre;
    }

    public String getLyrics() {
        return lyrics;
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public void setVoteCounter(int voteCounter) {
        this.voteCounter = voteCounter;
    }

    @Override
    public String toString() {
        return "Lyrics{" + "id=" + id + ", author=" + author + ", album=" + album + ", title=" + title + ", genre=" + genre + ", lyrics=" + lyrics + ", voteCounter=" + voteCounter + "user: " + user.getUserName() +'}';
    }
}



