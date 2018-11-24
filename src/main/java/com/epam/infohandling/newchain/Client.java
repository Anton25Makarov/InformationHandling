package com.epam.infohandling.newchain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private List<MathExpression> mathExpressions;

    public Client(String expression) {
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
                    mathExpressions.add(new TerminalExpressionDevide());
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
    public Number calculate(){
        Context context = new Context();

        for (MathExpression terminal : mathExpressions) {
            terminal.interpret(context);
        }

        return context.popValue();
    }
}
