package egycsegomegbelefer.lyrics.repository;


import egycsegomegbelefer.lyrics.domain.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.List;
@Repository("lyricsRepository")
public interface LyricsRepository extends JpaRepository<Lyrics, Long> {

    /**
     * Vissza adja az összes dalszöveget egy listában,
     * ezt tudjuk rendezni a szerint amire van igény.
     * */

    @Query(value="SELECT * from lyrics where author=?",nativeQuery = true)
    Lyrics findByAuthor(String author);

    @Query(value="SELECT title from lyrics where title=?",nativeQuery = true)
    String findByTitle(String title);

    List<Lyrics> findAllByUserId(long id);

    //lyrics-list-test
    Lyrics findById(long id);


    @Query(value = "SELECT count(*) from lyrics where author=? and title=?",nativeQuery = true)
    int findByAuthorAndTitle(String author, String title);

}

