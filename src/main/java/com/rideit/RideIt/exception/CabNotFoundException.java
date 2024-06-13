package com.rideit.RideIt.exception;

public class CabNotFoundException extends  RuntimeException
{
    public CabNotFoundException(String message)
    {
        super(message);
    }
}
