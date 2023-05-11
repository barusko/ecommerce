package com.es.ecommerce;

import com.es.ecommerce.entity.Group;
import com.es.ecommerce.entity.Price;
import com.es.ecommerce.entity.Product;
import com.es.ecommerce.model.request.PriceProductAssignmentRequestDTO;
import com.es.ecommerce.model.response.PriceProductAssignmentResponseDTO;
import com.es.ecommerce.repository.PriceRepository;
import com.es.ecommerce.service.impl.PriceHandlingService;
import com.es.ecommerce.service.impl.PriceHandlingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class EcommerceApplicationTests {

    @Mock
    private PriceRepository priceRepository;


    private ModelMapper modelMapper;

    @InjectMocks
    private PriceHandlingServiceImpl priceHandlingService;
    List<Price> priceList ;

    @BeforeEach
    public void setup() {
        modelMapper =new ModelMapper();
        MockitoAnnotations.openMocks(this);

        // Create a list of Price objects for the mock repository
        priceList = Arrays.asList(
                new Price(1001L, LocalDateTime.of(2020, 6, 14, 15, 0), LocalDateTime.of(2020, 6, 14, 18, 30), 2L, 1L, 25L, "EUR",
                        new Product(35455L, "ABC"), new Group(1L, "ZARA")),
                new Price(1002L, LocalDateTime.of(2020, 6, 15, 0, 0), LocalDateTime.of(2020, 6, 15, 11, 0), 3L, 1L, 31L, "EUR",
                        new Product(35455L, "ABC"), new Group(1L, "ZARA")),
                new Price(1003L, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1L, 0L, 36L, "EUR",
                        new Product(35455L, "ABC"), new Group(1L, "ZARA")),
                new Price(1004L, LocalDateTime.of(2020, 6, 15, 16, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4L, 1L, 39L, "EUR",
                        new Product(35455L, "ABC"), new Group(1L, "ZARA"))
        );

    }


    // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void test_on_14_at_10_00_product_35455_brand_1() throws Exception {
        PriceProductAssignmentRequestDTO request = new PriceProductAssignmentRequestDTO();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setAssignmentRequestDate(LocalDateTime.of(2020, 6, 14, 10, 00, 0));

        // Mock the behavior of the priceRepository
        when(priceRepository.findPricesByProductAndBranchId(any(), any())).thenReturn(priceList);


        // Create a new instance of PriceHandlingServiceImpl manually and inject the dependencies
        PriceHandlingServiceImpl priceHandlingService = new PriceHandlingServiceImpl(priceRepository,modelMapper);


        ResponseEntity<PriceProductAssignmentResponseDTO> response = priceHandlingService.handle(request);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getRate());
        Assertions.assertEquals("2020-06-14T00:00", response.getBody().getStartDate().toString());
        Assertions.assertEquals("2020-12-31T23:59:59", response.getBody().getEndDate().toString());

    }

    //Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void test_on_14_at_16_00_product_35455_brand_1() throws Exception {
        PriceProductAssignmentRequestDTO request = new PriceProductAssignmentRequestDTO();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setAssignmentRequestDate(LocalDateTime.of(2020, 6, 14, 16, 00, 0));

        // Mock the behavior of the priceRepository
        when(priceRepository.findPricesByProductAndBranchId(any(), any())).thenReturn(priceList);


        // Create a new instance of PriceHandlingServiceImpl manually and inject the dependencies
        PriceHandlingServiceImpl priceHandlingService = new PriceHandlingServiceImpl(priceRepository,modelMapper);


        ResponseEntity<PriceProductAssignmentResponseDTO> response = priceHandlingService.handle(request);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().getRate());
        Assertions.assertEquals("2020-06-14T15:00", response.getBody().getStartDate().toString());
        Assertions.assertEquals("2020-06-14T18:30", response.getBody().getEndDate().toString());

    }


    //Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void test_on_14_at_21_00_product_35455_brand_1() throws Exception {
        PriceProductAssignmentRequestDTO request = new PriceProductAssignmentRequestDTO();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setAssignmentRequestDate(LocalDateTime.of(2020, 6, 14, 21, 00, 0));

        // Mock the behavior of the priceRepository
        when(priceRepository.findPricesByProductAndBranchId(any(), any())).thenReturn(priceList);


        // Create a new instance of PriceHandlingServiceImpl manually and inject the dependencies
        PriceHandlingServiceImpl priceHandlingService = new PriceHandlingServiceImpl(priceRepository,modelMapper);


        ResponseEntity<PriceProductAssignmentResponseDTO> response = priceHandlingService.handle(request);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getRate());
        Assertions.assertEquals("2020-06-14T00:00", response.getBody().getStartDate().toString());
        Assertions.assertEquals("2020-12-31T23:59:59", response.getBody().getEndDate().toString());

    }


    //Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void test_on_15_at_10_00_product_35455_brand_1() throws Exception {
        PriceProductAssignmentRequestDTO request = new PriceProductAssignmentRequestDTO();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setAssignmentRequestDate(LocalDateTime.of(2020, 6, 15, 10, 00, 0));

        // Mock the behavior of the priceRepository
        when(priceRepository.findPricesByProductAndBranchId(any(), any())).thenReturn(priceList);


        // Create a new instance of PriceHandlingServiceImpl manually and inject the dependencies
        PriceHandlingServiceImpl priceHandlingService = new PriceHandlingServiceImpl(priceRepository,modelMapper);


        ResponseEntity<PriceProductAssignmentResponseDTO> response = priceHandlingService.handle(request);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(3, response.getBody().getRate());
        Assertions.assertEquals("2020-06-15T00:00", response.getBody().getStartDate().toString());
        Assertions.assertEquals("2020-06-15T11:00", response.getBody().getEndDate().toString());

    }

    //Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void test_on_16_at_21_00_product_35455_brand_1() throws Exception {
        PriceProductAssignmentRequestDTO request = new PriceProductAssignmentRequestDTO();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setAssignmentRequestDate(LocalDateTime.of(2020, 6, 16, 21, 00, 0));

        // Mock the behavior of the priceRepository
        when(priceRepository.findPricesByProductAndBranchId(any(), any())).thenReturn(priceList);


        // Create a new instance of PriceHandlingServiceImpl manually and inject the dependencies
        PriceHandlingServiceImpl priceHandlingService = new PriceHandlingServiceImpl(priceRepository,modelMapper);


        ResponseEntity<PriceProductAssignmentResponseDTO> response = priceHandlingService.handle(request);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(4, response.getBody().getRate());
        Assertions.assertEquals("2020-06-15T16:00", response.getBody().getStartDate().toString());
        Assertions.assertEquals("2020-12-31T23:59:59", response.getBody().getEndDate().toString());

    }

}
