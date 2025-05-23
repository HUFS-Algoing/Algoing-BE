package com.hufs.algoing.submit.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitRequestDTO {
    private Long userId;
    private Long problemNum;
    private String language;
    private String code;
}
