package com.ut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestEntityRepo testEntityRepo;

    public void put(TestEntity entity){
        testEntityRepo.save(entity);
    }

    public TestEntity findById(Long id){
        return testEntityRepo.findOne(id);
    }

    public TestEntity findFirstByALikeAndC(String aa, Double cc){
        return testEntityRepo.findFirstByALikeAndC(aa, cc);
    }

    public List<TestEntity> findAllByCLessThan(Double cc){
        return testEntityRepo.findAllByCLessThan(cc);
    }
}
