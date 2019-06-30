package com.sharmokh.spring5framework.bootstrap;

import com.sharmokh.spring5framework.model.Author;
import com.sharmokh.spring5framework.model.Book;
import com.sharmokh.spring5framework.model.Publisher;
import com.sharmokh.spring5framework.repositories.AuthorRepository;
import com.sharmokh.spring5framework.repositories.BookRepository;
import com.sharmokh.spring5framework.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher ucla = new Publisher("UCLA Publishers", "1 Westwood Blvd, Los Angeles CA");
        publisherRepository.save(ucla);

        Author steve = new Author("Steve", "Sharmokh");
        Book book1 = new Book("Handy Man Services", "a1bc3", ucla);
        steve.getBooks().add(book1);
        book1.getAuthors().add(steve);

        authorRepository.save(steve);
        bookRepository.save(book1);

        Author jack = new Author("Jack", "Thompson");
        Book book2 = new Book("How to Live", "dgc8b", ucla);
        jack.getBooks().add(book2);

        authorRepository.save(jack);
        bookRepository.save(book2);
    }
}
