package com.example.citizenproject.exception;

public class CitizenEntityNotFoundException extends RuntimeException {

    private Long id;

    public CitizenEntityNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Citizen not found with id: " + this.id;
    }
}
