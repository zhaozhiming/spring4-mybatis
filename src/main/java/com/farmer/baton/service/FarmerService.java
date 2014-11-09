package com.farmer.baton.service;

import com.farmer.baton.model.Farmer;
import com.farmer.baton.repo.FarmerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FarmerService {
    @Autowired
    private FarmerMapper farmerMapper;

    @Transactional
    public void updateTwoFarmers(Farmer farmer1, Farmer farmer2) {
        farmerMapper.updateZhangsan(farmer1);
        farmerMapper.updateWangwu(farmer2);
    }


}
