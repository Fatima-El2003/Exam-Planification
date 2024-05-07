//package com.ensah.examplan.Config;
//
//import com.ensah.examplan.model.Enseignant;
//import com.ensah.examplan.repository.EnseignantRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//@Configuration
//public class OurUserInfoUserDetailsService implements UserDetailsService {
//    @Autowired
//    private EnseignantRepository enseignantRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Enseignant> user = enseignantRepo.findByEmail(username);
//        return user.map(OurUserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
//    }
//}