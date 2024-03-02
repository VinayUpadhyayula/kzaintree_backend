package com.kzaintree_backend.repository;

import com.kzaintree_backend.models.UserDetails;
import com.kzaintree_backend.models.UserItems;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserItemsRepository extends MongoRepository<UserItems,String> {
    UserItems findByUsername(ObjectId username);
}
