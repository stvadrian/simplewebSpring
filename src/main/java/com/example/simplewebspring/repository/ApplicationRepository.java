package com.example.simplewebspring.repository;

import com.example.simplewebspring.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findAll();

    @Query("SELECT a FROM Application a WHERE a.branch.id = :branchId")
    List<Application> findByBranchId(@Param("branchId") Integer branchId);
}
