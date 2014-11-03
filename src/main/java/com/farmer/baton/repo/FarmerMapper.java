package com.farmer.baton.repo;

import com.farmer.baton.model.Farmer;

import java.util.List;

public interface FarmerMapper {
    List<Farmer> findAll();
}
