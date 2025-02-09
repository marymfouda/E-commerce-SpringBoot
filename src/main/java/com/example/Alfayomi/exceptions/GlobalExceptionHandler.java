package com.example.Alfayomi.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handelIllegalState(IllegalStateException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage()); }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handelRecordNotFound(RecordNotFoundException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage()); }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handelBindException(BindException ex){
        List<String> errors = ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        Map<String , List<String>> errMap = new HashMap<>();
        errMap.put("error" , errors);
        return new ResponseEntity<>(errMap , HttpStatus.BAD_REQUEST );
    }

// used after handling all exception
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handelException(){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body("Something went error"); }
}
