package egycsegomegbelefer.lyrics.service;

import egycsegomegbelefer.lyrics.domain.Comment;
import egycsegomegbelefer.lyrics.repository.CommentRepository;
import egycsegomegbelefer.lyrics.repository.LyricsRepository;
import egycsegomegbelefer.lyrics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private LyricsRepository lyricsRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setLyricsRepository(LyricsRepository lyricsRepository){
        this.lyricsRepository = lyricsRepository;
    }

    /**
     * A commentRepository a CrudRepository kiterjesztése miatt, visszaadja az összes kommentet.
     * */
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }
}

