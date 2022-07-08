package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository<T> extends MongoRepository<User, Long>{
	

	@Query("{ 'email' : ?0 }")
	User findByEmailQualquerCoisa(String email);
	
	User findByNameIgnoreCaseLike(String name);

}
