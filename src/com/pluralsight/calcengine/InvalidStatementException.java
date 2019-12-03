package com.pluralsight.calcengine;

public class InvalidStatementException extends Exception {
    public InvalidStatementException(String reason, String statement) {
        super(reason + ": " + statement);
    }

    public InvalidStatementException(String reason, String statement, Throwable cause) {
        super(reason + ": " + statement, cause);
    }
}

//exceptions provide a non-intrusive way to signal errors
//try/catch/finally provide a structured way to handle exceptions
//exceptions are caught by type:
//- can have separate catch statement for differing exception types
//- catch from most specific type to least specific
//raise exceptions using throw
//methods must declare any unhandled checked exceptions using throws
//can create custom exception types
//- normally inherit from exception