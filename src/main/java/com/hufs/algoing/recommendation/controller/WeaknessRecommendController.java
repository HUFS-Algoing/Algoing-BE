package com.hufs.algoing.recommendation.controller;

import com.hufs.algoing.recommendation.service.WeaknessRecommendService;
import com.hufs.algoing.recommendation.dto.WeaknessRecommendDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weaknessRecommendations")
@RequiredArgsConstructor

public class WeaknessRecommendController {

    private final WeaknessRecommendService weaknessRecommendService;

    @GetMapping("/{userId}")
    public List<WeaknessRecommendDTO> getWeaknessRecommendations(@PathVariable Long userId){
        List<WeaknessRecommendDTO> recommendations = weaknessRecommendService.getWeaknessRecommendations(userId);
        recommendations.forEach(recommendation -> System.out.println(recommendation));
        return recommendations;
    }

}
