package com.scholorship.demo.repository;
import java.util.List;
import java.util.Optional;

import com.scholorship.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.scholorship.demo.model.User; 
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("select coalesce(max(a.User_Id), 0) from User a")
    public Integer findMaxId();
//    @Query("SELECT  application_status, COUNT( application_status) FROM User GROUP BY  application_status ORDER BY COUNT( application_status) DESC")
//    public List<User> getallUserStatus();
//
}
