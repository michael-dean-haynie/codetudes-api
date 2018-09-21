package com.codetudes.codetudesapi.endpoints;

import com.codetudes.codetudesapi.contracts.TagDTO;
import com.codetudes.codetudesapi.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    TagService tagService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    TagDTO create(@RequestBody TagDTO TagDTO){
        return tagService.create(TagDTO);
    }

    @GetMapping("/{id}")
    TagDTO read(@PathVariable Long id){
        return tagService.read(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping
    TagDTO update(@RequestBody TagDTO TagDTO){
        return tagService.update(TagDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    Long delete(@PathVariable Long id){
        return tagService.delete(id);
    }

    @GetMapping
    List<TagDTO> findAll(){
        return tagService.findAll();
    }
}
