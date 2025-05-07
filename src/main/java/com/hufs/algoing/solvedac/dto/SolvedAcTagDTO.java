package com.hufs.algoing.solvedac.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class SolvedAcTagDTO {

    private Long bojTagId;

    private String key;

    private List<DisplayNameDTO> displayNames;
}
