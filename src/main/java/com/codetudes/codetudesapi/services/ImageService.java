package com.codetudes.codetudesapi.services;

import java.util.List;

import com.codetudes.codetudesapi.contracts.ImageDTO;

public interface ImageService {
    ImageDTO create(ImageDTO imageDTO);

    ImageDTO read(Long id);

    ImageDTO update(ImageDTO imageDTO);

    Long delete(Long id);

    List<ImageDTO> findAll();
}
