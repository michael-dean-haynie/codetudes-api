package com.codetudes.codetudesapi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetudes.codetudesapi.config.errors.NotFoundException;
import com.codetudes.codetudesapi.contracts.ImageDTO;
import com.codetudes.codetudesapi.domain.Image;
import com.codetudes.codetudesapi.repositories.ImageRepository;
import com.codetudes.codetudesapi.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
    private ModelMapper mapper;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public ImageDTO create(ImageDTO imageDTO) {
		return mapper.map(imageRepository.save(mapper.map(imageDTO, Image.class)), ImageDTO.class);
	}

	@Override
	public ImageDTO read(Long id) {
		Optional<Image> entityOpt = imageRepository.findById(id);
        if (!entityOpt.isPresent()){
            throw new NotFoundException();
        }
        return mapper.map(entityOpt.get(), ImageDTO.class);
	}

	@Override
	public ImageDTO update(ImageDTO imageDTO) {
		return mapper.map(imageRepository.save(mapper.map(imageDTO, Image.class)), ImageDTO.class);
	}

	@Override
	public Long delete(Long id) {
		imageRepository.deleteById(id);
        return id;
	}

	@Override
	public List<ImageDTO> findAll() {
		List<ImageDTO> dtos = new ArrayList<ImageDTO>();
        imageRepository.findAll().iterator().forEachRemaining(entity -> {
            dtos.add(mapper.map(entity, ImageDTO.class));
        });
        return dtos;
	}

}
