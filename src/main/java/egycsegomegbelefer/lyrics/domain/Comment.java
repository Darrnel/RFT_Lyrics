package egycsegomegbelefer.lyrics.domain;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Lyrics lyrics;

    public Comment(User user, Lyrics lyrics){
        this.user = user;
        this.lyrics = lyrics;
    }

    public User getUser() {
        return user;
    }

    public Lyrics getLyrics() {
        return lyrics;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
    }
}

