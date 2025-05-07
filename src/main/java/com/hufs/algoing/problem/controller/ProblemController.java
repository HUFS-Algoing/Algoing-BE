package com.hufs.algoing.problem.controller;

import com.hufs.algoing.problem.entity.Problem;
import com.hufs.algoing.problem.service.ProblemCrawlService;
import com.hufs.algoing.problem.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problems/")
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    @GetMapping("/{problemId}")
    public Problem getProblemId(@PathVariable Long problemId){
        return problemService.getOrCrawlProblem(problemId);
    }


}
