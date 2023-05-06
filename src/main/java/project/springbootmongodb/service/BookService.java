package project.springbootmongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import project.springbootmongodb.model.Book;
import project.springbootmongodb.repository.BookRepo;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Book> allBooks() {
        return bookRepo.findAll();
    }

    public Book searchBook(String id) {
        return bookRepo.findById(id).get();
    }

    public Book searchBookByTitle(String title) {
        return bookRepo.findByTitle(title);
    }
    
    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Book Deleted";
    }

    public String updateBook(Book book) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(book.getId()));
        Update update = new Update();
        update.set("price", book.getPrice());
        long updateCount = mongoTemplate.updateFirst(query, update, Book.class).getModifiedCount();
        return updateCount > 0 ? "update succeed" : "update failed.";
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }
}

    
