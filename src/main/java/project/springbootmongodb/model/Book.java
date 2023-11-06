package project.springbootmongodb.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "book")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String category;
    private int quantity;
    private float price;
}