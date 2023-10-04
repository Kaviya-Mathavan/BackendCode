package com.scholorship.demo.controller;
import com.scholorship.demo.expection.ResourceNotFoundException;
import com.scholorship.demo.model.Admins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scholorship.demo.repository.AdminRepository;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/getAdmins")
    public List<Admins> getAllAdmins(){

        return adminRepository.findAll();
    }

    // build create employee REST API
    @PostMapping("/addAdmin")
    public Admins createAdmin(@RequestBody Admins admins) {
        admins.setAdmin_Id(adminRepository.findMaxId()+1);
        return adminRepository.save(admins);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Admins> getAdminById(@PathVariable  int id){
        Admins admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id:" + id));
        return ResponseEntity.ok(admin);
    }

    // build update employee REST API
    @PutMapping("/PutAdmin/{id}")
    public ResponseEntity<Admins> updateAdmins(@PathVariable int id,@RequestBody Admins adminDetails) {
        Admins updateAdmins = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));

        updateAdmins.setAdmin_name(adminDetails.getAdmin_name());
        updateAdmins.setAddress(adminDetails.getAddress());
        updateAdmins.setContact_Number(adminDetails.getContact_Number());
        updateAdmins.setFoundation_id(adminDetails.getFoundation_id());
        adminRepository.save(updateAdmins);

        return ResponseEntity.ok(updateAdmins);
    }

    @DeleteMapping("/DeleteAdmin/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable int id){

        Admins admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        adminRepository.delete(admin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
