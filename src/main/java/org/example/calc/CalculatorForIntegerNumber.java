package org.example.calc;

public class CalculatorForIntegerNumber {

    private final int firstNumber;
    private final int secondNumber;

    public CalculatorForIntegerNumber(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int sum() {
        return firstNumber + secondNumber;
    }

    public int multiplication() {
        return firstNumber * secondNumber;
    }

    public int subtraction() {
        return firstNumber - secondNumber;
    }

    public double division() {
        return (double) firstNumber / secondNumber;
    }

    public static double pow(int number, int degree) {
        if (degree == 0) {
            return 1;
        }
        if (degree < 0) {
            double result = 1.0;
            for (int i = 0; i < Math.abs(degree); i++) {
                result *= 1.0 / (double) number;
            }
            return result;
        }
        double result = 1.0;
        for (int i = 0; i < degree; i++) {
            result *= number;
        }
        return result;
    }

    public Object getNull() {
        return null;
    }

    public void printAllResults() {
        System.out.println("Sum is : " + sum());
        System.out.println("Multiplication is : " + multiplication());
        System.out.println("Subtraction is : " + subtraction());
        System.out.println("Division is: " + division());
    }
}
