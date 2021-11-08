package com.hk.api.demo.serviceimpl;

import com.hk.api.demo.bo.Book;
import com.hk.api.demo.dao.BookDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hk.api.demo.service.BookSevice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookSevice{

   private final BookDao bookdao;

    @Override
    public Book insertBook(Book b) {
        return bookdao.save(b);
    }
    @Override
    public Optional<Book> getBook(Long id) {
        return bookdao.findById(id);
    }



    @Override
    public List<Book> getAllbooks() {
        return  bookdao.findAll().stream().peek( m -> m.setType(m.getType().toUpperCase())).sorted().collect(Collectors.toList());
    }

    @Override
    public List<String> getAllbookstypes() {
        return  bookdao.findAll().stream().map( m -> m.getType()).distinct().collect(Collectors.toList());
    }
    @Override
    public List<Book> getbooksbytype(String type) {
        return  bookdao.findAll().stream().filter(m->type.equals(m.getType())).sorted().collect(Collectors.toList());
    }


    @Override
    public void deleteBook(Long id) {
       bookdao.deleteById(id);

    }

    @Override
    public Book modifyBook(Book b) {
       Book c=bookdao.getById(b.getId());
       c.setDescription(b.getDescription());
       c.setTitle(b.getTitle());
       c.setType(b.getType());
       return bookdao.save(c);

    }

    @Override
    public List<Book> getAllBookStartingBy(String s) {
        return bookdao.findAll().stream().filter(m->m.getType().startsWith(s)).sorted().collect(Collectors.toList());
    }

    @Override
    public long getNombreBook() {
        return bookdao.findAll().stream().count();
    }
}
