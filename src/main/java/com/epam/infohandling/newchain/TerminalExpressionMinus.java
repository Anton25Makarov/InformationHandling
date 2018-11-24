package com.epam.infohandling.newchain;

public class TerminalExpressionMinus extends MathExpression {
    @Override
    public void interpret(Context context) {
        Integer firstValue = context.popValue();
        Integer secondValue = context.popValue();
        context.pushValue(firstValue - secondValue);
    }
}
