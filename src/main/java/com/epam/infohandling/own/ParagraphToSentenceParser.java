package com.epam.infohandling.own;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphToSentenceParser implements ChainOfResponsibility {
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";
    private static final String SENTENCE_PATTERN = "[ a-zA-Z1-9,;:()*/+-]+([.?!]|[.]{3})";

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
        if (text.matches(PARAGRAPH_PATTERN)) {

            Pattern sentencePattern = Pattern.compile(SENTENCE_PATTERN);
            Matcher sentenceMatcher = sentencePattern.matcher(text);

            while (sentenceMatcher.find()) {
                String sentence = sentenceMatcher.group();

                Component sentenceComponent = new Composite();

                previousChain.requestProcess(sentence, sentenceComponent);

                component.addElement(sentenceComponent);
            }
        } else {
            nextChain.requestProcess(text, component);
        }
    }
}
