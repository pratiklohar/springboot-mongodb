package project.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import project.springbootmongodb.model.Book;

import java.util.Optional;


@Repository
public interface BookRepo extends MongoRepository<Book, String> {

    @Query("{ 'title' : ?0 }")
    Optional<Book> findByTitle(String name);
}
