package project.springbootmongodb.dto;

import lombok.Data;

@Data
public class BookRequest {
    private String id;
    private String title;
    private String author;
    private String category;
    private int quantity;
    private float price;
}