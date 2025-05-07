package com.hufs.algoing.solvedac.service;

import com.hufs.algoing.solvedac.dto.SolvedAcProblemDTO;
import com.hufs.algoing.solvedac.dto.SolvedAcProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SolvedAcService {
//    private static final String API_URL = "https://solved.ac/api/v3/user/show?handle=";

    public SolvedAcProfileDTO getSolvedAcProfile(String handle) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://solved.ac/api/v3/user/show?handle=" + handle;

        ResponseEntity<SolvedAcProfileDTO> response = restTemplate.getForEntity(url, SolvedAcProfileDTO.class);
        return response.getBody(); // JSON 데이터를 UserProfile 객체로 매핑
    }

    public SolvedAcProblemDTO getSolvedAcProblemInfo(Long problemId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://solved.ac/api/v3/problem/show?problemId=" + problemId;

        ResponseEntity<SolvedAcProblemDTO> response = restTemplate.getForEntity(url, SolvedAcProblemDTO.class);
        return response.getBody();
    }




}
