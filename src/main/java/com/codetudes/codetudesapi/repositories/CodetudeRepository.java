package com.codetudes.codetudesapi.repositories;

import com.codetudes.codetudesapi.domain.Codetude;
import org.springframework.data.repository.CrudRepository;

public interface CodetudeRepository extends CrudRepository<Codetude, Long> {

}
