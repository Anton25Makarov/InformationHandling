package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;

import java.util.List;

public class ComponentCloner {

    public Component clone(Component parentComponent) {
        Component comp;

        try {
            List<Component> components = parentComponent.getChildren();
            comp = new Composite();
            for (Component component : components) {
                Component temp = clone(component);
                comp.addComponent(temp);
            }
        } catch (UnsupportedOperationException e) { // lexemes
            if (((Lexeme) parentComponent).isExpression()) {
                String expression = parentComponent.getValue();
                comp = Lexeme.expression(expression);
            } else {
                String word = parentComponent.getValue();
                comp = Lexeme.word(word);
            }
        }

        return comp;
    }
}
