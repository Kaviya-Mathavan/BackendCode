package com.scholorship.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.scholorship.demo.model.Admins;
public interface AdminRepository extends JpaRepository<Admins, Integer>{
    @Query("select coalesce(max(a.Admin_Id), 0) from Admins a")
    public Integer findMaxId();

}
