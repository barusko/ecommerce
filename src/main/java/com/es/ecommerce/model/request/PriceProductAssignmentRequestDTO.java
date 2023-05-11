package com.es.ecommerce.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.es.ecommerce.model.constants.ConstantsJSON.*;


@Data
@ToString()
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceProductAssignmentRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NonNull
    @JsonProperty(JSON_PROP_PRODUCT_ID)
    private Long productId;

    @NonNull
    @JsonProperty(JSON_PROP_BRAND_ID)
    private Long brandId;

    @NonNull
    @JsonProperty(JSON_PROP_ASSIGMENT_REQUEST_DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime assignmentRequestDate;
}
