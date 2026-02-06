package com.math_dev.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.math_dev.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
