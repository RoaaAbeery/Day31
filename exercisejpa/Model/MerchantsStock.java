package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MerchantsStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "product id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer productid;
    @NotEmpty(message = "merchant id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer merchantid;
    @NotNull(message = "stock should not be empty")
    @Column(columnDefinition = "int not null")
    @Min(10)
    private Integer stock;
}
