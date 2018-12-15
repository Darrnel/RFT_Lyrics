package egycsegomegbelefer.lyrics.repository;


import egycsegomegbelefer.lyrics.domain.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("lyricsRepository")
public interface LyricsRepository extends JpaRepository<Lyrics, Long> {

    /**
     * Vissza adja az összes dalszöveget egy listában,
     * ezt tudjuk rendezni a szerint amire van igény.
     * */

    @Query(value="SELECT * from lyrics where author=?",nativeQuery = true)
    Lyrics findByAuthor(String author);

    @Query(value="SELECT * from lyrics where title=?",nativeQuery = true)
    Lyrics findByTitle(String title);

    @Query(value="SELECT * from lyrics where lyricstext like %?% ",nativeQuery = true)
    Lyrics findByLyricstext(String lyricstext);

    List<Lyrics> findAllByUserId(long id);

    //lyrics-list-test
    Lyrics findById(long id);

    @Query(value="select * from lyrics where author = ? LIMIT 10" , nativeQuery = true)
    List<Lyrics> findByAuthorList(String author);

    @Query(value = "SELECT * FROM lyrics WHERE title = ? LIMIT 10",nativeQuery = true)
    List<Lyrics> findByTitleList(String title);

    @Query(value = "SELECT * FROM lyrics WHERE lyricstext LIKE %?% LIMIT 10",nativeQuery = true)
    List<Lyrics> findByLyricstextList(String lyrics);


    @Query(value = "SELECT count(*) from lyrics where author=? and title=?",nativeQuery = true)
    int findByAuthorAndTitle(String author, String title);

}

