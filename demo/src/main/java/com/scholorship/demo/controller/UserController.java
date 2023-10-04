
package com.scholorship.demo.controller;
import com.scholorship.demo.expection.ResourceNotFoundException;
import com.scholorship.demo.model.User;
import com.scholorship.demo.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scholorship.demo.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    FileSto storageService;

    @GetMapping("/getUser")
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public User createAdmin(@RequestBody User user) {
        user.setUser_Id(userRepository.findMaxId() + 1);
        return userRepository.save(user);
    }

    @PostMapping(value = "/upload")
    public User uploadFile(@RequestBody User user) {
        return userRepository.save(user);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getAdminById(@PathVariable int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/PutUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));

        updateUser.setApplication_status(userDetails.getApplication_status());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }
//SignupRepository.existsByEmail(signup.getEmail()) > 0

    @PostMapping("/findmark")
    public String findmark(User users) {
        if ((users.getTwelth_mark ()> 500 )&& (Objects.equals(users.getParent(), "parent"))) {
            return "{ \"1\" : \"Eligible for scholarship\"}";

        }
            else if ((users.getTwelth_mark ()> 450) && (Objects.equals(users.getParent(), "single"))) {
            return "{ \"1\" : \"Eligible for scholarship\"}";
        }
               else if ((users.getTwelth_mark ()> 400) && (Objects.equals(users.getParent(), "orphan"))) {
            return "{ \"1\" : \"Eligible for scholarship\"}";
        }


        else

    {
        return "{ \"2\" : \"not eligible for scholarship\"}";
    }


    }
}
