package com.epam.infohandling.own;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void addElement(Component component) {
        components.add(component);
    }

    @Override
    public void removeElement(Component component) {
        components.remove(component);
    }

    @Override
    public Component getElement(int index) {
        return components.get(index);
    }

    @Override
    public void parse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Component> getIterator() {
        return components.iterator();
    }
}
