package com.scholorship.demo.controller;
import com.scholorship.demo.expection.ResourceNotFoundException;
import com.scholorship.demo.model.Signup;
import com.scholorship.demo.service.SignupService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scholorship.demo.repository.SignupRepository;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/signup")
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @GetMapping("/getsignup")
    public List<Signup> getAllAdmins() {

        return signupRepository.findAll();
    }

    // build create employee REST API
    @PostMapping("/addsignup")
    public Signup createSignup(@RequestBody Signup signup) {
        signup.setSignup_id(signupRepository.findMaxId() + 1);
        return signupRepository.save(signup);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Signup> getAdminById(@PathVariable int id) {
        Signup signup = signupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id:" + id));
        return ResponseEntity.ok(signup);
    }
//    public String existsByEmailandPassword(Signup signup) {
//        if (SignupRepository.existsByEmail(signup.getEmail()) > 0 ) {
//            if (SignupRepository.existsByPassword(signup.getEmail(),signup.getPassword()) > 0) {
//
//                List<Signup> user1 = SignupRepository.findByEmail(signup.getEmail());
//
//                System.out.println(user1.toString());
//
//                String[] strArray = user1.toString().split(",");
//                return "{ \"1\" : \"Logged in successfully\"}";
//            }
//            return "{ \"2\" : \"incorrect password\"}";
//        }
//        return "{ \"3\" : \"Email Id does not exist ;\"}" ;
//    }

    @Transactional
    @PostMapping("/login")
    public String signup(@RequestBody Signup signup) {
//         signup = signupRepository.findByEmail(String email)
//                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id:" + email));
        if (signupRepository.existsByEmail(signup.getEmail()) > 0 ) {
            if (signupRepository.existsByPassword(signup.getEmail(),signup.getPassword()) > 0) {

                List<Signup> user1 = signupRepository.findByEmail(signup.getEmail());

                System.out.println(user1.toString());

                String[] strArray = user1.toString().split(",");
                return "{ \"1\" : \"Logged in successfully\"}";
            }
            return "{ \"2\" : \"incorrect password\"}";
        }
        return "{ \"3\" : \"Email Id does not exist ;\"}" ;
    }


}
