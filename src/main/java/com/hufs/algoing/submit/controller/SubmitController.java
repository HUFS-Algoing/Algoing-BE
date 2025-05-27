package com.hufs.algoing.submit.controller;

import com.hufs.algoing.global.code.ApiResponse;
import com.hufs.algoing.submit.dto.RecaptchaRequestDTO;
import com.hufs.algoing.submit.dto.RecaptchaResponseDTO;
import com.hufs.algoing.submit.dto.SubmitRequestDTO;
import com.hufs.algoing.submit.service.SubmitService;
import com.hufs.algoing.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
//
@RestController
@RequiredArgsConstructor
@RequestMapping("/submit")
@Slf4j
public class SubmitController {
    private final SubmitService submitService;
    private final WebClient.Builder webClientBuilder;

    // 캡차 해결 + 자동 제출

    @PostMapping
    public ApiResponse<RecaptchaResponseDTO> solveCaptcha(@RequestBody SubmitRequestDTO dto) {
        RecaptchaRequestDTO recapDTO = submitService.submit(dto, dto.getUserId());

        RecaptchaResponseDTO result = webClientBuilder.build()
                .post()
                .uri("http://43.200.206.181:5000/start")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(recapDTO)
                .retrieve()
                .bodyToMono(RecaptchaResponseDTO.class)
                .block();

        submitService.judgePoint(result, dto.getUserId());

        return ApiResponse.onSuccess(result);
    }


}
