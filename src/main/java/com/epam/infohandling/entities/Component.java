package com.epam.infohandling.entities;

import java.util.List;

public interface Component {
    void addComponent(Component comp);

    String getValue();

    List<Component> getChildren();
}