package tech.gregori.springbootecommerce.db;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.gregori.springbootecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}