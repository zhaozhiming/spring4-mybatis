package com.farmer.baton.repo.impl;

import com.farmer.baton.repo.FarmerRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FarmerRepositoryImpl implements FarmerRepository {
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<String> findFarmerAge18() {
        return this.sqlSession.selectList("select-farmer-age-18");
    }
}
