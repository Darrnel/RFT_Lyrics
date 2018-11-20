package egycsegomegbelefer.lyrics.modell;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity;

/**
 *
 * @author marci
 */
@Entity
public class Lyrics {

    private long id;
    private String author;
    private String album;
    private String title;
    private String genre;
    private String lyrics;
    private String uploaderID;
    private int voteCounter;

    public Lyrics(long id, String author, String album, String title, String genre, String lyrics, String uploaderID, int voteCounter) {
        this.id = id;
        this.author = author;
        this.album = album;
        this.title = title;
        this.genre = genre;
        this.lyrics = lyrics;
        this.uploaderID = uploaderID;
        this.voteCounter = voteCounter;
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

    public String getUploaderID() {
        return uploaderID;
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

    public void setUploaderID(String uploaderID) {
        this.uploaderID = uploaderID;
    }

    public void setVoteCounter(int voteCounter) {
        this.voteCounter = voteCounter;
    }

    @Override
    public String toString() {
        return "Lyrics{" + "id=" + id + ", author=" + author + ", album=" + album + ", title=" + title + ", genre=" + genre + ", lyrics=" + lyrics + ", uploaderID=" + uploaderID + ", voteCounter=" + voteCounter + '}';
    }



}
