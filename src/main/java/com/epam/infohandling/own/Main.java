package com.epam.infohandling.own;

public class Main {
    public static void main(String[] args) {
        ChainOfResponsibility sentenceParser = new SentenceToLexemeParser();
        ChainOfResponsibility paragraphParser = new ParagraphToSentenceParser();
        ChainOfResponsibility fullTextParser = new FullTextToParagraphParser();

        sentenceParser.setNextChain(paragraphParser);
        paragraphParser.setNextChain(fullTextParser);

        fullTextParser.setPreviousChain(paragraphParser);
        paragraphParser.setPreviousChain(sentenceParser);

        String text = "    Hello, 23 3 + is twenty three! My name is Anton. I am from London.\n" +
                "    London is the capital of Great Britain!";

        Component component = new Composite();

        sentenceParser.requestProcess(text, component);

        System.out.println(component);
    }
}
// знаки припинания в слова?