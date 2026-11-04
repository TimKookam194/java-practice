package com.tim.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void addShouldReturnSum() {
        assertEquals(5, new Calculator().add(2, 3));
    }
}