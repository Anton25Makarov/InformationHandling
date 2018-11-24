package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends ChainOfParsers {
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";

     TextParser(ChainOfParsers successor) {
        super(successor);
    }


    @Override
    public Component parse(String text) {
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_PATTERN);
        Matcher paragraphMatcher = paragraphPattern.matcher(text);

        Component textComponent = new Composite();

        while (paragraphMatcher.find()) {
            String paragraph = paragraphMatcher.group();

            System.out.println();
            Component paragraphComponent = successor.parse(text);

            textComponent.addComponent(paragraphComponent);
        }
        return textComponent;
    }


}