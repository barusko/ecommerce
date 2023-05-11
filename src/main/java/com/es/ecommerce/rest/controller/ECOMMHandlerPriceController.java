package com.es.ecommerce.rest.controller;

import com.es.ecommerce.model.request.PriceProductAssignmentRequestDTO;
import com.es.ecommerce.model.response.PriceProductAssignmentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ecommerce-api/v1/")
@Validated
public interface ECOMMHandlerPriceController {

    @PostMapping(path = "/price")
     ResponseEntity<PriceProductAssignmentResponseDTO> getAssignmentRateByProduct(@Validated @RequestBody PriceProductAssignmentRequestDTO priceProductAssignmentRequestDTO) throws Exception;
}
