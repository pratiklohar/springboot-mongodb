package project.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import project.springbootmongodb.model.Book;
import project.springbootmongodb.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/book/{id}")
    public Book searchBook(@PathVariable String id){
        return bookService.searchBook(id);
    }
    @GetMapping("/book")
    public Book searchBookByTitle(@RequestParam String title){
        return bookService.searchBookByTitle(title);
    }

    @PatchMapping("/book")
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }

}
