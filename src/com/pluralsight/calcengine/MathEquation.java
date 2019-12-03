package com.pluralsight.calcengine;

public class MathEquation {

    //declares the fields that are necessary to do the work
    private double leftVal;
    private double rightVal;
    private char opCode = 'a';
    private double result;

    //getters and setters
    public double getLeftVal() {
        return leftVal;
    }
    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }
    public double getRightVal() {
        return rightVal;
    }
    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }
    public char getOpCode() {
        return opCode;
    }
    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }
    public double getResult() {
        return result;
    }

    //constructors
    public MathEquation(){ }
    public MathEquation(char opCode) {
        this.opCode= opCode;
    }
    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }



    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }
    public void execute(int leftVal, int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();

        result = (int)result;
    }

    //metoda, ktora nic nie zwraca i nie ma parametrow
    //method that do a lot of things with individuals task inside
    public void execute() {
        switch(opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - invalid opCode");
                result = 0.0d;
                break;
        }

    }



}
