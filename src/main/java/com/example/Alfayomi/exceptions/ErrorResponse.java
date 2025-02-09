package com.example.Alfayomi.exceptions;

import java.sql.Date;

public class ErrorResponse {
    private int status;
    private String message;
    private Date timeStamp ;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String message, Date timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;


    }
}
