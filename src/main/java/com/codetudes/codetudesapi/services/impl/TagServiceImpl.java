package com.codetudes.codetudesapi.services.impl;

import com.codetudes.codetudesapi.config.errors.NotFoundException;
import com.codetudes.codetudesapi.contracts.TagDTO;
import com.codetudes.codetudesapi.domain.Tag;
import com.codetudes.codetudesapi.repositories.TagRepository;
import com.codetudes.codetudesapi.services.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TagRepository tagRepository;

    public TagDTO create(TagDTO tagDTO){
        return mapper.map(tagRepository.save(mapper.map(tagDTO, Tag.class)), TagDTO.class);
    }

    public TagDTO read(Long id){
        Optional<Tag> entityOpt = tagRepository.findById(id);
        if (!entityOpt.isPresent()){
            throw new NotFoundException();
        }
        return mapper.map(entityOpt.get(), TagDTO.class);
    }

    public TagDTO update(TagDTO tagDTO){
        return mapper.map(tagRepository.save(mapper.map(tagDTO, Tag.class)), TagDTO.class);
    }

    public Long delete(Long id){
        tagRepository.deleteById(id);
        return id;
    }

    public List<TagDTO> findAll(){
        List<TagDTO> dtos = new ArrayList<TagDTO>();
        tagRepository.findAll().iterator().forEachRemaining(entity -> {
            dtos.add(mapper.map(entity, TagDTO.class));
        });
        return dtos;
    }
}
