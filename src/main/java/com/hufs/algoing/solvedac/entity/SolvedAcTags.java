package com.hufs.algoing.solvedac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SolvedAcTags {
    @Id
    private Long bojTagId;

    private String key;

    private String name;
}
