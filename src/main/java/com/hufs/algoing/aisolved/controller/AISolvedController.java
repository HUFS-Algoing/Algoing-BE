package com.hufs.algoing.aisolved.controller;

import com.hufs.algoing.global.chatgpt.service.GPTService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AISolved API", description = "OpenAI 이용 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class AISolvedController {

    private final GPTService gptService;

    @Operation(summary = "모든 문제 분석 요청", description = "DB에 있는 모든 문제를 OpenAI에게 분석 요청합니다.")
    @PostMapping
    public void analyzeAll() {
        gptService.analyzeAllProblems();
    }


}
