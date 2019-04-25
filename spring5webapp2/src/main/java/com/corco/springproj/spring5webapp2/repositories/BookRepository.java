package com.corco.springproj.spring5webapp2.repositories;

import org.springframework.data.repository.CrudRepository;
import com.corco.springproj.spring5webapp2.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
}
