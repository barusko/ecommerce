package com.es.ecommerce.service.impl;

import com.es.ecommerce.entity.Price;
import com.es.ecommerce.model.request.PriceProductAssignmentRequestDTO;
import com.es.ecommerce.model.response.PriceProductAssignmentResponseDTO;
import com.es.ecommerce.repository.PriceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PriceHandlingServiceImpl  implements PriceHandlingService{

    private final PriceRepository priceRepository;


    private final ModelMapper modelMapper;

    public PriceHandlingServiceImpl(PriceRepository priceRepository, ModelMapper modelMapper) {
        this.priceRepository = priceRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public ResponseEntity <PriceProductAssignmentResponseDTO> handle(PriceProductAssignmentRequestDTO priceAssignmentRequest) throws Exception {
            List<Price> priceList = priceRepository.findPricesByProductAndBranchId(priceAssignmentRequest.getProductId(),priceAssignmentRequest.getBrandId());
            if(priceList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                PriceProductAssignmentResponseDTO response =  priceList.stream()
                        .filter(Objects::nonNull)
                        .filter(priceRecord -> isValidDateToApplyRate(priceAssignmentRequest.getAssignmentRequestDate() ,priceRecord))
                        .sorted(Comparator.comparing(Price::getPriority).reversed())
                        .map(price -> this.modelMapper.map(price, PriceProductAssignmentResponseDTO.class))
                        .collect(Collectors.toList()).get(0);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

    }


    private static boolean isValidDateToApplyRate(LocalDateTime assigmentRequestDate, Price priceRecord){
        return (assigmentRequestDate.isAfter(priceRecord.getStartDate()) || assigmentRequestDate.isEqual(priceRecord.getStartDate()))
                && (assigmentRequestDate.isBefore(priceRecord.getEndDate()) || assigmentRequestDate.isEqual(priceRecord.getEndDate()));
    }
}
