package project.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.springbootmongodb.dto.BookRequest;
import project.springbootmongodb.dto.BookResponse;
import project.springbootmongodb.service.BookServiceImpl;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping("/book")
    public BookResponse addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @GetMapping("/books")
    public List<BookResponse> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/book/{id}")
    public BookResponse searchBook(@PathVariable String id) {
        return bookService.searchBook(id);
    }

    @GetMapping("/book")
    public BookResponse searchBookByTitle(@RequestParam String title) {
        return bookService.searchBookByTitle(title);
    }

    @PatchMapping("/book")
    public boolean updateBook(@RequestBody BookRequest bookRequest) {
        return bookService.updateBook(bookRequest);
    }

    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

}
