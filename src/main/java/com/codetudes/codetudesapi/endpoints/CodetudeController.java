package com.codetudes.codetudesapi.endpoints;

import com.codetudes.codetudesapi.contracts.CodetudeDTO;
import com.codetudes.codetudesapi.services.CodetudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodetudeController {
    @Autowired
    CodetudeService codetudeService;

//    @GetMapping
//    CodetudeDTO create(){
//        CodetudeDTO codetudeDTO = new CodetudeDTO();
//        return codetudeService.create(codetudeDTO);
//    }
}
