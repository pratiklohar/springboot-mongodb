package project.springbootmongodb.service;

import project.springbootmongodb.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO addBook(BookDTO book);  //create

    List<BookDTO> allBooks();   //read

    BookDTO searchBook(String id);  //read

    BookDTO searchBookByTitle(String title);    //read

    String updateBook(BookDTO book);    //update

    String deleteBook(String id); //delete


}
