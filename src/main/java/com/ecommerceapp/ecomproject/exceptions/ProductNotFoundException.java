package com.ecommerceapp.ecomproject.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        //parameterized constructor
        //passing message to superclass Exception
        //using super we can set some of the parameters of the superclass
         super(message);
    }
}
