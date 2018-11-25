package com.epam.infohandling.math.expression;

import com.epam.infohandling.math.MathValuesStack;

public class NonTerminalExpressionNumber extends MathExpression {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(MathValuesStack mathValuesStack) {
        mathValuesStack.pushValue(number);
    }
}
