package com.hk.api.demo.service;

import com.hk.api.demo.bo.Book;

import java.util.List;
import java.util.Optional;

public interface BookSevice {
    
    String a="test
        String b="test2;
        String c="test3;

    public Book insertBook(Book b);
    public Optional<Book> getBook(Long id);
    public List<Book> getAllbooks();
    public void deleteBook (Long id);

    public Book modifyBook (Book b);
    public List<Book> getAllBookStartingBy(String s);

    public long getNombreBook();
    public List<Book> getbooksbytype(String type);
    public List<String> getAllbookstypes();
}
