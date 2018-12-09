package egycsegomegbelefer.lyrics.service;

import egycsegomegbelefer.lyrics.domain.Lyrics;

import egycsegomegbelefer.lyrics.repository.LyricsRepository;
import egycsegomegbelefer.lyrics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LyricsService{

    private LyricsRepository lyricsRepository;

    @Autowired
    public void setLyricsRepository(LyricsRepository lyricsRepository){
        this.lyricsRepository = lyricsRepository;
    }

    public boolean isLyricsExists(String author, String title){
        return lyricsRepository.findByAuthorAndTitle(author,title) == 1 ? true : false;
    }

    public List<Lyrics> findAllLyricsByUserId(long id){
        return lyricsRepository.findAllByUserId(id);
    }

    public Lyrics saveLyrics(Lyrics lyrics){

        return lyricsRepository.save(lyrics);
    }
    /*public void saveLyrics(Lyrics lyrics) {
        lyricsRepository.save(lyrics);
    }*/

}

