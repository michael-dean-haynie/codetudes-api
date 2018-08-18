package com.codetudes.codetudesapi.services;

import com.codetudes.codetudesapi.contracts.TagDTO;

public interface TagService {
    TagDTO create(TagDTO tagDTO);

    TagDTO read(Long id);

    TagDTO update(TagDTO tagDTO);

    Long delete(Long id);
}
