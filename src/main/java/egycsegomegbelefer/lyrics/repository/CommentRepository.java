package egycsegomegbelefer.lyrics.repository;


import egycsegomegbelefer.lyrics.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    /**
     * Vissza adja az összes kommentet egy listában,
     * ezt hozzá tudjuk rendelni dalszöveghez.
     * */
    @Override
    List<Comment> findAll();
}

