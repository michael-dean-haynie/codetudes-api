package com.codetudes.codetudesapi.services.impl;

import com.codetudes.codetudesapi.config.errors.NotFoundException;
import com.codetudes.codetudesapi.contracts.CodetudeDTO;
import com.codetudes.codetudesapi.domain.Codetude;
import com.codetudes.codetudesapi.repositories.CodetudeRepository;
import com.codetudes.codetudesapi.services.CodetudeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Codetude> entityOpt = codetudeRepository.findById(id);
        if (!entityOpt.isPresent()){
            throw new NotFoundException();
        }
        return mapper.map(entityOpt.get(), CodetudeDTO.class);
    }

    public CodetudeDTO update(CodetudeDTO codetudeDTO){
        return mapper.map(codetudeRepository.save(mapper.map(codetudeDTO, Codetude.class)), CodetudeDTO.class);
    }

    public Long delete(Long id){
        codetudeRepository.deleteById(id);
        return id;
    }

    public List<CodetudeDTO> findAll(){
        List<CodetudeDTO> dtos = new ArrayList<CodetudeDTO>();
        codetudeRepository.findAll().iterator().forEachRemaining(entity -> {
            dtos.add(mapper.map(entity, CodetudeDTO.class));
        });
        return dtos;
    }
}
