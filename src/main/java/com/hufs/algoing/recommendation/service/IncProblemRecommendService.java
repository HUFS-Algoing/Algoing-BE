package com.hufs.algoing.recommendation.service;

import com.hufs.algoing.recommendation.algorithm.IncProblemRecommendAlgorithm;
import com.hufs.algoing.recommendation.dto.IncProblemRecommendDTO;
import com.hufs.algoing.user.entity.User;
import com.hufs.algoing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hufs.algoing.global.code.ErrorStatus;
import com.hufs.algoing.global.exception.custom.UserNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncProblemRecommendService {
    private final UserRepository userRepository;
    private final IncProblemRecommendAlgorithm incProblemRecommendAlgorithm;

    public List<IncProblemRecommendDTO> getIncProblemRecommendation(Long userId) {

        //유저 정보 가져오기
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));
        System.out.println(user);

        return incProblemRecommendAlgorithm.recommend(user);


    }
}
