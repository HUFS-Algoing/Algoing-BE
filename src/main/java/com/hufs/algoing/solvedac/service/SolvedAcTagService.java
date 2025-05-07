package com.hufs.algoing.solvedac.service;

import com.hufs.algoing.solvedac.dto.SolvedAcTagDTO;
import com.hufs.algoing.solvedac.entity.SolvedAcTags;
import com.hufs.algoing.solvedac.dto.DisplayNameDTO;
import com.hufs.algoing.solvedac.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolvedAcTagService {
    private final TagRepository tagRepository;

    //태그 리스트에서 DB에 없는 것만 저장
    public void saveNewTags(List<SolvedAcTagDTO> tagDTOs){
        List<String> keys =
                tagDTOs.stream().map(SolvedAcTagDTO::getKey)
                        .collect(Collectors.toList());
        List<String> existingKeys =
                tagRepository.findAllByKeyIn(keys)
                        .stream().map(SolvedAcTags::getKey)
                        .toList();

        // DB에 없는 태그만 골라서 엔티티로 변환
        List<SolvedAcTags> newTags = tagDTOs.stream()
                .filter(dto -> !existingKeys.contains(dto.getKey()))
                .map(dto -> {
                    SolvedAcTags entity = new SolvedAcTags();
                    entity.setKey(dto.getKey());
                    entity.setBojTagId(dto.getBojTagId());

                    String name = dto.getDisplayNames().stream()
                            .filter(display -> "ko".equals(display.getLanguage()))
                            .findFirst()
                            .map(DisplayNameDTO::getName)
                            .orElse(null);
                    entity.setName(name);

                    return entity;
                })
                .collect(Collectors.toList());

        tagRepository.saveAll(newTags);
    }
}
