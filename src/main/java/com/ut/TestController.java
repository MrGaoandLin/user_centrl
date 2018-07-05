package com.ut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;
    @PutMapping("testEntity")
    public void put(TestEntity entity){
        testService.put(entity);
    }

    @GetMapping("testEntity")
    public TestEntity get(Long id){
        return testService.findById(id);
    }

    @GetMapping("testEntity2")
    public TestEntity findFirstByALikeAndC(String aa, Double cc){
        return testService.findFirstByALikeAndC(aa, cc);
    }

    @GetMapping("testEntity3")
    public List<TestEntity> findAllByCLessThan(Double cc){
        return testService.findAllByCLessThan(cc);
    }
}