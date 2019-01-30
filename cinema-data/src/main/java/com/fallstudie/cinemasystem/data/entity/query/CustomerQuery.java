package com.fallstudie.cinemasystem.data.entity.query;

public interface CustomerQuery
{
    public static final String FIND_CUSTOMER_BY_EMAIL = "SELECT c FROM Customer c" + " WHERE c.email=:" + QueryParam.EMAIL;

    public static final String FIND_CUSTOMER_BY_EMAIL_QNAME = CustomerQuery.FIND_CUSTOMER_BY_EMAIL;

}
