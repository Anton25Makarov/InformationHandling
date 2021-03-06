package com.epam.infohandling.entities;

import java.util.List;
import java.util.Objects;

public class Lexeme implements Component {
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


    @Override
    public String getValue() {
        return value;
    }

    public boolean isExpression() {
        return expression;
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