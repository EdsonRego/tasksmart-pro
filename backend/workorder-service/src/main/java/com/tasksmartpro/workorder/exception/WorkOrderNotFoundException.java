package com.tasksmartpro.workorder.exception;

public class WorkOrderNotFoundException extends RuntimeException {
    public WorkOrderNotFoundException(String message) {
        super(message);
    }
}
