package com.es.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.ENTITY_GROUP;
import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.COLUMN_BRAND_ID;
import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.COLUMN_BRAND_NAME;
import static jakarta.persistence.GenerationType.AUTO;

/* [jakarta Persistence API] annotation set */
@Entity(name = ENTITY_GROUP)
/* [Lombok] annotation set */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class Group {

    /** PK of the table. */
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = COLUMN_BRAND_ID,  unique= true, nullable = false)
    private Long brandId;

    @Column(name = COLUMN_BRAND_NAME)
    private String brandName;

}
