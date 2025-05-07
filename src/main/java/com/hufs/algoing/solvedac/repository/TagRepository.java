package com.hufs.algoing.solvedac.repository;

import com.hufs.algoing.solvedac.entity.SolvedAcTags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<SolvedAcTags, String> {
    boolean existsByKey(String key);

    List<SolvedAcTags> findAllByKeyIn(List<String> keys);
    List<SolvedAcTags> findKeyByName(String name);

    SolvedAcTags findNameByKey(String key);
}
