package com.epam.infohandling.classes1;

import java.util.List;

// boolean isExpression или от лексемы 2 производных класса (Word, expression)

public class Lexeme implements Component, Value {
    private final String value;
    private boolean expression;

    private Lexeme(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, false);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, true);
    }

    public void addComponent(Component comp) {
        throw new UnsupportedOperationException();
    }

    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }

    public String getValue() {
        return value;
    }
}


