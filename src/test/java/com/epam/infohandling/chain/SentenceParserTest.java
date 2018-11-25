package com.epam.infohandling.chain;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;
import com.epam.infohandling.entities.Lexeme;
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
    public void shouldParseSentenceToComponent() {
        // given
        ChainOfParsers sentenceParser = new SentenceParser();

        // when
        Component actualComponent = sentenceParser.parse(TEXT);

        // then
        Assert.assertEquals(expectedComponent, actualComponent);
    }
}