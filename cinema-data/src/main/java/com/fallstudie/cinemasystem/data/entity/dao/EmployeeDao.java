package com.fallstudie.cinemasystem.data.entity.dao;

import java.util.List;

import javax.persistence.Query;

import com.fallstudie.cinemasystem.data.entity.Employee;

public class EmployeeDao extends BaseDao<Employee>
{

    @Override
    public int count ( Employee crsRequest )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Employee find ( long id )
    {
        Employee employee = getEm().find(Employee.class, id);
        return employee;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees ( )
    {
        List<Employee> resultList = null;
        Query query = getEm().createNamedQuery("Employee.findAll");
        resultList = query.getResultList();
        return resultList;
    }
}
