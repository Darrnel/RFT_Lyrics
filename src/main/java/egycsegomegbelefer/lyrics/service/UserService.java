package egycsegomegbelefer.lyrics.service;

import egycsegomegbelefer.lyrics.domain.Rang;
import egycsegomegbelefer.lyrics.domain.Role;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.repository.LyricsRepository;
import egycsegomegbelefer.lyrics.repository.RoleRepository;
import egycsegomegbelefer.lyrics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private LyricsRepository lyricsRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setLyricsRepository(LyricsRepository lyricsRepository){
        this.lyricsRepository = lyricsRepository;
    }

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public User incRang(User user){

        if(user.getRang() == Rang.UJONC)
            user.setRang(Rang.KEZDO);
        else if(user.getRang() == Rang.KEZDO)
            user.setRang(Rang.TAPASZTALT);
        else if(user.getRang() == Rang.TAPASZTALT)
            user.setRang(Rang.LEGJOBB);
        else
            user.setRang(Rang.GOD);

        return user;
    }

    public boolean isLevelUp(User user){
        if(user.getLyricsCounter()+1 == 10 || user.getLyricsCounter()+1 == 30 || user.getLyricsCounter()+1 == 50 || user.getLyricsCounter()+1 == 70)
            return true;
        else
            return false;
    }
}


