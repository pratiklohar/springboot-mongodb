package project.springbootmongodb.service;

import project.springbootmongodb.dto.BookRequest;
import project.springbootmongodb.dto.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse addBook(BookRequest bookRequest);  //create

    List<BookResponse> allBooks();   //read

    BookResponse searchBook(String id);  //read

    BookResponse searchBookByTitle(String title);    //read

    boolean updateBook(BookRequest bookRequest);    //update

    boolean deleteBook(String id); //delete


}
