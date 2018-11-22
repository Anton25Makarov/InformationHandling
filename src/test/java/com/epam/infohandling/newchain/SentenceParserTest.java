package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SentenceParserTest {
    private static final String TEXT = "Hello 22 8 + 6 * 5 - dear...";

    private Component expectedComponent;

    @Before
    public void init() {
        Component firstComponent = Lexeme.word("Hello");
        Component secondComponent = Lexeme.expression("22 8 + 6 * 5 -");
        Component thirdComponent = Lexeme.word("dear...");

        expectedComponent = new Composite();

        expectedComponent.addComponent(firstComponent);
        expectedComponent.addComponent(secondComponent);
        expectedComponent.addComponent(thirdComponent);
    }

    @Test
    public void parse() {
        // given
        ChainOfParsers sentenceParser = new SentenceParser();

        // when
        Component actualComponent = sentenceParser.parse(TEXT);

        // then
        Assert.assertEquals(expectedComponent, actualComponent);
    }
}