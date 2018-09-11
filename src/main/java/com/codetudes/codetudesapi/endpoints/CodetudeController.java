package com.codetudes.codetudesapi.endpoints;

import com.codetudes.codetudesapi.contracts.CodetudeDTO;
import com.codetudes.codetudesapi.services.CodetudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codetudes")
public class CodetudeController {
    @Autowired
    CodetudeService codetudeService;

    @PostMapping
    CodetudeDTO create(@RequestBody CodetudeDTO codetudeDTO){
        return codetudeService.create(codetudeDTO);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    CodetudeDTO read(@PathVariable Long id){
        return codetudeService.read(id);
    }

    @PatchMapping
    CodetudeDTO update(@RequestBody CodetudeDTO codetudeDTO){
        return codetudeService.update(codetudeDTO);
    }

    @DeleteMapping("/{id}")
    Long delete(@PathVariable Long id){
        return codetudeService.delete(id);
    }

    @GetMapping
    List<CodetudeDTO> findAll(){
        return codetudeService.findAll();
    }
}
