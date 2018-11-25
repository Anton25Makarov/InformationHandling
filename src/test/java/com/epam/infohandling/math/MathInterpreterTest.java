package com.epam.infohandling.math;

import org.junit.Assert;
import org.junit.Test;

public class MathInterpreterTest {
    private static final String EXPRESSION = "2 4 + 6 * 2 / 3 -";
    private static final int EXPECTED_RESULT = 15;

    @Test
    public void calculate() {
        // given
        MathInterpreter mathInterpreter = new MathInterpreter(EXPRESSION);

        // when
        int result = mathInterpreter.calculate();

        // then
        Assert.assertEquals(EXPECTED_RESULT, result);
    }
}