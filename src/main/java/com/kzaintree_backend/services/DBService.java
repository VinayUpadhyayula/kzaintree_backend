package com.kzaintree_backend.services;

import com.kzaintree_backend.models.UserDetails;
import com.kzaintree_backend.models.UserItems;
import com.kzaintree_backend.repository.UserDetailsRepository;
import com.kzaintree_backend.repository.UserItemsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class DBService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserItemsRepository userItemsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public UserDetails login(String username)
    {
        return userDetailsRepository.findByUsername(username);
    }
    public void create(UserDetails user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsRepository.save(user);
    }
    public Optional<UserItems> fetch(String username)
    {
        System.out.println("Username is {}"+username);
        UserDetails userDetails = userDetailsRepository.findByUsername(username);
        System.out.println(userDetails.getId());
        if(null != userDetails)
        {
            //return Optional.ofNullable(userItemsRepository.findAll());
            //return Optional.ofNullable(userItemsRepository.findBy({"username": ObjectId(userDetails.getId())}));
            String id = userDetails.getId();
            ObjectId objectId = new ObjectId(id);
            AggregationOperation match = match(Criteria.where("username").is(objectId));
            AggregationOperation lookup = lookup("Items", "items", "_id", "items");

            Aggregation aggregation = newAggregation(match, lookup);

            AggregationResults<UserItems> result = mongoTemplate.aggregate(aggregation, "UserItems", UserItems.class);
            System.out.println(result.getUniqueMappedResult());
            return Optional.ofNullable(result.getUniqueMappedResult());
          //return Optional.ofNullable(userItemsRepository.findByUsername(new ObjectId(userDetails.getId())));
        }
        return null;
    }
}
