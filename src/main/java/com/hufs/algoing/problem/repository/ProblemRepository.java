package com.hufs.algoing.problem.repository;

import com.hufs.algoing.problem.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    boolean existsByProblemId(Long problemId);

    Optional<Object> findByProblemId(Long problemId);
}
