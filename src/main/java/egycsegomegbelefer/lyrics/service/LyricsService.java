package egycsegomegbelefer.lyrics.service;

import egycsegomegbelefer.lyrics.repository.CommentRepository;
import egycsegomegbelefer.lyrics.repository.LyricsRepository;
import egycsegomegbelefer.lyrics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LyricsService{

    private LyricsRepository lyricsRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    @Autowired
    public void setLyricsRepository(LyricsRepository lyricsRepository){
        this.lyricsRepository = lyricsRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

}

