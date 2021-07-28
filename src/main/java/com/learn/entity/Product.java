package com.learn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_tbl")
public class Product {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;

}
