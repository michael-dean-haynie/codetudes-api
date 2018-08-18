package com.codetudes.codetudesapi.endpoints;

import com.codetudes.codetudesapi.contracts.TagDTO;
import com.codetudes.codetudesapi.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping
    TagDTO create(@RequestBody TagDTO TagDTO){
        return tagService.create(TagDTO);
    }

    @GetMapping("/{id}")
    TagDTO read(@PathVariable Long id){
        return tagService.read(id);
    }

    @PatchMapping
    TagDTO update(@RequestBody TagDTO TagDTO){
        return tagService.update(TagDTO);
    }

    @DeleteMapping("/{id}")
    Long delete(@PathVariable Long id){
        return tagService.delete(id);
    }
}
