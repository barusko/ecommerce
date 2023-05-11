package com.es.ecommerce.service.impl;

import com.es.ecommerce.model.request.PriceProductAssignmentRequestDTO;
import com.es.ecommerce.model.response.PriceProductAssignmentResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PriceHandlingService {

ResponseEntity<PriceProductAssignmentResponseDTO>  handle(PriceProductAssignmentRequestDTO priceAssignmentRequest) throws Exception;
}
