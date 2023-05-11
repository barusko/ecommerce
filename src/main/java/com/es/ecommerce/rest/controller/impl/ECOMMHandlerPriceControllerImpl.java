package com.es.ecommerce.rest.controller.impl;

import com.es.ecommerce.model.request.PriceProductAssignmentRequestDTO;
import com.es.ecommerce.model.response.PriceProductAssignmentResponseDTO;
import com.es.ecommerce.rest.controller.ECOMMHandlerPriceController;
import com.es.ecommerce.service.impl.PriceHandlingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ECOMMHandlerPriceControllerImpl implements ECOMMHandlerPriceController {

    private final PriceHandlingService priceHandlingService;

    public ECOMMHandlerPriceControllerImpl(PriceHandlingService priceHandlingService){ this.priceHandlingService = priceHandlingService; }


    @Override
    public ResponseEntity<PriceProductAssignmentResponseDTO> getAssignmentRateByProduct(PriceProductAssignmentRequestDTO priceProductAssignmentRequestDTO) throws Exception {
        return  priceHandlingService.handle(priceProductAssignmentRequestDTO);
    }
}
