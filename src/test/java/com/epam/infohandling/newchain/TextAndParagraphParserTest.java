package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextAndParagraphParserTest {
    private static final String TEXT = "First sentence. Second, sentence! 2 1 + sentence?";

    private Component expectedComponent = new Composite();  // paragraph

    @Before
    public void init() {
        Component firstComponent = Lexeme.word("First");
        Component secondComponent = Lexeme.word("sentence.");

        Component firstSentence = new Composite(); // sentence
        firstSentence.addComponent(firstComponent);
        firstSentence.addComponent(secondComponent);

        Component thirdComponent = Lexeme.word("Second,");
        Component fourthComponent = Lexeme.word("sentence!");

        Component secondSentence = new Composite(); // sentence
        secondSentence.addComponent(thirdComponent);
        secondSentence.addComponent(fourthComponent);

        Component fifthComponent = Lexeme.expression("2 1 +");
        Component sixthComponent = Lexeme.word("sentence?");

        Component thirdSentence = new Composite(); // sentence
        thirdSentence.addComponent(fifthComponent);
        thirdSentence.addComponent(sixthComponent);


        expectedComponent.addComponent(firstSentence);
        expectedComponent.addComponent(secondSentence);
        expectedComponent.addComponent(thirdSentence);
    }

    @Test
    public void parse() {
        // given
        ChainOfParsers sentenceParser = new SentenceParser();
        ChainOfParsers paragraphParser = TextAndParagraphParser.paragraphParser(sentenceParser);

        // when
        Component actualComponent = paragraphParser.parse(TEXT);

        // then
        Assert.assertEquals(expectedComponent, actualComponent);
    }
}