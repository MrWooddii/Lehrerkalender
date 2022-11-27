package com.keeper.lehrerkalender.persistence.daos;

import com.keeper.lehrerkalender.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByEmail(String email);

    public boolean existsByEmailIsLike(String email);

    public boolean existsByUsernameIsLike(String username);
}
