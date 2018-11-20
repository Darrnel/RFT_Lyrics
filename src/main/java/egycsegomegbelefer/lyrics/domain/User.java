package egycsegomegbelefer.lyrics.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private List<Lyrics> lyrics;

    public User(){

    }

    public User(String userName, String password, String email, String picURL, LocalDate dateOfBirth, Rang rang, List<Lyrics> lyrics) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.picURL = picURL;
        this.dateOfBirth = dateOfBirth;
        this.rang = rang;
        this.lyrics = lyrics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }


    public List<Lyrics> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<Lyrics> lyrics) {
        this.lyrics = lyrics;
    }
}