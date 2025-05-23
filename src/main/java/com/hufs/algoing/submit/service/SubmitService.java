package com.hufs.algoing.submit.service;

import com.hufs.algoing.global.code.ErrorStatus;
import com.hufs.algoing.global.exception.custom.UserNotFoundException;
import com.hufs.algoing.submit.dto.RecaptchaRequestDTO;
import com.hufs.algoing.submit.dto.RecaptchaResponseDTO;
import com.hufs.algoing.submit.dto.SubmitRequestDTO;
import com.hufs.algoing.user.entity.User;
import com.hufs.algoing.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SubmitService {
    private final UserRepository userRepository;

    public RecaptchaRequestDTO submit(SubmitRequestDTO dto, Long userId)  {

        User user = userRepository.findById(dto.getUserId()).orElseThrow(()-> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));
        String email = user.getEmail();
        String password = user.getPassword();

        return RecaptchaRequestDTO.builder()
                .code(dto.getCode())
                .language(dto.getLanguage())
                .email(email)
                .password(password)
                .problemNum(dto.getProblemNum())
                .build();

    }

    // 포인트 적립
    public void judgePoint(RecaptchaResponseDTO dto, Long userId)  {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));
        if(dto.isCorrect()){
            int originPoint = user.getUserPoint();
            user.updatePoint(originPoint+5);
        }
        log.info("유저 id {}의 포인트가 {}로 증가했습니다.", user.getUserId(),user.getUserPoint());
    }



}





