package egycsegomegbelefer.lyrics.modell;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private String email; // optional
    private String picURL; // optional
    private LocalDate dateOfBirth; // optional
    private Rang rang;
    @OneToMany(mappedBy = "user")
    private Comment comment;
    @OneToMany(mappedBy = "user")
    private Lyrics lyrics;

    public User(String userName, String password, String email, String picURL, LocalDate dateOfBirth, Rang rang, Comment comment , Lyrics lyrics) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.picURL = picURL;
        this.dateOfBirth = dateOfBirth;
        this.rang = rang;
        this.comment = comment;
        this.lyrics = lyrics;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Lyrics getLyrics() {
        return lyrics;
    }

    public String getEmail() {
        return email;
    }

    public String getPicURL() {
        return picURL;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Rang getRang() {
        return rang;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", lyrics=" + lyrics + ", email=" + email + ", picURL=" + picURL + ", dateOfBirth=" + dateOfBirth + ", rang=" + rang + '}';
    }
}