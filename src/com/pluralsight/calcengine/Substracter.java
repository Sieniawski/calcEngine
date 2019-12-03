package com.pluralsight.calcengine;

public class Substracter extends CalculateBase implements MathProcessing{

    //class that inherit from CalculateBase
    public Substracter() {}
    public Substracter(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    //specific implementation of method that were defined before in base class -> CalculateBase
    @Override
    public void calculate() {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public char getSymbol() {
        return '-';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
