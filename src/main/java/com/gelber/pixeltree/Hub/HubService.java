package com.gelber.pixeltree.Hub;

import com.gelber.pixeltree._Model.EmailChangeToken;
import com.gelber.pixeltree._Model.User;
import com.gelber.pixeltree._Repository.EmailChangeTokenRepository;
import com.gelber.pixeltree._Repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HubService {

    private UserRepository userRepository;
    private EmailChangeTokenRepository emailChangeTokenRepository;
    private JavaMailSender javaMailSender;
    private PasswordEncoder passwordEncoder;

    public HubService(UserRepository userRepository,
                      EmailChangeTokenRepository emailChangeTokenRepository,
                      JavaMailSender javaMailSender,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailChangeTokenRepository = emailChangeTokenRepository;
        this.javaMailSender = javaMailSender;
        this.passwordEncoder = passwordEncoder;
    }

    public String changeUsername(User user, String username) {
        if (user.getUsername().equals(username)) {
            return "That is already your username";
        }

        if (username.length() < 6 || username.length() > 24) {
            return "Username must be between 6 and 24 characters";
        }

        User usernameHolder = userRepository.findByUsername(username);
        if (usernameHolder != null) {
            return "That username is taken";
        }

        user.setUsername(username);
        userRepository.save(user);
        return null;
    }

    @Transactional
    public String changeEmailToken(User user, String email) {
        if (email.equals(user.getEmail())) {
            return "This is already your email";
        }

        // Remove all of the user's old email tokens
        emailChangeTokenRepository.deleteAllByUser(user);

        // Make a new email token
        EmailChangeToken tok = new EmailChangeToken(user, email);
        emailChangeTokenRepository.save(tok);

        // Send the email to their current address for changing
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gelber.programming@gmail.com");
        message.setTo(email);
        message.setSubject("Confirm your Email Change");
        message.setText("Click the following link to confirm your email change:\n" +
                "http://localhost/hub/email/" + tok.getToken());
        javaMailSender.send(message);

        return null;
    }

    public void changeEmail(String token) {
        EmailChangeToken tok = emailChangeTokenRepository.findByToken(token);
        if (tok == null) return;

        User user = tok.getUser();
        user.setEmail(tok.getNewEmail());
        userRepository.save(user);

        emailChangeTokenRepository.delete(tok);
    }

    public String changePassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return null;
    }
}
