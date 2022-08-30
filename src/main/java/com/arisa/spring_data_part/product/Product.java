package com.arisa.spring_data_part.product;

import com.arisa.spring_data_part.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor @Setter @Getter
@Table(name="product") @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name" ,nullable = false)
    private String name;

    @Column(name = "describe")
    private String describe;
    

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
