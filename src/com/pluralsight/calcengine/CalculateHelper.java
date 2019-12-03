package com.pluralsight.calcengine;

import sun.awt.Symbol;

public class CalculateHelper {

    private static final char ADD_SYMBOL = '+';
    private static final char SUBSTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    private MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    //we need to handle exception so we go to method declaration and add a throws calls for InvalidStatementException
    //because our custom exceptions are check exceptions
    //we indicated here that we throw that exception
    public void process(String statement) throws InvalidStatementException {
        //comannd leftval rightval
        //example below
        //add 1.0 2.0
        String[] parts = statement.split(" ");
        //first thing is to check that we have enough incoming statement
        //good place for that after we call 'split'
        //we get an array with three parts
        if(parts.length != 3)
            throw new InvalidStatementException("Incorrect number of fields", statement);

        String commandString = parts[0]; // add

        //here we check if the data is numeric format
        //we convert here string into doubles

        try {
            leftValue = Double.parseDouble(parts[1]); // 1.0
            rightValue = Double.parseDouble(parts[2]); // 2.0
        } catch (NumberFormatException e) {
            //reason + statement + we add the original parameter which is an original exception
            //this was originally triggers by another exception
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        setCommandFromString(commandString);
        //we check and see if the command field is null
        //and if it is null then we get an error
        if (command == null)
            throw new InvalidStatementException("Invalid command", statement);

        CalculateBase calculator = null;

        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Substracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();


    }

    //we need to check if command is valid
    //this method set command from string
    private void setCommandFromString(String commandString) {
        // add -> MathCommand.Add

        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;

    }
    @Override
    public String toString(){
        // 1.0 + 2.0 = 3.0
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBSTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return  sb.toString();

    }
}























































