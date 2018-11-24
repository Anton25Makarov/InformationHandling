package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;

public class TextRestorator {

    public String parseToString(Component component) {
        String text = "\t";
        text += component.getValue();

        text = text.replace("   ", "\n\t");
        text = text.replace("  ", " ");

        return text;
    }
}
