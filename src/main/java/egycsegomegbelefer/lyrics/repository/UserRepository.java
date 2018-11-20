package egycsegomegbelefer.lyrics.repository;

import egycsegomegbelefer.lyrics.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
}
