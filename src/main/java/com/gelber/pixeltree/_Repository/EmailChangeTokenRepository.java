package com.gelber.pixeltree._Repository;

import com.gelber.pixeltree._Model.EmailChangeToken;
import com.gelber.pixeltree._Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailChangeTokenRepository extends JpaRepository<EmailChangeToken, Integer> {
    void deleteAllByUser(User user);
    void deleteAllByToken(String token);
    EmailChangeToken findByToken(String token);
}
