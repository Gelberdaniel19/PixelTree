package com.gelber.pixeltree.CreateAccount;

import com.gelber.pixeltree._Model.Role;
import com.gelber.pixeltree._Model.User;
import com.gelber.pixeltree._Model.UserRole;
import com.gelber.pixeltree._Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public CreateAccountService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void createAccount(String email, String username, String password) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.addRole(new UserRole(user, Role.TRIAL_USER));
        userRepository.save(user);
    }
}
