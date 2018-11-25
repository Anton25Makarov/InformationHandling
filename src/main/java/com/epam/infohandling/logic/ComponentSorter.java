package com.epam.infohandling.logic;

import com.epam.infohandling.entities.Component;
import com.epam.infohandling.exception.GetChildrenFromLexemeException;
import org.apache.commons.lang3.StringUtils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Comparator;
import java.util.List;

public class ComponentSorter {
    private static final Logger LOGGER = LogManager.getLogger(ComponentSorter.class);
    private ComponentCloner cloner;

    public ComponentSorter(ComponentCloner cloner) {
        this.cloner = cloner;
    }

    public Component sortParagraphsByCountOfSentences(Component textComponent) {
        Component component = cloner.clone(textComponent);

        try {
            validateComponentText(component);
        } catch (GetChildrenFromLexemeException e) { // maybe better handle error in Director but i haven't Director
            LOGGER.error(e);
            return component;
        }

        List<Component> components = component.getChildren();

        components.sort(Comparator.comparingInt(paragraph -> paragraph.getChildren().size()));

        return component;
    }

    public Component sortSentencesByWordsLength(Component textComponent) {
        Component component = cloner.clone(textComponent);

        try {
            validateComponentText(component);
        } catch (GetChildrenFromLexemeException e) { // maybe better handle error in Director but i haven't Director
            LOGGER.error(e);
            return component;
        }

        List<Component> paragraphs = component.getChildren();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChildren();
            for (Component sentence : sentences) {
                List<Component> lexemes = sentence.getChildren();
                lexemes.sort(Comparator.comparingInt(lexeme -> lexeme.getValue().length()));
            }
        }

        return component;
    }

    public Component sortLexemesByCountOfSymbolOccurrenceByDecrease(Component textComponent, char symbol) {
        Component component = cloner.clone(textComponent);

        try {
            validateComponentText(component);
        } catch (GetChildrenFromLexemeException e) { // maybe better handle error in Director but i haven't Director
            LOGGER.error(e);
            return component;
        }

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

                    return secondLexemeValue.compareToIgnoreCase(firstLexemeValue);
                });
            }
        }
        return component;
    }

    private void validateComponentText(Component component)
            throws GetChildrenFromLexemeException {
        try {
            List<Component> paragraphs = component.getChildren();
            Component paragraph = paragraphs.get(0);
            List<Component> sentences = paragraph.getChildren();
            Component sentence = sentences.get(0);
            List<Component> lexemes = sentence.getChildren();
            Component lexeme = lexemes.get(0);
        } catch (UnsupportedOperationException | IndexOutOfBoundsException e) {
            throw new GetChildrenFromLexemeException("Inner component doesn't text component", e);
        }
    }
}
