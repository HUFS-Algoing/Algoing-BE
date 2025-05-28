package com.hufs.algoing.hint.service;

import com.hufs.algoing.global.code.ErrorStatus;
import com.hufs.algoing.global.exception.custom.HintNotFoundException;
import com.hufs.algoing.global.exception.custom.UserNotFoundException;
import com.hufs.algoing.hint.entity.Hint;
import com.hufs.algoing.hint.repository.HintRepository;
import com.hufs.algoing.user.entity.User;
import com.hufs.algoing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HintService {

    private final HintRepository hintRepository;
    private final UserRepository userRepository;

    public Hint getHint(Long problemId, int order){

        Hint hint = hintRepository
                .findHintByAiSolved_Problem_ProblemIdAndOrder(problemId, order)
                .orElseThrow(() -> new HintNotFoundException(ErrorStatus.HINT_NOT_FOUND));
        return hint;
    }

    public void minusPoint(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));
        int point = user.getUserPoint() - 3;
        log.info("userId : {}, point: {}", user.getUserId(), user.getUserPoint());
        user.updatePoint(point);
        log.info("update user point : {}", user.getUserPoint());
    }
}
