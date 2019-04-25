package com.corco.springproj.spring5webapp2.repositories;

import org.springframework.data.repository.CrudRepository;
import com.corco.springproj.spring5webapp2.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
