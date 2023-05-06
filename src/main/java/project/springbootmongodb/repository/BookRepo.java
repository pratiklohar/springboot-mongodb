package project.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import project.springbootmongodb.model.Book;




@Repository
public interface BookRepo extends MongoRepository<Book, String> {

    @Query("{ 'title' : ?0 }")
    Book findByTitle(String name);
}
