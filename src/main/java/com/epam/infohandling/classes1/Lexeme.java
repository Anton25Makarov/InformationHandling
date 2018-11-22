package com.epam.infohandling.classes1;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return expression == lexeme.expression &&
                Objects.equals(value, lexeme.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, expression);
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "value='" + value + '\'' +
                ", expression=" + expression +
                '}';
    }
}


