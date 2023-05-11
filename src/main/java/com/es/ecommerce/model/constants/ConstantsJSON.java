package com.es.ecommerce.model.constants;

import com.es.ecommerce.entity.constants.ConstantsDatabaseSchema;

public class ConstantsJSON {

    private ConstantsJSON() {
        throw new IllegalStateException(ConstantsJSON.class.getName());
    }

    public static final String JSON_PROP_PRODUCT_ID = "productId";
    public static final String JSON_PROP_PRODUCT_NAME = "productName";

    public static final String JSON_PROP_BRAND_ID = "brandId";
    public static final String JSON_PROP_BRAND_NAME = "brandName";

    public static final String JSON_PROP_RATE = "rate";
    public static final String JSON_PROP_START_DATE = "startDate";
    public static final String JSON_PROP_END_DATE = "endDate";
    public static final String JSON_PROP_CURRENCY = "currency";
    public static final String JSON_PROP_ASSIGMENT_REQUEST_DATE = "assignmentRequestDate";
    public static final String JSON_PROP_PRICE = "priceProduct";
    public static final String JSON_PROP_PRODUCT = "product";
    public static final String JSON_PROP_GROUP = "group";

}
