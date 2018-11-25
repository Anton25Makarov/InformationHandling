package com.epam.infohandling.math.expression;

import com.epam.infohandling.math.MathValuesStack;

public abstract class MathExpression {
    public abstract void interpret(MathValuesStack mathValuesStack);
}
