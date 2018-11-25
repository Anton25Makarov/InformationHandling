package com.epam.infohandling.logic;

import com.epam.infohandling.entities.Component;

public class TextRestorator {

    public String parseToString(Component component) {
        String text = "\t";
        text += component.getValue();

        text = text.replace("   ", "\n\t");
        text = text.replace("  ", " ");

        return text;
    }
}
