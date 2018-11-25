package com.epam.infohandling.chain;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAndParagraphParser extends ChainOfParsers {
    private static final String SENTENCE_PATTERN = "[ a-zA-Z1-9,;:()*/+-]+([.]{3}|[.?!])";
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";
    private boolean isText;

    private TextAndParagraphParser(ChainOfParsers successor, boolean isText) {
        super(successor);
        this.isText = isText;
    }

    public static TextAndParagraphParser paragraphParser(ChainOfParsers successor) {
        return new TextAndParagraphParser(successor, false);
    }

    public static TextAndParagraphParser textParser(ChainOfParsers successor) {
        return new TextAndParagraphParser(successor, true);
    }

    @Override
    public Component parse(String text) {
        Pattern paragraphOrSentencePattern = choosePattern();
        Matcher paragraphOrSentenceMatcher = paragraphOrSentencePattern.matcher(text);

        Component TextOrParagraphComponent = new Composite();

        while (paragraphOrSentenceMatcher.find()) {
            String paragraphOrSentence = paragraphOrSentenceMatcher.group();

            Component paragraphOrSentenceComponent = successor.parse(paragraphOrSentence);

            TextOrParagraphComponent.addComponent(paragraphOrSentenceComponent);
        }

        return TextOrParagraphComponent;
    }

    private Pattern choosePattern() {
        if (isText) {
            return Pattern.compile(PARAGRAPH_PATTERN);
        } else {
            return Pattern.compile(SENTENCE_PATTERN);
        }
    }
}
