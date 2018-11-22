package com.epam.infohandling.classes1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    List<Component> components;

    public Composite() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getChildren() {
        return null;
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
