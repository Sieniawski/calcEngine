package com.pluralsight;

import com.pluralsight.calcengine.MathProcessing;

public class DynamicHelper {
    //it is a class that do the same work that CalculateHelper did but do it in terms of handlers that implement the interface rather than a set of hardcoded operations

    //store the list of handlers given instance of DynamicHelper has access to
    private MathProcessing[] handlers;

    //constructor accept an array of handlers and store it inside of our class variable
    //whenever we create an instance of this class we just pass in that array that contains all the handlers we want it to use
    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    //method called process accepts a String statement to operate on and returns back a string result
    public String process(String statement) {
        //IN: add 1.0 2.0
        //OUT: 1.0 + 2.0 = 3.0

        //we need to use split method here
        //we well ues constant that was defined on our MathProcessing interface called SEPARATOR
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0]; //add

        MathProcessing theHandler = null;

        for(MathProcessing handler:handlers) {
            //we take current handler and call get keyword method
            if(keyword.equalsIgnoreCase(handler.getKeyword())) {
                //if this handler knows how to handle the keyword in this statement then we will take the
                //current handler and assign it to our local variable theHandler
                theHandler = handler;
                break;
            }
        }

        double leftVal = Double.parseDouble(parts[1]); //1.0
        double rightVal = Double.parseDouble(parts[2]); //2.0

        double result = theHandler.doCalculation(leftVal, rightVal);


        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return  sb.toString();

    }

}
