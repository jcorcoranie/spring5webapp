package com.corco.springproj.spring5webapp2.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.corco.springproj.spring5webapp2.model.Author;
import com.corco.springproj.spring5webapp2.model.Book;
import com.corco.springproj.spring5webapp2.model.Publisher;
import com.corco.springproj.spring5webapp2.repositories.AuthorRepository;
import com.corco.springproj.spring5webapp2.repositories.BookRepository;
import com.corco.springproj.spring5webapp2.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	

	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	
	private void initData() {
		
		Publisher harper = new Publisher("Harper Collins", "123 Publisher Street");
		publisherRepository.save(harper);

		Publisher worx = new Publisher("Worx", "234 Publisher Street");
		publisherRepository.save(worx);
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		

		authorRepository.save(eric);
		bookRepository.save(ddd);

		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book jdwejb = new Book("J2EE Development without EJB", "23444", worx);
		rod.getBooks().add(jdwejb);
		jdwejb.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(jdwejb);
			
	}
}
