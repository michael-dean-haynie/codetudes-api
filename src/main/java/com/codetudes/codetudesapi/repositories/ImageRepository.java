package com.codetudes.codetudesapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codetudes.codetudesapi.domain.Image;

public interface ImageRepository  extends CrudRepository<Image, Long> {

}
