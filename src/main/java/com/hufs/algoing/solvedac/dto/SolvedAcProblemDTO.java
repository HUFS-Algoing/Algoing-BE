package com.hufs.algoing.solvedac.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class SolvedAcProblemDTO {
    private String problemId;
    private Long level;
    private String key;
    private List<SolvedAcTagDTO> tags;
}
