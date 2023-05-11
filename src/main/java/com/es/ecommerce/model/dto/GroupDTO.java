package com.es.ecommerce.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Builder;

import static com.es.ecommerce.model.constants.ConstantsJSON.JSON_PROP_BRAND_ID;
import static com.es.ecommerce.model.constants.ConstantsJSON.JSON_PROP_BRAND_NAME;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {

    @NonNull
    @JsonProperty(JSON_PROP_BRAND_ID)
    private Long brandId;

    @JsonProperty(JSON_PROP_BRAND_NAME)
    private String brandName;

}
