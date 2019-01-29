package com.fallstudie.cinemasystem.data.entity.dao;

import javax.persistence.Query;

import com.fallstudie.cinemasystem.data.entity.Customer;
import com.fallstudie.cinemasystem.data.entity.query.CustomerQuery;
import com.fallstudie.cinemasystem.data.entity.query.QueryParam;

public class CustomerDao extends BaseDao<Customer>
{

    @Override
    public int count ( Customer crsRequest )
    {
        return 0;
    }

    @Override
    public Customer find ( long id )
    {
        Customer ticket = getEm().find(Customer.class, id);
        return ticket;
    }

    public Customer getCustomerByEmail ( String email )
    {
        Customer result = null;
        Query query = getEm().createNamedQuery(CustomerQuery.FIND_CUSTOMER_BY_EMAIL);
        query.setParameter(QueryParam.EMAIL, email);
        result = (Customer) query.getSingleResult();
        return result;
    }

}
