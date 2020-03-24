package org.example.testcalc;

import org.example.annotations.After;
import org.example.annotations.Before;
import org.example.annotations.Test;
import org.example.calc.CalculatorForIntegerNumber;
import org.example.framework.Assertions;

public class TestCalcTrue {
    CalculatorForIntegerNumber calculatorForIntegerNumber;

    @Before
    public void setupBefore() {
        calculatorForIntegerNumber = new CalculatorForIntegerNumber(1, 2);
        System.out.println("Start foo 'setupBefore' " + calculatorForIntegerNumber.toString());
    }

    @After
    public void setupAfter() {
        System.out.println("Start foo 'setupAfter' " + calculatorForIntegerNumber.toString());
    }

    @Test
    public void testArithmetic() {
        Assertions.assertThat(calculatorForIntegerNumber.sum()).assertEquals("3");
        Assertions.assertThat(calculatorForIntegerNumber.division()).assertEquals("0.5");
        Assertions.assertThat(calculatorForIntegerNumber.subtraction()).assertEquals("-1");
        Assertions.assertThat(calculatorForIntegerNumber.multiplication()).assertEquals("2");
    }

    @Test
    public void testNullFoo() {
        Assertions.assertThat(CalculatorForIntegerNumber.pow(2, 10)).assertNotNull();
    }

    public void testBooleanValue() {
        Assertions.assertThat(calculatorForIntegerNumber.sum() == 3).assertTrue();
    }

}
