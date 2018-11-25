package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogicTest {
    private static final char SYMBOL_FOR_COUNT_OF_OCCURRENCE = 'e';

    private ComponentCloner cloner = new ComponentCloner();
    private Logic logic = new Logic(cloner);
    private Component initComponent;
    private Component expectedComponent;

    @Before
    public void init() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.word("Second");
        Component lexeme4 = Lexeme.word("twice");
        Component lexeme5 = Lexeme.word("sentence?");
        Component lexeme6 = Lexeme.word("Third");
        Component lexeme7 = Lexeme.word("sentence.");
        Component lexeme8 = Lexeme.word("Fourth");
        Component lexeme9 = Lexeme.word("sentence");
        Component lexeme10 = Lexeme.word("and");
        Component lexeme11 = Lexeme.word("ok?");
        Component lexeme12 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        sentence1.addComponent(lexeme1);
        sentence1.addComponent(lexeme2);

        Component sentence2 = new Composite();
        sentence2.addComponent(lexeme3);
        sentence2.addComponent(lexeme4);
        sentence2.addComponent(lexeme5);

        Component sentence3 = new Composite();
        sentence3.addComponent(lexeme6);
        sentence3.addComponent(lexeme7);

        Component sentence4 = new Composite();
        sentence4.addComponent(lexeme8);
        sentence4.addComponent(lexeme9);
        sentence4.addComponent(lexeme10);
        sentence4.addComponent(lexeme11);

        Component sentence5 = new Composite();
        sentence5.addComponent(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.addComponent(sentence1);
        paragraph1.addComponent(sentence2);

        Component paragraph2 = new Composite();
        paragraph2.addComponent(sentence3);
        paragraph2.addComponent(sentence4);

        Component paragraph3 = new Composite();
        paragraph3.addComponent(sentence5);

        initComponent = new Composite();
        initComponent.addComponent(paragraph1);
        initComponent.addComponent(paragraph2);
        initComponent.addComponent(paragraph3);
    }

    @Test
    public void shouldSortParagraphsByCountOfSentences() {
        // given
        initForSortParagraphsByCountOfSentencesTest();

        // when
        Component actualComponent = logic.sortParagraphsByCountOfSentences(initComponent);

        // then
        Assert.assertEquals(actualComponent, expectedComponent);
    }

    @Test
    public void shouldSortSentencesByWordsLength() {
        // given
        initForSortSentencesByWordsLengthTest();

        // when
        Component actualComponent = logic.sortSentencesByWordsLength(initComponent);

        // then
        Assert.assertEquals(actualComponent, expectedComponent);
    }

    @Test
    public void sortLexemesByCountOfSymbolOccurrenceByDecrease() {
        // given
        initForSortLexemesByCountOfSymbolOccurrenceByDecreaseTest();

        // when
        Component actualComponent =
                logic.sortLexemesByCountOfSymbolOccurrenceByDecrease(initComponent, SYMBOL_FOR_COUNT_OF_OCCURRENCE);

        // then
        Assert.assertEquals(actualComponent, expectedComponent);
    }

    private void initForSortParagraphsByCountOfSentencesTest() {
        Component lexeme1 = Lexeme.word("Bye...");
        Component lexeme2 = Lexeme.word("First");
        Component lexeme3 = Lexeme.word("sentence.");
        Component lexeme4 = Lexeme.word("Second");
        Component lexeme5 = Lexeme.word("twice");
        Component lexeme6 = Lexeme.word("sentence?");
        Component lexeme7 = Lexeme.word("Third");
        Component lexeme8 = Lexeme.word("sentence.");
        Component lexeme9 = Lexeme.word("Fourth");
        Component lexeme10 = Lexeme.word("sentence");
        Component lexeme11 = Lexeme.word("and");
        Component lexeme12 = Lexeme.word("ok?");

        Component sentence1 = new Composite();
        sentence1.addComponent(lexeme1);

        Component sentence2 = new Composite();
        sentence2.addComponent(lexeme2);
        sentence2.addComponent(lexeme3);

        Component sentence3 = new Composite();
        sentence3.addComponent(lexeme4);
        sentence3.addComponent(lexeme5);
        sentence3.addComponent(lexeme6);

        Component sentence4 = new Composite();
        sentence4.addComponent(lexeme7);
        sentence4.addComponent(lexeme8);

        Component sentence5 = new Composite();
        sentence5.addComponent(lexeme9);
        sentence5.addComponent(lexeme10);
        sentence5.addComponent(lexeme11);
        sentence5.addComponent(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.addComponent(sentence1);

        Component paragraph2 = new Composite();
        paragraph2.addComponent(sentence2);
        paragraph2.addComponent(sentence3);

        Component paragraph3 = new Composite();
        paragraph3.addComponent(sentence4);
        paragraph3.addComponent(sentence5);

        expectedComponent = new Composite();
        expectedComponent.addComponent(paragraph1);
        expectedComponent.addComponent(paragraph2);
        expectedComponent.addComponent(paragraph3);
    }

    private void initForSortSentencesByWordsLengthTest() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.word("twice");
        Component lexeme4 = Lexeme.word("Second");
        Component lexeme5 = Lexeme.word("sentence?");
        Component lexeme6 = Lexeme.word("Third");
        Component lexeme7 = Lexeme.word("sentence.");
        Component lexeme8 = Lexeme.word("and");
        Component lexeme9 = Lexeme.word("ok?");
        Component lexeme10 = Lexeme.word("Fourth");
        Component lexeme11 = Lexeme.word("sentence");
        Component lexeme12 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        sentence1.addComponent(lexeme1);
        sentence1.addComponent(lexeme2);

        Component sentence2 = new Composite();
        sentence2.addComponent(lexeme3);
        sentence2.addComponent(lexeme4);
        sentence2.addComponent(lexeme5);

        Component sentence3 = new Composite();
        sentence3.addComponent(lexeme6);
        sentence3.addComponent(lexeme7);

        Component sentence4 = new Composite();
        sentence4.addComponent(lexeme8);
        sentence4.addComponent(lexeme9);
        sentence4.addComponent(lexeme10);
        sentence4.addComponent(lexeme11);

        Component sentence5 = new Composite();
        sentence5.addComponent(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.addComponent(sentence1);
        paragraph1.addComponent(sentence2);

        Component paragraph2 = new Composite();
        paragraph2.addComponent(sentence3);
        paragraph2.addComponent(sentence4);

        Component paragraph3 = new Composite();
        paragraph3.addComponent(sentence5);

        expectedComponent = new Composite();
        expectedComponent.addComponent(paragraph1);
        expectedComponent.addComponent(paragraph2);
        expectedComponent.addComponent(paragraph3);
    }

    private void initForSortLexemesByCountOfSymbolOccurrenceByDecreaseTest() {
        Component lexeme1 = Lexeme.word("sentence.");
        Component lexeme2 = Lexeme.word("First");

        Component lexeme3 = Lexeme.word("sentence?");
        Component lexeme4 = Lexeme.word("twice");
        Component lexeme5 = Lexeme.word("Second");

        Component lexeme6 = Lexeme.word("sentence.");
        Component lexeme7 = Lexeme.word("Third");

        Component lexeme8 = Lexeme.word("sentence");
        Component lexeme9 = Lexeme.word("ok?");
        Component lexeme10 = Lexeme.word("Fourth");
        Component lexeme11 = Lexeme.word("and");

        Component lexeme12 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        sentence1.addComponent(lexeme1);
        sentence1.addComponent(lexeme2);

        Component sentence2 = new Composite();
        sentence2.addComponent(lexeme3);
        sentence2.addComponent(lexeme4);
        sentence2.addComponent(lexeme5);

        Component sentence3 = new Composite();
        sentence3.addComponent(lexeme6);
        sentence3.addComponent(lexeme7);

        Component sentence4 = new Composite();
        sentence4.addComponent(lexeme8);
        sentence4.addComponent(lexeme9);
        sentence4.addComponent(lexeme10);
        sentence4.addComponent(lexeme11);

        Component sentence5 = new Composite();
        sentence5.addComponent(lexeme12);

        Component paragraph1 = new Composite();
        paragraph1.addComponent(sentence1);
        paragraph1.addComponent(sentence2);

        Component paragraph2 = new Composite();
        paragraph2.addComponent(sentence3);
        paragraph2.addComponent(sentence4);

        Component paragraph3 = new Composite();
        paragraph3.addComponent(sentence5);

        expectedComponent = new Composite();
        expectedComponent.addComponent(paragraph1);
        expectedComponent.addComponent(paragraph2);
        expectedComponent.addComponent(paragraph3);
    }
}