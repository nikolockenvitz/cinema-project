package com.fallstudie.cinemasystem.data.entity.dao;

import com.fallstudie.cinemasystem.data.entity.Customer;

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

}
