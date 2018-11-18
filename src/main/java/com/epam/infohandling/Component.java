package com.epam.infohandling;

import java.util.List;

public interface Component {
    void addComponent(Component comp);

    List<Component> getChildren();
}
// из компонентов в текст Class TextRestorator