package com.epam.infohandling.math;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;
import com.epam.infohandling.entities.Lexeme;

import java.util.List;

public class ExpressionCalculator {

    public Component calculateExpressions(Component parentComponent) {
        Component component;

        try {
            List<Component> components = parentComponent.getChildren();
            component = new Composite();
            for (Component listComponent : components) {
                Component temp = calculateExpressions(listComponent);
                component.addComponent(temp);
            }
        } catch (UnsupportedOperationException e) { // lexemes
            if (((Lexeme) parentComponent).isExpression()) {
                String expression = parentComponent.getValue();

                MathInterpreter interpreter = new MathInterpreter(expression);
                int expressionResult = interpreter.calculate();
                String word = String.valueOf(expressionResult);

                component = Lexeme.word(word);
            } else {
                String word = parentComponent.getValue();
                component = Lexeme.word(word);
            }
        }

        return component;
    }
}