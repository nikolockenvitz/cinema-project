package com.fallstudie.cinemasystem.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.CustomerTo;
import com.fallstudie.cinemasystem.data.entity.dao.CustomerDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;
import com.fallstudie.cinemasystem.data.helper.ToToEntityHelper;

public class CustomerService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private CustomerDao         customerDao;

    public CustomerService( )
    {
        this.customerDao = new CustomerDao();
    }

    public CustomerTo getCustomer ( String idString )
    {
        Long id = Long.parseLong(idString);
        return EntityToToHelper.createCustomerTo(customerDao.find(id));
    }

    public CustomerTo getCustomerByEmail ( String email )
    {
        return EntityToToHelper.createCustomerTo(customerDao.getCustomerByEmail(email));
    }

    public CustomerTo save ( CustomerTo customerTo )
    {
        return EntityToToHelper.createCustomerTo(customerDao.persist(ToToEntityHelper.createCustomerEntity(customerTo)));
    }

}
