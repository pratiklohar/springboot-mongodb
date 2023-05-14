package project.springbootmongodb.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import project.springbootmongodb.dto.BookDTO;
import project.springbootmongodb.model.Book;
import project.springbootmongodb.repository.BookRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    ModelMapper modelMapper = new ModelMapper();

    public BookDTO addBook(BookDTO book) {
        Book bookEntity = modelMapper.map(book, Book.class);
        return modelMapper.map(bookRepo.save(bookEntity), BookDTO.class);
    }

    public List<BookDTO> allBooks() {

        List<Book> bookList = bookRepo.findAll();
        List<BookDTO> books = bookList
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
        return books;
    }

    public BookDTO searchBook(String id) {

        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            return modelMapper.map(bookOptional.get(), BookDTO.class);
        } else {
            return null;
        }
    }

    public BookDTO searchBookByTitle(String title) {
        Optional<Book> bookOptional = bookRepo.findByTitle(title);
        if (bookOptional.isPresent()) {
            return modelMapper.map(bookOptional.get(), BookDTO.class);
        } else {
            return null;
        }
    }

    public String updateBook(BookDTO book) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(book.getId()));
        Update update = new Update();
        update.set("price", book.getPrice());
        long updateCount = mongoTemplate.updateFirst(query, update, Book.class).getModifiedCount();
        return updateCount > 0 ? "update succeed" : "update failed.";
    }

    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Book Deleted";
    }


}

    
