package com.gelber.pixeltree._Repository;

import com.gelber.pixeltree._Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}