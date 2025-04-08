package com.hufs.algoing.problem.service;

import com.hufs.algoing.problem.entity.Problem;
import com.hufs.algoing.problem.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private ProblemCrawlService problemCrawlService;

    public Problem getOrCrawlProblem(Long problemId){

        if(problemRepository.existsByProblemId(problemId)){
            return (Problem) problemRepository.findByProblemId(problemId).orElse(null);
        }
        Problem newProblem = problemCrawlService.crawlProblem(problemId);

        return problemRepository.save(newProblem);
    }

}
