package com.floristeria.Persistence;

public class NullValueException extends Exception
{

    public NullValueException()
    {
    }
    public NullValueException(String error_message)
    {
        super(error_message);
    }
}

