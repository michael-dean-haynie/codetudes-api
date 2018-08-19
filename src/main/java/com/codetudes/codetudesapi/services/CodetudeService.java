package com.codetudes.codetudesapi.services;

import com.codetudes.codetudesapi.contracts.CodetudeDTO;

import java.util.List;

public interface CodetudeService {
    CodetudeDTO create(CodetudeDTO codetudeDTO);

    CodetudeDTO read(Long id);

    CodetudeDTO update(CodetudeDTO codetudeDTO);

    Long delete(Long id);

    List<CodetudeDTO> findAll();
}
