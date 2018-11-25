package com.epam.infohandling.logic;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;
import com.epam.infohandling.entities.Lexeme;

import java.util.List;

public class ComponentCloner {

    public Component clone(Component parentComponent) {
        Component component;

        try {
            List<Component> components = parentComponent.getChildren();
            component = new Composite();
            for (Component composite : components) {
                Component temp = clone(composite);
                component.addComponent(temp);
            }
        } catch (UnsupportedOperationException e) { // lexemes
            if (((Lexeme) parentComponent).isExpression()) {
                String expression = parentComponent.getValue();
                component = Lexeme.expression(expression);
            } else {
                String word = parentComponent.getValue();
                component = Lexeme.word(word);
            }
        }

        return component;
    }
}
