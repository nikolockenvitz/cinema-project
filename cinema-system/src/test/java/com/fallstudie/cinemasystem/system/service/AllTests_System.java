package com.fallstudie.cinemasystem.system.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MovieResource_Test.class, UtilsTest.class, ReservationResource_Test.class })
public class AllTests_System
{

}
