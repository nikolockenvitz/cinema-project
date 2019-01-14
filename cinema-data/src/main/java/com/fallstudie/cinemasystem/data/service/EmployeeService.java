package com.fallstudie.cinemasystem.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.transferobject.EmployeeTo;
import com.fallstudie.cinemasystem.data.entity.dao.EmployeeDao;
import com.fallstudie.cinemasystem.data.helper.EntityToToHelper;
import com.fallstudie.cinemasystem.data.helper.ToToEntityHelper;

public class EmployeeService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private EmployeeDao         employeeDao;

    public EmployeeService( )
    {
        this.employeeDao = new EmployeeDao();
    }

    public EmployeeTo getEmployee ( String idString )
    {
        Long id = Long.parseLong(idString);
        return EntityToToHelper.createEmployeeTo(employeeDao.find(id));
    }

    public List<EmployeeTo> getAllEmployees ( )
    {
        return EntityToToHelper.createEmployeeTos(employeeDao.getAllEmployees());
    }

    public EmployeeTo save ( EmployeeTo employeeTo )
    {
        return EntityToToHelper.createEmployeeTo(employeeDao.persist(ToToEntityHelper.createEmployeeEntity(employeeTo)));
    }

}
