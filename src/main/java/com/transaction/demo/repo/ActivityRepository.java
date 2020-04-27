package com.transaction.demo.repo;

import java.util.List;

import com.transaction.demo.model.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("from Activity c where c.userId = :userId")
    List<Activity> findByUserId(@Param(value = "userId") Long userId);
}