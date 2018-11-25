package com.epam.infohandling.logic;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;
import com.epam.infohandling.entities.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextRestoratorTest {
    private static final String EXPECTED_TEXT = "\tFirst sentence. 1 1 + sentence?\n" +
            "\tThird sentence. Fourth sentence 2 3 * 4 + ok?\n" +
            "\tBye...\n\t";

    private Component component;

    @Before
    public void init() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.expression("1 1 +");
        Component lexeme4 = Lexeme.word("sentence?");
        Component lexeme5 = Lexeme.word("Third");
        Component lexeme7 = Lexeme.word("Fourth");
        Component lexeme6 = Lexeme.word("sentence.");
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

        component = new Composite();
        component.addComponent(paragraph1);
        component.addComponent(paragraph2);
        component.addComponent(paragraph3);
    }

    @Test
    public void shouldParseComponentToText() {
        // given
        TextRestorator textRestorator = new TextRestorator();

        // when
        String actualText = textRestorator.parseToString(component);

        // then
        Assert.assertEquals(EXPECTED_TEXT, actualText);
    }
}