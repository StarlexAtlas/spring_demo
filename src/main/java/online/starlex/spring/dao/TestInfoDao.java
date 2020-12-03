package online.starlex.spring.dao;

import online.starlex.spring.entity.TestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestInfoDao extends JpaRepository<TestInfo, Integer> {
    boolean existsByTestId(int testId);
    TestInfo findByTestId(int testId);
}
