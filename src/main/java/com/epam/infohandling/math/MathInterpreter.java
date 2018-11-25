package com.epam.infohandling.math;

import com.epam.infohandling.math.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathInterpreter {
    private List<MathExpression> mathExpressions;

    public MathInterpreter(String expression) {
        mathExpressions = new ArrayList<>();
        parse(expression);
    }


    private void parse(String expression) {
        for (String lexeme : expression.split(" ")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            switch (lexeme) {
                case "+":
                    mathExpressions.add(new TerminalExpressionPlus());
                    break;
                case "-":
                    mathExpressions.add(new TerminalExpressionMinus());
                    break;
                case "*":
                    mathExpressions.add(new TerminalExpressionMultiply());
                    break;
                case "/":
                    mathExpressions.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        mathExpressions.add(new NonTerminalExpressionNumber(scanner.nextInt()));
                    }
                    break;
            }
        }
    }

    public int calculate() {
        MathValuesStack mathValuesStack = new MathValuesStack();

        for (MathExpression terminal : mathExpressions) {
            terminal.interpret(mathValuesStack);
        }

        return mathValuesStack.popValue();
    }
}
