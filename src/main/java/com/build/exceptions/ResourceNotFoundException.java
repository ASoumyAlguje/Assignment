package com.build.exceptions;


public class ResourceNotFoundException extends RuntimeException{

    String ResourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found %s : %s" , resourceName, fieldName,fieldValue ));
        ResourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


}
