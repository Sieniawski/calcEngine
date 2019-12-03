package com.pluralsight.calcengine;

public interface MathProcessing {
    //it models the concept of a class being able to identify a keyword it operates on
    String SEPARATOR = " ";

    //do the operation
    String getKeyword(); //add

    //and tell us what symbol to use when producing the output - Adder implements it
    char getSymbol(); //+
    double doCalculation(double leftVal, double rightVal);
}

//An interface defines a contract
//- provides no implementation
//- can include methods and constants
//Classes implement interfaces
//- classes are able to implement multiple interfaces
//Interfaces are able to extend other interfaces
//- implementing an extended interface implicitly implements the base