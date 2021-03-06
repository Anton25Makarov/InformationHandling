package com.epam.infohandling.math.expression;

import com.epam.infohandling.math.MathValuesStack;

public class TerminalExpressionPlus extends MathExpression {
    @Override
    public void interpret(MathValuesStack mathValuesStack) {
        Integer firstValue = mathValuesStack.popValue();
        Integer secondValue = mathValuesStack.popValue();
        mathValuesStack.pushValue(secondValue + firstValue);
    }
}
