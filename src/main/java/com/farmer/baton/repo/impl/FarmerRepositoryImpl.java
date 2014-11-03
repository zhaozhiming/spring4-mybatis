package com.farmer.baton.repo.impl;

import com.farmer.baton.model.Farmer;
import com.farmer.baton.repo.FarmerRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FarmerRepositoryImpl implements FarmerRepository {
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<String> findAll() {
        return this.sqlSession.selectList("select-farmer-age-18");
    }

    @Override
    public void save(Farmer farmer) {
        this.sqlSession.insert("add-new-farmer", farmer);
    }
}
