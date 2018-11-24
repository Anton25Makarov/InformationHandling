package com.epam.infohandling.own;

public class Main {
    public static void main(String[] args) {
        /*ChainOfResponsibility sentenceParser = new SentenceToLexemeParser();
        ChainOfResponsibility paragraphParser = new ParagraphToSentenceParser();
        ChainOfResponsibility fullTextParser = new FullTextToParagraphParser();

        sentenceParser.setNextChain(paragraphParser);
        paragraphParser.setNextChain(fullTextParser);

        fullTextParser.setPreviousChain(paragraphParser);
        paragraphParser.setPreviousChain(sentenceParser);

        String text = "    Hello, 23 3 + is twenty six! My name is Anton. I am from London.\n" +
                "    London is the capital of Great Britain!";

        Component component = new Composite();

        sentenceParser.requestProcess(text, component);

        System.out.println(component);

        StringBuilder string = new StringBuilder();

        component.addValueToString(string);

        System.out.println("MyString: " + string);*/


        /*String expression = "8 2 7 4 + * -"; // expression in polska form
        MathInterpreter interpreter = new MathInterpreter(expression);
        System.out.println("[ " + expression + " ] = " + interpreter.calculate());*/


    }
}
// знаки припинания в слова?