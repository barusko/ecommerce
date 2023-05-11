package com.es.ecommerce.repository;

import com.es.ecommerce.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.TBL_GROUP;
import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.TBL_PRICE;
import static com.es.ecommerce.entity.constants.ConstantsDatabaseSchema.TBL_PRODUCT;


import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select pr.id, pr.start_date, pr.end_date, pr.rate, pr.priority, pr.price, pr.curr, pd.product_name,pd.product_id, gr.brand_id, gr.brand_name  from "  + TBL_PRICE + " pr  inner join "  + TBL_GROUP + " gr on pr.brand_id = gr.brand_id inner join " +  TBL_PRODUCT + " pd on pr.product_id = pd.product_id  where  pd.product_id = :productId  and gr.brand_id = :brandId")
    List<Price> findPricesByProductAndBranchId(@Param("productId")Long productId,
                                               @Param("brandId")Long brandId);


}
