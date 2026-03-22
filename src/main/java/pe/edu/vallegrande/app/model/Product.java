package pe.edu.vallegrande.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("price")
    private BigDecimal price;

    @Field("stock")
    private Integer stock;

    @Field("category")
    private String category;

    @Field("brand")
    private String brand;

    @Field("image_url")
    private String imageUrl;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("status")
    private String status;

}
