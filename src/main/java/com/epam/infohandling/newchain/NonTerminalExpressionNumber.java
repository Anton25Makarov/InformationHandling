package com.epam.infohandling.newchain;

public class NonTerminalExpressionNumber extends MathExpression {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
