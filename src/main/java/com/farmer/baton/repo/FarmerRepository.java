package com.farmer.baton.repo;

import com.farmer.baton.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Long>, JpaSpecificationExecutor<Farmer> {
    @Query("select f from farmers f where f.age = :age")
    List<Farmer> findByAge(@Param("age") int age);
}
