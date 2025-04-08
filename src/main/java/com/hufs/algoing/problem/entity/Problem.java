package com.hufs.algoing.problem.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "problem")
public class Problem {
    @Id
    @Column(name = "problem_id", nullable = false, unique = true)
    private Long problemId;

    private String title;

    @Column(name = "description")
    @Lob
    private String description;

    private String input;

    private String output;

    private String sampleInput1;

    private String sampleIntput2;

    private String sampleOutput1;

    private String sampleOutput2;

    private String tag;

    private Long time;

    private Long memory;

    private Long level;

    private String limit;

    @Builder
    public Problem(Long problemId, String title, String tag, Long time, Long memory, Long level,
                   String input, String output, String description, String sampleInput1, String sampleIntput2, String sampleOutput1, String sampleOutput2, String limit) {
        this.problemId = problemId;
        this.title = title;
        this.tag = tag;
        this.time = time;
        this.memory = memory;
        this.level = level;
        this.input = input;
        this.output = output;
        this.sampleInput1 = sampleInput1;
        this.sampleIntput2 = sampleIntput2;
        this.sampleOutput1 = sampleOutput1;
        this.sampleOutput2 = sampleOutput2;
        this.description = description;
        this.limit = limit;
    }


//    @Builder
//    public Problem(Long problemId, String title, String tag, Long time, Long memory, Long level,
//                   String input, String output, String description) {
//        this.problemId = problemId;
//        this.title = title;
//        this.tag = tag;
//        this.time = time;
//        this.memory = memory;
//        this.level = level;
//        this.input = input;
//        this.output = output;
//        this.description = description;
//    }
}
