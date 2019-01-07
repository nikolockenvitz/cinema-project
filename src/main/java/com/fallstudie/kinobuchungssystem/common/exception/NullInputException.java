package com.fallstudie.kinobuchungssystem.common.exception;

public class NullInputException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = -1835281225576566727L;

    public NullInputException( String exceptionDetails )
    {
        super(exceptionDetails);
    }
}