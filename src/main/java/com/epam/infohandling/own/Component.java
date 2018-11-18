package com.epam.infohandling.own;

import java.util.Iterator;

public interface Component {
    public void addElement(Component component);

    public void removeElement(Component component);

    public Component getElement(int index);

    public void parse();

    public Iterator<Component> getIterator();
}
