//package com.kzaintree_backend.services;
//
//
//import com.kzaintree_backend.models.UserDetails;
//import com.kzaintree_backend.repository.UserDetailsRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.User;;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    final UserDetailsRepository userRepository;
//
//    public JwtUserDetailsService(UserDetailsRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        com.kzaintree_backend.models.UserDetails userDetails= userRepository.findByUsername(username);
//        return userDetails;
//    }
//}
