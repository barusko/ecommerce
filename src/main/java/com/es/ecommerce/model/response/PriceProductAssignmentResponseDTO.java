package com.es.ecommerce.model.response;

import com.es.ecommerce.model.dto.GroupDTO;
import com.es.ecommerce.model.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.es.ecommerce.model.constants.ConstantsJSON.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames = true)
public class PriceProductAssignmentResponseDTO implements Serializable{


    @Serial
    private static final long serialVersionUID = 1L;

    @NonNull
    @JsonProperty(JSON_PROP_RATE)
    private Long rate;

    @NonNull
    @JsonProperty(JSON_PROP_START_DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @NonNull
    @JsonProperty(JSON_PROP_END_DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @NonNull
    @JsonProperty(JSON_PROP_PRICE)
    private Long priceProduct;

    @NonNull
    @JsonProperty(JSON_PROP_PRODUCT)
    private ProductDTO productId;
    @NonNull
    @JsonProperty(JSON_PROP_GROUP)
    private GroupDTO brandId;

    @NonNull
    @JsonProperty(JSON_PROP_CURRENCY)
    private String currency;


}
