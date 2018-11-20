package egycsegomegbelefer.lyrics.modell;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        import java.time.LocalDate;
        import java.util.List;

/**
 *
 * @author marci
 */
public class User {

    private long id;
    private String userName;
    private String password;
    private List<Lyrics> lyrics;
    private String email; // optional
    private String picURL; // optional
    private LocalDate dateOfBirth; // optional
    private Rang rang;

    public User(long id, String userName, String password, List<Lyrics> lyrics, String email, String picURL, LocalDate dateOfBirth, Rang rang) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.lyrics = lyrics;
        this.email = email;
        this.picURL = picURL;
        this.dateOfBirth = dateOfBirth;
        this.rang = rang;
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

    public List<Lyrics> getLyrics() {
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

    public void setLyrics(List<Lyrics> lyrics) {
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