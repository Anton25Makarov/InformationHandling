package com.epam.infohandling.classes1;

import java.util.List;

public interface Component {
    void addComponent(Component comp);

    String getValue();

    List<Component> getChildren();
}
// из компонентов в текст Class TextRestorator