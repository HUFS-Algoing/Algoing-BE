package com.hufs.algoing.test.controller;


import com.hufs.algoing.submitting.service.SubmittingService;
import com.hufs.algoing.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestSubmittingController {
    @Autowired
    private SubmittingService submittingService;




    @PostMapping("/submit")
    public String testSubmit(@RequestParam Long problemId, @RequestParam String code, @RequestParam String language, @AuthenticationPrincipal User p) throws InterruptedException {
        String handle = p.getHandle();
        submittingService.submit(problemId, code, language);
        return "www.acmicpc.net/status?from_mine=1&problem_id="+problemId+"&user_id="+handle;
    }


}