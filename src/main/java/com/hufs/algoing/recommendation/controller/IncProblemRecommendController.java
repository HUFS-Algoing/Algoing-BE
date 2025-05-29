package com.hufs.algoing.recommendation.controller;

import com.hufs.algoing.global.code.ApiResponse;
import com.hufs.algoing.recommendation.dto.IncProblemRecommendDTO;
import com.hufs.algoing.recommendation.service.IncProblemRecommendService;
import com.hufs.algoing.recommendation.service.WeaknessRecommendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "데일리 문제 추천 API", description = "데일리 문제 추천 API")
@RestController
@RequestMapping("/api/incproblemrecommendations")
@RequiredArgsConstructor
public class IncProblemRecommendController {

    private final IncProblemRecommendService incProblemRecommendService;

    @Operation(summary = "userId", description = "요청 받은 사용자의 티어와 선호 문제 유형을 기반으로 문제를 추천합니다.")
    @Parameter(name = "long", description = "추천 받을 사용자 id")
    @GetMapping("/{userId}")
    public ApiResponse<List<IncProblemRecommendDTO>> getIncProblemRecommendation(@PathVariable Long userId) {
        // 서비스 호출하여 추천 문제 목록 가져오기
        List<IncProblemRecommendDTO> recommendations = incProblemRecommendService.getIncProblemRecommendation(userId);
        recommendations.forEach(recommendation -> System.out.println(recommendation.toString()));

        return ApiResponse.onSuccess(recommendations);
    }
}
