package com.es.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import static jakarta.persistence.GenerationType.AUTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.*;

/* [jakarta Persistence API] annotation set */
@Entity(name = ENTITY_PRICE)
/* [Lombok] annotation set */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class Price {

    /** PK of the table. */
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = COLUMN_ID, unique= true, nullable = false)
    private Long id;

    @Column(name = COLUMN_START_DATE)
    private LocalDateTime startDate;

    @Column(name = COLUMN_END_DATE)
    private LocalDateTime endDate;

    @Column(name = COLUMN_RATE)
    private Long rate;

    @Column(name =  COLUMN_PRIORITY)
    private Long priority;

    @Column(name = COLUMN_PRICE)
    private Long priceProduct;

    @Column(name = COLUMN_CURRENCY)
    private String currency;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = COLUMN_PRICE_REFERENCE_PRODUCT_ID, referencedColumnName = COLUMN_PRODUCT_ID)
    private Product productId;

    @ManyToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = COLUMN_PRICE_REFERENCE_BRAND_ID, referencedColumnName = COLUMN_BRAND_ID)
    private Group brandId;

}
