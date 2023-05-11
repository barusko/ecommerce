package com.es.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.*;
import static jakarta.persistence.GenerationType.AUTO;


/* [jakarta Persistence API] annotation set */
@Entity(name = ENTITY_PRODUCT)
/* [Lombok] annotation set */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class Product {

    /** PK of the table. */
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = COLUMN_PRODUCT_ID, unique= true, nullable = false)
    private Long productId;

    @Column(name = COLUMN_PRODUCT_NAME)
    private String productName;
}
