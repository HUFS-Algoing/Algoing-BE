package com.hufs.algoing.problem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problems/")
public class ProblemCrawlController {
    @GetMapping("{problemId}")
    public Long getProblemId(@PathVariable Long problemId){
    }

}
