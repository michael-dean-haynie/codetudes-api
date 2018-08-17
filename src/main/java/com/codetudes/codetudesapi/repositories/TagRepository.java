package com.codetudes.codetudesapi.repositories;

import com.codetudes.codetudesapi.domain.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

}
