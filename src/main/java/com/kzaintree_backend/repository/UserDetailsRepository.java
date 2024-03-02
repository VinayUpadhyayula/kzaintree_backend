package com.kzaintree_backend.repository;

import com.kzaintree_backend.models.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails,String> {
    UserDetails findByUsername(String username);
}
