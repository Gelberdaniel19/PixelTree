package com.gelber.pixeltree;

import com.gelber.pixeltree._Model.Role;
import com.gelber.pixeltree._Model.User;
import com.gelber.pixeltree._Model.UserRole;
import com.gelber.pixeltree._Repository.EmailChangeTokenRepository;
import com.gelber.pixeltree._Repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FillDatabase implements CommandLineRunner {
    private UserRepository userRepository;
    private EmailChangeTokenRepository emailChangeTokenRepository;
    private PasswordEncoder passwordEncoder;

    @Value("${pixeltree.generateDummyAdmin}")
    private boolean generateDummyAdmin;

    public FillDatabase(UserRepository userRepository,
                        EmailChangeTokenRepository emailChangeTokenRepository,
                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailChangeTokenRepository = emailChangeTokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (generateDummyAdmin) {
            emailChangeTokenRepository.deleteAll();
            userRepository.deleteAll();

            User user = new User();
            user.setEmail("admin@pixeltree.com");
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("password"));
            user.setVerified(true);
            List<UserRole> roleList = new ArrayList<>();
            roleList.add(new UserRole(user, Role.ADMIN));
            user.setRoleList(roleList);
            userRepository.save(user);
        }
    }
}
