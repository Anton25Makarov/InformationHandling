package com.epam.infohandling.classes1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> components;

    public Composite() {
        this.components = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public String getValue() {
        StringBuilder text = new StringBuilder();
        for (Component component: components){
            text.append(component.getValue()).append(" ");
        }
        return text.toString();
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }
}
