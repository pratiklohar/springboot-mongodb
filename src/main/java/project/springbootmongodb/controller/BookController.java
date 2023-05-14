package project.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.springbootmongodb.dto.BookDTO;
import project.springbootmongodb.service.BookServiceImpl;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping("/book")
    public BookDTO addBook(@RequestBody BookDTO book) {
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<BookDTO> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/book/{id}")
    public BookDTO searchBook(@PathVariable String id) {
        return bookService.searchBook(id);
    }

    @GetMapping("/book")
    public BookDTO searchBookByTitle(@RequestParam String title) {
        return bookService.searchBookByTitle(title);
    }

    @PatchMapping("/book")
    public String updateBook(@RequestBody BookDTO book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

}
