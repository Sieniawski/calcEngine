package com.pluralsight.myapp;

import com.pluralsight.DynamicHelper;
import com.pluralsight.PowerOf;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Substracter;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.Divider;
//we could use
//import com.pluralsight.calcengine.* but to avoid bugs/errors it is better to use single imports

import org.omg.CORBA.DynAnyPackage.Invalid;

public class Main {

    public static void main(String[] args) {
        //useMathEquation();
        //useCalculatorBase();
        //useCalculateHelper();

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for(String statement:statements){
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

    static void useCalculateHelper() {

        String[] statements = {
                "add 1.0",          //Error: incorrect number of values
                "add xx 25.0",      //Error: non-numeric data
                "addX 0.0 0.0",     //Error: invalid command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };
        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            //the process method declares that it throws an exception
            //we put try inside for loop cause we want to check error for each statement
            //if we get an error on one statement then we still process the next statement
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                //message for our exceptions was set in base class constructor
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("Original exception: " + e.getCause().getMessage());
            }
        }

    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);


        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("Result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute (leftDouble, rightDouble);
        System.out.print("Result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute (leftInt, rightInt);
        System.out.print("Result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute ((double)leftInt, rightInt);
        System.out.print("Result = ");
        System.out.println(equationOverload.getResult());

        //Inheritance allows w new class to be defined with the characteristics of another - use extend keyword
        //Derived class can override base class methods - optionally use @override annotation
        //All classes derive from Object class either directly or indirectly
        //By default, object references are only equal when referencing the same instance - can override Object.equals to provide new behavior
        //super accesses current object as if instance of base class - access to base class behaviors
        //final and abstract provide control over class inheritance and method overriding
        //constructors are not inherited and each class is responsible for providing its own constructors


        System.out.println();
        System.out.println("Using inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Substracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        //for every element (calculator) in calculators do calculate()
        for (CalculateBase calculator:calculators){
            calculator.calculate();
            System.out.print("Result= ");
            System.out.println(calculator.getResult());
        }
    }
}











































