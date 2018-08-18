package com.codetudes.codetudesapi.services.impl;

import com.codetudes.codetudesapi.contracts.CodetudeDTO;
import com.codetudes.codetudesapi.domain.Codetude;
import com.codetudes.codetudesapi.repositories.CodetudeRepository;
import com.codetudes.codetudesapi.services.CodetudeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodetudeServiceImpl implements CodetudeService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CodetudeRepository codetudeRepository;

    public CodetudeDTO create(CodetudeDTO codetudeDTO){
        return mapper.map(codetudeRepository.save(mapper.map(codetudeDTO, Codetude.class)), CodetudeDTO.class);
    }

    public CodetudeDTO read(Long id){
        return mapper.map(codetudeRepository.findById(id), CodetudeDTO.class);
    }

    public CodetudeDTO update(CodetudeDTO codetudeDTO){
        return mapper.map(codetudeRepository.save(mapper.map(codetudeDTO, Codetude.class)), CodetudeDTO.class);
    }

    public Long delete(Long id){
        codetudeRepository.deleteById(id);
        return id;
    }
}
