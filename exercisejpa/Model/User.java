package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 5,message = "User name must be more than 5")
    @Column(columnDefinition = "varchar(10) not null")
    private String userName;
     @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
     @Column(columnDefinition = "varchar(10) not null")
     private String password;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email invalid")
    @Column(columnDefinition = "varchar(30) not null")
    private String email;
    @Pattern(regexp = "^(Admin|Customer)$")
    @Column(columnDefinition = "varchar(20) check ( role='Admin' or role='Customer')")
    private String role;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "Balance should not be empty")
    @Positive(message = "Balance mus be positive number")
    private Integer balance;

}
