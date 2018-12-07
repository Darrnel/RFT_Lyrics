package egycsegomegbelefer.lyrics.repository;


import egycsegomegbelefer.lyrics.domain.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sun.awt.SunHints;

import java.util.List;

public interface LyricsRepository extends JpaRepository<Lyrics, Long> {

    /**
     * Vissza adja az összes dalszöveget egy listában,
     * ezt tudjuk rendezni a szerint amire van igény.
     * */
    @Override
    List<Lyrics> findAll();

    @Query(value="SELECT author from lyrics where author=?",nativeQuery = true)
    String findByAuthor(String author);

    @Query(value="SELECT title from lyrics where title=?",nativeQuery = true)
    String findByTitle(String title);


    @Query(value = "SELECT count(*) from lyrics where author=? and title=?",nativeQuery = true)
    int findByAuthorAndTitle(String author, String title);

}

