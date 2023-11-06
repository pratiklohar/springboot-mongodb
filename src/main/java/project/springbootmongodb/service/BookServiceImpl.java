package project.springbootmongodb.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import project.springbootmongodb.dto.BookRequest;
import project.springbootmongodb.dto.BookResponse;
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

    public BookResponse addBook(BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);
        return modelMapper.map(bookRepo.save(book), BookResponse.class);
    }

    public List<BookResponse> allBooks() {

        return bookRepo.findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookResponse.class))
                .collect(Collectors.toList());
    }

    public BookResponse searchBook(String id) {

        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            return modelMapper.map(bookOptional.get(), BookResponse.class);
        } else {
            return null;
        }
    }

    public BookResponse searchBookByTitle(String title) {
        Optional<Book> bookOptional = bookRepo.findByTitle(title);
        if (bookRepo.findByTitle(title).isPresent()) {
            return modelMapper.map(bookOptional.get(), BookResponse.class);
        } else {
            return null;
        }
    }

    public boolean updateBook(BookRequest bookRequest) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(bookRequest.getId()));
        Update update = new Update();
        update.set("price", bookRequest.getPrice());
        long updateCount = mongoTemplate.updateFirst(query, update, Book.class).getModifiedCount();
        return updateCount > 0 ? true : false;
    }

    public boolean deleteBook(String id) {
        bookRepo.deleteById(id);
        return true;
    }


}

    
