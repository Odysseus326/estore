package com.emarts.estore_backend.model;

import java.math.BigDecimal;
import java.util.Date;

// import com.fasterxml.jackson.annotation.JsonFormat;  // Import for changing json format (handled in frontend)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // Allows JPA to map this class with a database table
@Data  // Makes getter, setter, toSring, and other boilerplate method's 
@AllArgsConstructor  // Makes constructors w/ parameters
@NoArgsConstructor  // Makes constructors w/o parameters
public class Product {

    @Id  // Links Database id to this is
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generates an ID automatically
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;  // Similar to double, but removes accuracy error
    private String category;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-YYYY")  // Changes the data's format recieved from the database (handled in frontend)
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageType;
    @Lob  // Large object
    private byte[] imageData;
}