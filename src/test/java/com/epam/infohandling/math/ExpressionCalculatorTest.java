package com.epam.infohandling.math;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.entities.Composite;
import com.epam.infohandling.entities.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionCalculatorTest {
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
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();

        // when
        Component actualComponent = expressionCalculator.calculateExpressions(initialComponent);

        // then
        Assert.assertEquals(expectedComponent, actualComponent);
    }
}