package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 3,message = "name must be more than 3")
    @NotEmpty(message = "name should not be empty")
    private String name;
    @Positive(message = "price should mbe positive number")
    @NotNull(message = " price should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer price;
    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "category ID should not be empty")
    private Integer categoryID;
    @Column(columnDefinition = "varchar(50) check ( discounts='WhiteFriday' or discounts='BlackFriday' or discounts='End of year discount' or discounts= 'no discount')")
    @NotEmpty(message = "discounts should not be empty")
    @Pattern(regexp = "^(WhiteFriday|BlackFriday|End of year discount|no discount)$")
    private String discounts;

}
