package com.hufs.algoing.problem.repository;

import com.hufs.algoing.problem.entity.UserSolvedProblem;
import com.hufs.algoing.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSolvedProblemRepository extends JpaRepository<UserSolvedProblem, Long> {

    List<UserSolvedProblem> findByUserId(User user);
}
