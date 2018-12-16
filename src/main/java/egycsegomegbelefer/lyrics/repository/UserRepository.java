package egycsegomegbelefer.lyrics.repository;

import egycsegomegbelefer.lyrics.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(value="select * from user order by lyrics_counter desc limit 10",nativeQuery = true)
    List<User> findTop10();
}
