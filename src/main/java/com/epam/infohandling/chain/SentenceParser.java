package com.epam.infohandling.chain;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;
import com.epam.infohandling.entities.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends ChainOfParsers {
    private static final String WORD_PATTERN = "[a-zA-Z,:;']+([.]{3}|[!?.])?";
    private static final String EXPRESSION_PATTERN = "[\\d]+[ \\d/*+-=]+[\\d/*+-=]+";
    private static final String LEXEME_PATTERN = "(" + WORD_PATTERN + ")|(" + EXPRESSION_PATTERN + ")";
    
    @Override
    public Component parse(String text) {
        Pattern lexemePattern = Pattern.compile(LEXEME_PATTERN);
        Matcher lexemeMatcher = lexemePattern.matcher(text);

        Component sentenceComponent = new Composite();

        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();

            Component lexemeComponent = null;

            if (lexeme.matches(WORD_PATTERN)) {
                lexemeComponent = Lexeme.word(lexeme);
            } else if (lexeme.matches(EXPRESSION_PATTERN)) {
                lexemeComponent = Lexeme.expression(lexeme);
            }

            if (lexemeComponent != null) { // not a word and not an expression
                sentenceComponent.addComponent(lexemeComponent);
            }
        }
        return sentenceComponent;
    }
}
