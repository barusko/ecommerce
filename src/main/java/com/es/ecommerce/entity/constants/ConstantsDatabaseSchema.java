package com.es.ecommerce.entity.constants;

public final class ConstantsDatabaseSchema {

    private ConstantsDatabaseSchema() {
        throw new IllegalStateException(ConstantsDatabaseSchema.class.getName());
    }


    /* JPA entity name constants */


    public static final String ENTITY_PRICE 						= "prices";
    public static final String ENTITY_GROUP 						= "bussines_groups";
    public static final String ENTITY_PRODUCT 						= "products";

    public static final String TBL_PRICE     						= "prices";

    public static final String TBL_GROUP     						= "bussines_groups";
    public static final String TBL_PRODUCT     						= "products";
    public static final String COLUMN_BRAND_ID 						= "brand_id";
    public static final String COLUMN_BRAND_NAME 					= "brand_name";
    public static final String COLUMN_PRODUCT_ID 					= "product_id";
    public static final String COLUMN_PRICE_REFERENCE_PRODUCT_ID 	= "product_id";
    public static final String COLUMN_PRICE_REFERENCE_BRAND_ID 		= "brand_id";
    public static final String COLUMN_PRODUCT_NAME 					= "product_name";
    public static final String COLUMN_ID 							= "id";
    public static final String COLUMN_RATE 							= "rate";
    public static final String COLUMN_START_DATE 					= "start_date";
    public static final String COLUMN_END_DATE 						= "end_date";
    public static final String COLUMN_PRIORITY 						= "priority";
    public static final String COLUMN_PRICE 						= "price";
    public static final String COLUMN_CURRENCY 						= "curr";

}
