package com.hufs.algoing.submit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecaptchaResponseDTO {
    private String message;
    private boolean correct;

}
