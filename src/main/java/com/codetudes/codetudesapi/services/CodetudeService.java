package com.codetudes.codetudesapi.services;

import com.codetudes.codetudesapi.contracts.CodetudeDTO;
import com.codetudes.codetudesapi.repositories.CodetudeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface CodetudeService {
    CodetudeDTO create(CodetudeDTO codetudeDTO);
}
