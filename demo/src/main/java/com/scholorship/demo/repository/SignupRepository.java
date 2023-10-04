
package com.scholorship.demo.repository;
import java.util.List;

import com.scholorship.demo.model.Signup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Integer>{
    @Query("select coalesce(max(a.Signup_id), 0) from Signup a")
    public Integer findMaxId();

    @Query(value = "select count(signup.email) from Signup signup where signup.email = ?1", nativeQuery = true)
    public int existsByEmail(String email);

    @Query(value = "select count(signup.password) from Signup signup where signup.email = ?1 and signup.password = ?2", nativeQuery = true)
    public int existsByPassword(String email, String password);

    @Query(value = "select * from Signup signup where signup.email = ?1", nativeQuery = true)
    public List<Signup> findByEmail(String email);



}
