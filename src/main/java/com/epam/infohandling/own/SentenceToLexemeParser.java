package com.epam.infohandling.own;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceToLexemeParser implements ChainOfResponsibility {
    private static final String SENTENCE_PATTERN = "[ a-zA-Z1-9,;:()*/+-]+([.?!]|[.]{3})";
    private static final String LEXEME_PATTERN = "([a-zA-z,:;()]|[+-/*1-9])+";
    private static final String WORD_PATTERN = "[a-zA-z,:;()]+([.!?]|[.]{3})?";
    private static final String EXPRESSION_PATTERN = "[+-/*1-9]+";

    private ChainOfResponsibility nextChain;
    private ChainOfResponsibility previousChain;

    @Override
    public void setNextChain(ChainOfResponsibility nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void setPreviousChain(ChainOfResponsibility previousChain) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void requestProcess(String text, Component component) {
        if (text.matches(SENTENCE_PATTERN)) {

            Pattern lexemePattern = Pattern.compile(LEXEME_PATTERN);
            Matcher lexemeMatcher = lexemePattern.matcher(text);

            String wordOrExpression;

            while (lexemeMatcher.find()) {
                wordOrExpression = lexemeMatcher.group();

                Component lexemeComponent = null;

                if (wordOrExpression.matches(WORD_PATTERN)) {
                    lexemeComponent = Lexeme.createWord(wordOrExpression);
                }
                if (wordOrExpression.matches(EXPRESSION_PATTERN)) {
                    lexemeComponent = Lexeme.CreateExpression(wordOrExpression);
                }

                if (lexemeComponent != null) { // lexemeComponent is word or expression
                    component.addElement(lexemeComponent);
                }
            }
        } else {
            nextChain.requestProcess(text, component);
        }
    }
}
