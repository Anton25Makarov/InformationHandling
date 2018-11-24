package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;
import org.junit.Assert;
import org.junit.Test;

public class TextAndParagraphParserTest {
    private static final String PARAGRAPH = "First sentence. Second, sentence! 2 1 + sentence?\n";
    private static final String TEXT = "    First sentence. 1 1 + sentence?\n" +
            "    Third sentence. Fourth sentence 2 3 * 4 + ok?\n" +
            "    Bye...\n";

    private Component expectedParagraph = new Composite();  // paragraph
    private Component expectedText = new Composite();  // whole text

    @Test
    public void shouldParseParagraph() {
        // given
        initParseParagraph();
        ChainOfParsers sentenceParser = new SentenceParser();
        ChainOfParsers paragraphParser = TextAndParagraphParser.paragraphParser(sentenceParser);

        // when
        Component actualComponent = paragraphParser.parse(PARAGRAPH);

        // then
        Assert.assertEquals(expectedParagraph, actualComponent);
    }

    @Test
    public void shouldParseText() {
        // given
        initParseText();
        ChainOfParsers sentenceParser = new SentenceParser();
        ChainOfParsers paragraphParser = TextAndParagraphParser.paragraphParser(sentenceParser);
        ChainOfParsers textParser = TextAndParagraphParser.textParser(paragraphParser);

        // when
        Component actualText = textParser.parse(TEXT);

        // then
        Assert.assertEquals(expectedText, actualText);
    }

    private void initParseParagraph() {
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


        expectedParagraph.addComponent(firstSentence);
        expectedParagraph.addComponent(secondSentence);
        expectedParagraph.addComponent(thirdSentence);
    }

    private void initParseText() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.expression("1 1 +");
        Component lexeme4 = Lexeme.word("sentence?");
        Component lexeme5 = Lexeme.word("Third");
        Component lexeme6 = Lexeme.word("sentence.");
        Component lexeme7 = Lexeme.word("Fourth");
        Component lexeme8 = Lexeme.word("sentence");
        Component lexeme9 = Lexeme.expression("2 3 * 4 +");
        Component lexeme10 = Lexeme.word("ok?");
        Component lexeme11 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        Component sentence2 = new Composite();
        Component sentence3 = new Composite();
        Component sentence4 = new Composite();
        Component sentence5 = new Composite();

        sentence1.addComponent(lexeme1);
        sentence1.addComponent(lexeme2);

        sentence2.addComponent(lexeme3);
        sentence2.addComponent(lexeme4);

        sentence3.addComponent(lexeme5);
        sentence3.addComponent(lexeme6);

        sentence4.addComponent(lexeme7);
        sentence4.addComponent(lexeme8);
        sentence4.addComponent(lexeme9);
        sentence4.addComponent(lexeme10);

        sentence5.addComponent(lexeme11);

        Component paragraph1 = new Composite();
        Component paragraph2 = new Composite();
        Component paragraph3 = new Composite();

        paragraph1.addComponent(sentence1);
        paragraph1.addComponent(sentence2);

        paragraph2.addComponent(sentence3);
        paragraph2.addComponent(sentence4);

        paragraph3.addComponent(sentence5);

        expectedText.addComponent(paragraph1);
        expectedText.addComponent(paragraph2);
        expectedText.addComponent(paragraph3);
    }
}