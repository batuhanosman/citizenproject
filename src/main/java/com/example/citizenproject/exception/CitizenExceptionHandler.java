package com.example.citizenproject.exception;

import com.example.citizenproject.controller.response.BaseApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CitizenExceptionHandler {

    @ExceptionHandler(CitizenEntityNotFoundException.class)
    public ResponseEntity<BaseApiResponse<Object>> citizenNotFoundException(CitizenEntityNotFoundException exception) {
        return getErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    private ResponseEntity<BaseApiResponse<Object>> getErrorResponse(HttpStatus httpStatus, String errorMessage) {
        return ResponseEntity
                .status(httpStatus.value())
                .body(BaseApiResponse.builder()
                        .code(httpStatus.value())
                        .message(errorMessage)
                        .build());
    }
}
