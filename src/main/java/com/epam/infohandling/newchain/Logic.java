package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;

public class Logic {
    private ComponentCloner cloner;

    public Logic(ComponentCloner cloner) {
        this.cloner = cloner;
    }

    public Component sortParagraphsByCountOfSentences(Component textComponent) {
        Component component = cloner.clone(textComponent);

        try {
            List<Component> components = component.getChildren(); // paragraphs

            components.sort(Comparator.comparingInt(paragraph -> paragraph.getChildren().size()));
        } catch (UnsupportedOperationException e) {
            System.out.println("to sort by paragraph you should use textComponent "); // write log
        }


        return component;
    }

    public Component sortSentencesByWordsLength(Component textComponent) {
        Component component = cloner.clone(textComponent);

        try {
            List<Component> paragraphs = component.getChildren(); // paragraphs

            for (Component paragraph : paragraphs) {
                List<Component> sentences = paragraph.getChildren();
                for (Component sentence : sentences) {
                    List<Component> lexemes = sentence.getChildren();
                    lexemes.sort(Comparator.comparingInt(lexeme -> lexeme.getValue().length()));
                }
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("to sort by paragraph you should use textComponent "); // write log
        }
        return component;
    }

    public Component sortLexemesByCountOfSymbolOccurrenceByDecrease(Component textComponent, char symbol) {
        Component component = cloner.clone(textComponent);

        List<Component> paragraphs = component.getChildren(); // paragraphs

        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChildren();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChildren();
                lexemes.sort((firstLexeme, secondLexeme) -> {

                    String firstLexemeValue = firstLexeme.getValue();
                    String secondLexemeValue = secondLexeme.getValue();

                    int firstLexemeSymbolOccurrenceCount =
                            StringUtils.countMatches(firstLexemeValue, String.valueOf(symbol));
                    int secondLexemeSymbolOccurrenceCount =
                            StringUtils.countMatches(secondLexemeValue, String.valueOf(symbol));

                    if (firstLexemeSymbolOccurrenceCount != secondLexemeSymbolOccurrenceCount) {
                        return secondLexemeSymbolOccurrenceCount - firstLexemeSymbolOccurrenceCount;
                    }

                    return secondLexemeValue.compareTo(firstLexemeValue);
                });
                System.out.println("Lexeme: " + lexemes);
            }
        }
        return component;
    } // add try
}
