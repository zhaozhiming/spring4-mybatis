package com.farmer.baton.repo;

import com.farmer.baton.model.Farmer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerMapper {
    List<Farmer> findAll();

    void updateWangwu(Farmer farmer);

    void updateZhangsan(Farmer farmer);
}
