package project.springbootmongodb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("book")

public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String category;
    private int  quantity;
    private float price;
}