package main;


import lombok.SneakyThrows;
import main.test.anotations.AfterSuite;
import main.test.anotations.BeforeSuite;
import main.test.anotations.Test;

import static main.test.utils.Assertions.assertEquals;

public class TestClass {

    @BeforeSuite
    private void beforeSuite() {
        System.out.print("Before Suite");
        someWork();
    }

    @AfterSuite
    private void afterSuite() {
        System.out.print("After Suite");
        someWork();
    }

    @Test(order = 1)
    private void testOnCalcAdd() {
        System.out.print("-1\t");
        int expected = 3;
        int actual = Calc.add(1, 2);
        assertEquals(expected, actual);
    }

    @Test(order = 6)
    private void testOnCalcSub() {
        System.out.print("-6\t");
        int expected = -1;
        int actual = Calc.sub(1, 2);
        assertEquals(expected, actual);
    }

    @Test(order = 2)
    private void testOnCalcMul() {
        System.out.print("-2\t");
        int expected = 2;
        int actual = Calc.mul(1, 2);
        assertEquals(expected, actual);
    }

    @Test(order = 7)
    private void testOnCalcDiv() {
        System.out.print("-7\t");
        int expected = 2;
        int actual = Calc.div(4, 2);
        assertEquals(expected, actual);
    }

    @Test(order = 3)
    private void testOnCalcMod() {
        System.out.print("-3\t");
        int expected = 1;
        int actual = Calc.mod(5, 2);
        assertEquals(expected, actual);
    }

    @Test(order = 5)
    private void testOnCalcPower() {
        System.out.print("-5\t");
        int expected = 8;
        int actual = Calc.pow(2, 3);
        assertEquals(expected, actual);
    }

    @Test(order = 4)
    private void testOnCalcFactorial() {
        System.out.print("-4\t");
        int expected = 120;
        int actual = Calc.fact(5);
        assertEquals(expected, actual);
    }

    @SneakyThrows
    private void someWork() {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.print(".");
        }
        System.out.println();
    }
}
