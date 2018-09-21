package com.codetudes.codetudesapi.services;

import com.codetudes.codetudesapi.contracts.TagDTO;

import java.util.List;

public interface TagService {
    TagDTO create(TagDTO tagDTO);

    TagDTO read(Long id);

    TagDTO update(TagDTO tagDTO);

    Long delete(Long id);

    List<TagDTO> findAll();
}
