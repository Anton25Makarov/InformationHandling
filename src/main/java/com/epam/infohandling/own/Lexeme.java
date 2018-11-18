package com.epam.infohandling.own;

import java.util.Iterator;

public class Lexeme implements Component {
    private final String value;
    private boolean expression;

    private Lexeme(String value, boolean expression) {
        this.value = value;
        this.expression = expression;
    }

    public static Lexeme createWord(String value) {
        return new Lexeme(value, false);
    }

    public static Lexeme CreateExpression(String value) {
        return new Lexeme(value, true);
    }

    @Override
    public void addElement(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getElement(int index) {
        return this;
    }

    @Override
    public void parse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Component> getIterator() {
        throw new UnsupportedOperationException();
    }
}
