package com.hufs.algoing.problem.entity;

import lombok.Getter;

@Getter
public class CrawledProblem {
    private Long id;
    private String title;
    private String description;
    private String input;
    private String output;
    private String sampleInput1;
    private String sampleIntput2;
    private String sampleOutput1;
    private String sampleOutput2;
}
