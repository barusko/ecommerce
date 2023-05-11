package com.es.ecommerce.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import static com.es.ecommerce.model.constants.ConstantsJSON.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    @NonNull
    @JsonProperty(JSON_PROP_PRODUCT_ID)
    private Long productId;


    @JsonProperty(JSON_PROP_PRODUCT_NAME)
    private String productName;

}
