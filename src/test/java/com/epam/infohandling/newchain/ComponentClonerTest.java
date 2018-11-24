package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComponentClonerTest {
    private Component initialComponent = new Composite();

    @Before
    public void setInitialComponent() {
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

        Component fifthComponent = Lexeme.expression("2 2 +");
        Component sixthComponent = Lexeme.word("sentence?");

        Component thirdSentence = new Composite(); // sentence
        thirdSentence.addComponent(fifthComponent);
        thirdSentence.addComponent(sixthComponent);


        initialComponent.addComponent(firstSentence);
        initialComponent.addComponent(secondSentence);
        initialComponent.addComponent(thirdSentence);
    }

    @Test
    public void shouldCloneExistingComponent() {
        // given
        ComponentCloner componentCloner = new ComponentCloner();

        // when
        Component cloningComponent = componentCloner.clone(initialComponent);

        // then
        Assert.assertEquals(initialComponent, cloningComponent);
    }
}