package com.kzaintree_backend.controller;

import com.kzaintree_backend.models.UserDetails;
import com.kzaintree_backend.models.UserItems;
import com.kzaintree_backend.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin()
public class APIController {
    @Autowired
    private DBService dbService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDetails body)
    {
        System.out.println("reached");
        return new ResponseEntity<>(dbService.login(body.getUsername()),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDetails body)
    {
        System.out.println("reached create");
        dbService.create(body);
        return new ResponseEntity<>("Account registration successful",HttpStatus.OK);
    }
    @GetMapping("/fetch_items")
    public ResponseEntity<?> fetch_items(@RequestParam String username)
    {
        Optional<UserItems> userItems= dbService.fetch(username);
        if(null == userItems)
        {
            String resp_msg = "User: "+username+" not found.";
            return new ResponseEntity<>(resp_msg, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(userItems, HttpStatus.OK);
        }
    }
}
