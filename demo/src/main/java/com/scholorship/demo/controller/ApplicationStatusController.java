//package com.scholorship.demo.controller;
//
//public class ApplicationStatusController {
//}
package com.scholorship.demo.controller;
//import com.scholorship.demo.exception.ResourceNotFoundException;
import com.scholorship.demo.expection.ResourceNotFoundException;
import com.scholorship.demo.model.ApplicationStatus;
//import com.scholorship.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scholorship.demo.repository.ApplicationStatusRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/application_status")
public class ApplicationStatusController {

    @Autowired
    private ApplicationStatusRepository applicationStatusRepository;

    @GetMapping("/getApplicationStatus")
    public List<ApplicationStatus> getAllApplicationStatus() {
        return applicationStatusRepository.findAll();
    }

    // build create employee REST API
    @PostMapping("/addapplicationStatus")
    public ApplicationStatus createApplicationStatus(@RequestBody ApplicationStatus application_status) {
        application_status.setApplication_id(applicationStatusRepository.findMaxId() + 1);
        return applicationStatusRepository.save(application_status);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ApplicationStatus> getAdminById(@PathVariable int id) {
        ApplicationStatus applicationStatus = applicationStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id:" + id));
        return ResponseEntity.ok(applicationStatus);
    }
}