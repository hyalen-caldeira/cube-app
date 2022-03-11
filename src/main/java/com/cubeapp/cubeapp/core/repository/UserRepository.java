package com.cubeapp.cubeapp.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cubeapp.cubeapp.model.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, Long> {
    Optional<UserModel> findByName(String name);
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByNameOrEmail(String name, String email);
    List<UserModel> findByIdIn(List<Long> userIds);

    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
