//package com.scholorship.demo.repository;
//
//public interface ApplicationStatusRepositary {
//}
package com.scholorship.demo.repository;
import java.util.List;

import com.scholorship.demo.model.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;

import com.scholorship.demo.model.Admins;
public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Integer>{
    @Query("select coalesce(max(a.Application_id), 0) from ApplicationStatus a")
    public Integer findMaxId();
}