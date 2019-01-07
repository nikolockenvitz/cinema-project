package com.fallstudie.kinobuchungssystem.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.kinobuchungssystem.common.transferobject.EmployeeTo;
import com.fallstudie.kinobuchungssystem.data.entity.dao.EmployeeDao;
import com.fallstudie.kinobuchungssystem.data.helper.EntityToToHelper;
import com.fallstudie.kinobuchungssystem.data.helper.ToToEntityHelper;

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
