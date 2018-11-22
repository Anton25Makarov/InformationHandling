package com.epam.infohandling.own;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullTextToParagraphParser implements ChainOfResponsibility {
    private static final String FULL_TEXT_PATTERN = "([\\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()\\n\\s\\t*/+-]+([.?!]|[.]{3})";
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";

    private ChainOfResponsibility nextChain;
    private ChainOfResponsibility previousChain;

    @Override
    public void setNextChain(ChainOfResponsibility nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void setPreviousChain(ChainOfResponsibility previousChain) {
        this.previousChain = previousChain;
    }

    @Override
    public void requestProcess(String text, Component component) {
        if (text.matches(FULL_TEXT_PATTERN)) {

            Pattern paragraphPattern = Pattern.compile(PARAGRAPH_PATTERN);
            Matcher paragraphMatcher = paragraphPattern.matcher(text);

            while (paragraphMatcher.find()) {
                Component sentenceComponent = new Composite();
                String paragraph = paragraphMatcher.group();

                previousChain.requestProcess(paragraph, sentenceComponent);

                component.addElement(sentenceComponent);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
