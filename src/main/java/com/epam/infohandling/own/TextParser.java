/*
package com.epam.infohandling.own;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    public static final String REGEX_LISTING = "\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITH_LISTING = "(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITHOUT_LISTING = "\\t(.+))([^((Start listing)([^\\t]+)(End listing))]";
    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    public static final String REGEX_EMPTY = ".]*";

    public Composite parse(*/
/*String path*//*
) {
        String text = initialization(*/
/*path*//*
);
        Composite wholeText = new Composite();
        wholeText = parseToParagraph(wholeText, text);
        return wholeText;
    }

    // public void print(){
    //
    // }
    private String initialization(*/
/*final String path*//*
) {
        String text = "";
       */
/* try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str); // String with all text
            // System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*//*

        return text;
    }

    private Composite parseToParagraph(Composite wholeText, String text) {
        // parse to paragraph
        Composite paragraphList = new Composite();
        Pattern pattertParagraph = Pattern
                .compile(REGEX_PARAGRAPH_WITH_LISTING);
        Lexeme paragraphLeaf = null;
        String paragraph = "";
        // System.out.print(text);
        Matcher matcher = pattertParagraph.matcher(text);
        while (matcher.find()) {
            paragraph = matcher.group();
//          System.out.print(paragraph);
            if (Pattern.matches(REGEX_LISTING, paragraph)) {
                // if listing - add to list without parsing
                paragraphLeaf = Lexeme.createWord(paragraph);
//                paragraphLeaf = new Lexeme(paragraph);
                System.out.print(paragraphLeaf);
                paragraphList.addElement(paragraphLeaf);
            } else {
                System.out.print(paragraph);
                paragraphList = parseToSentense(paragraphList, paragraph);
            }
            wholeText.addElement(paragraphList);
        }

        return wholeText;
    }

    private Composite parseToSentense(Composite paragraphList,
                                          String paragraph) {
        // parse to sentence
        Composite sentenceList = new Composite();
        Pattern pattertSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher m2 = pattertSentence.matcher(paragraph);
        String sentence = "";
        while (m2.find()) {
            sentence = m2.group();
            sentenceList = parseToWord(sentenceList, sentence);
            // System.out.print(sentence);
            paragraphList.addElement(sentenceList);
        }
        return paragraphList;
    }

    private Composite parseToWord(Composite sentenceList,
                                      String sentence) {
        // parse to word
        Pattern pattertWord = Pattern.compile(REGEX_WORD);
        String word = "";
        Matcher matcher = pattertWord.matcher(sentence);
        Composite wordList = new Composite();
        while (matcher.find()) {
            word = matcher.group();
            // System.out.print(word);
            wordList = parseToSignAndWord(wordList, word);
            sentenceList.addElement(wordList);
        }
        return sentenceList;
    }

    private CompositePart parseToSignAndWord(CompositePart wordList, String word) {
        // parse to sign and word
        Pattern pattern = Pattern.compile(REGEX_WORD_AND_SIGN);
        String wordSign = "";
        Matcher matcher = pattern.matcher(word);
        CompositePart wordSignList = new CompositePart();
        while (matcher.find()) {
            wordSign = matcher.group();
            wordSignList = parseToSymbol(wordSignList, wordSign);
            wordList.addElement(wordSignList);
        }
        return wordList;
    }

    private CompositePart parseToSymbol(CompositePart wordSignList,
                                        String wordSign) {
        // parse to symbol
        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        String symbol = "";
        Matcher matcher = pattern.matcher(wordSign);
        LeafPart symbolList;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolList = new LeafPart(symbol);
            // System.out.print(symbol);
        }
        return wordSignList;
    }
}
*/
