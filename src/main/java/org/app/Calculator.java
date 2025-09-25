package org.app;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) throws ArithmeticException {
            if(b == 0) throw new ArithmeticException("/ by zero");
            return a / b;


    }
}