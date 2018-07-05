package com.ut;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TestEntityRepo extends JpaRepository<TestEntity, Long>{
    TestEntity findFirstByALikeAndC(String aa, Double cc);
    List<TestEntity> findAllByCLessThan(Double cc);

    Page<TestEntity> findAllByCLessThan(Double cc, Pageable pageable);
//@Transactional
//    @Query("")//jpql
}
