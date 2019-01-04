package com.codetudes.codetudesapi.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetudes.codetudesapi.contracts.ImageDTO;
import com.codetudes.codetudesapi.services.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    ImageDTO create(@RequestBody ImageDTO imageDTO){
        return imageService.create(imageDTO);
    }

    @GetMapping("/{id}")
    ImageDTO read(@PathVariable Long id){
        return imageService.read(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping
    ImageDTO update(@RequestBody ImageDTO imageDTO){
        return imageService.update(imageDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    Long delete(@PathVariable Long id){
        return imageService.delete(id);
    }

    @GetMapping
    List<ImageDTO> findAll(){
        return imageService.findAll();
    }
	
}
