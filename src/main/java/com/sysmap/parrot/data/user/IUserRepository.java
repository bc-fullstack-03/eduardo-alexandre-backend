package com.sysmap.parrot.data.user;

import com.sysmap.parrot.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends MongoRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
}
