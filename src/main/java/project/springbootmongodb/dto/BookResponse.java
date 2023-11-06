package project.springbootmongodb.dto;

import lombok.Data;

@Data
public class BookResponse {
    private String id;
    private String title;
    private String author;
    private String category;
    private int quantity;
    private float price;
}