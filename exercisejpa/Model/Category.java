package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "name should not be empty")
    @Size(min = 3)
    private String name;
}
