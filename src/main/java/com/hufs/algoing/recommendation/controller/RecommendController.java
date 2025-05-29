package com.hufs.algoing.recommendation.controller;

import com.hufs.algoing.global.code.ApiResponse;
import com.hufs.algoing.recommendation.dto.DailyRecommendDTO;
import com.hufs.algoing.recommendation.dto.IncProblemRecommendDTO;
import com.hufs.algoing.recommendation.dto.WeaknessRecommendDTO;
import com.hufs.algoing.recommendation.service.RecommendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Recommend API", description = "추천 API")
@RestController
@RequestMapping(value = "/api/recommend")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;

    @Operation(summary = "userId", description = "요청 받은 사용자의 티어와 선호 문제 유형을 기반으로 문제를 추천합니다.")
    @Parameter(name = "long", description = "추천 받을 사용자 id")
    @GetMapping("daily/{userId}")
    public ApiResponse<List<DailyRecommendDTO>> getDailyRecommendations(@PathVariable Long userId) {
        // 서비스 호출하여 추천 문제 목록 가져오기
        List<DailyRecommendDTO> recommendations = recommendService.getDailyRecommendations(userId);
        recommendations.forEach(recommendation -> System.out.println(recommendation.toString()));

        return ApiResponse.onSuccess(recommendations);
    }

    @Operation(summary = "userId", description = "요청 받은 사용자의 약점을 기반으로 문제를 추천합니다.")
    @Parameter(name = "long", description = "추천 받을 사용자 id")
    @GetMapping("weakness/{userId}")
    public ApiResponse<List<WeaknessRecommendDTO>> getWeaknessRecommendations(@PathVariable Long userId){
        List<WeaknessRecommendDTO> recommendations = recommendService.getWeaknessRecommendations(userId);
        recommendations.forEach(recommendation -> System.out.println(recommendation));
        return ApiResponse.onSuccess(recommendations);
    }

    @Operation(summary = "userId", description = "요청 받은 사용자의 많이 틀린 문제 유형 기반으로 문제를 추천합니다.")
    @Parameter(name = "long", description = "추천 받을 사용자 id")
    @GetMapping("incproblem/{userId}")
    public ApiResponse<List<IncProblemRecommendDTO>> getIncProblemRecommendation(@PathVariable Long userId) {
        List<IncProblemRecommendDTO> recommendations = recommendService.getIncProblemRecommendation(userId);
        recommendations.forEach(recommendation -> System.out.println(recommendation.toString()));

        return ApiResponse.onSuccess(recommendations);
    }
}
