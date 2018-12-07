package egycsegomegbelefer.lyrics.service;

import egycsegomegbelefer.lyrics.domain.Lyrics;
import egycsegomegbelefer.lyrics.domain.Role;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.repository.LyricsRepository;
import egycsegomegbelefer.lyrics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class LyricsService{

    private LyricsRepository lyricsRepository;
    private UserRepository userRepository;

    @Autowired
    public void setLyricsRepository(LyricsRepository lyricsRepository){
        this.lyricsRepository = lyricsRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public boolean isLyricsExists(String author, String title){
        return lyricsRepository.findByAuthorAndTitle(author,title) == 1 ? true : false;
    }

    public void saveLyrics(Lyrics lyrics) {
        lyricsRepository.save(lyrics);
    }

}

