package com.codetudes.codetudesapi.services.impl;

import com.codetudes.codetudesapi.contracts.TagDTO;
import com.codetudes.codetudesapi.domain.Tag;
import com.codetudes.codetudesapi.repositories.TagRepository;
import com.codetudes.codetudesapi.services.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TagRepository codetudeRepository;

    public TagDTO create(TagDTO tagDTO){
        return mapper.map(codetudeRepository.save(mapper.map(tagDTO, Tag.class)), TagDTO.class);
    }

    public TagDTO read(Long id){
        return mapper.map(codetudeRepository.findById(id), TagDTO.class);
    }

    public TagDTO update(TagDTO tagDTO){
        return mapper.map(codetudeRepository.save(mapper.map(tagDTO, Tag.class)), TagDTO.class);
    }

    public Long delete(Long id){
        codetudeRepository.deleteById(id);
        return id;
    }
}
