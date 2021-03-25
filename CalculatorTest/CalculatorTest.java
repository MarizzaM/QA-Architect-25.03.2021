package com.app;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void test_add_small_numbers() {

        Calculator calculator = new Calculator();

        assertEquals(calculator.add(CalculatorDAO.select("a"), CalculatorDAO.select("b")),
                CalculatorDAO.select("c"));
    }
}
