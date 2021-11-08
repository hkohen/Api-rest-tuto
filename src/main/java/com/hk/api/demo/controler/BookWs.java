package com.hk.api.demo.controler;

import com.hk.api.demo.bo.Book;
import com.hk.api.demo.service.BookSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookWs {
    private final BookSevice bookSevice;
    @PostMapping("/create")
    public Book createBook(@RequestBody Book k){
        return bookSevice.insertBook(k);

    }

    @GetMapping("/get/{id}")
    public Book readBook(@PathVariable Long id){
        Optional<Book> book = bookSevice.getBook(id);
        return book.isPresent() ? book.get() : null;

    }

    @PutMapping("/modify/")
    public Book modifyBook(@RequestBody Book k){
        return bookSevice.modifyBook(k);

    }

    @GetMapping("/getall")
    public ArrayList<Book> readBook(){
        return (ArrayList<Book>) bookSevice.getAllbooks();

    }
    @GetMapping("/getall/startswith/{s}")
    public ArrayList<Book> getbooks(@PathVariable String s){
        return (ArrayList<Book>) bookSevice.getAllBookStartingBy(s);

    }

    @GetMapping("/getbookscount/")
    public Long getcountbooks(){
        return bookSevice.getNombreBook();

    }
    @GetMapping("/getallbookstypes/")
    public ArrayList<String> getbookstype(){
        return (ArrayList<String>) bookSevice.getAllbookstypes();

    }

    @GetMapping("/getallbooksbytype/{type}")
    public ArrayList<Book> getallbooksbytype(@PathVariable String type){
        return (ArrayList<Book>) bookSevice.getbooksbytype(type);

    }
    @DeleteMapping(value = "/delete/{id}" ,produces = "text/html")
    public String deleteBook(@PathVariable Long id){
         bookSevice.deleteBook(id);
        return "the book "+ id + " was deleted !";
    }
}
