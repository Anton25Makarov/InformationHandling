package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import com.epam.infohandling.classes1.Composite;
import com.epam.infohandling.classes1.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Component initialComponent;
    private Component expectedComponent;

    @Before
    public void setInitialComponent() {
        Component firstComponent = Lexeme.word("Hello");
        Component secondComponent = Lexeme.expression("2 7 + 3 * 4 -");
        Component thirdComponent = Lexeme.word("is");
        Component fourthComponent = Lexeme.word("twenty");
        Component fifthComponent = Lexeme.word("three.");

        initialComponent = new Composite();

        initialComponent.addComponent(firstComponent);
        initialComponent.addComponent(secondComponent);
        initialComponent.addComponent(thirdComponent);
        initialComponent.addComponent(fourthComponent);
        initialComponent.addComponent(fifthComponent);
    }

    @Before
    public void setExpectedComponent() {
        Component firstComponent = Lexeme.word("Hello");
        Component secondComponent = Lexeme.word("23");
        Component thirdComponent = Lexeme.word("is");
        Component fourthComponent = Lexeme.word("twenty");
        Component fifthComponent = Lexeme.word("three.");

        expectedComponent = new Composite();

        expectedComponent.addComponent(firstComponent);
        expectedComponent.addComponent(secondComponent);
        expectedComponent.addComponent(thirdComponent);
        expectedComponent.addComponent(fourthComponent);
        expectedComponent.addComponent(fifthComponent);
    }

    @Test
    public void shouldCalculateExpressionsInComponent() {
        // given
        Calculator calculator = new Calculator();

        // when
        Component actualComponent = calculator.calculateExpressions(initialComponent);

        // then
        Assert.assertEquals(expectedComponent, actualComponent);
    }
}