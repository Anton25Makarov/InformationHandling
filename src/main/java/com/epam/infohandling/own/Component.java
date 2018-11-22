package com.epam.infohandling.own;

import java.util.Iterator;
import java.util.List;

public interface Component {
    void addElement(Component component);

    void addValueToString(StringBuilder string);

    List<Component> getChildren();

    void removeElement(Component component);

    Component getElement(int index);

    void parse();

    Iterator<Component> getIterator();
}
