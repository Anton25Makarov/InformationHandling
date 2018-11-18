package com.epam.infohandling.own;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullTextToParaghraphParser implements ChainOfResponsibility {
    private static final String WHOLE_TEXT_PATTERN = "([ ]{4}|\\t)[ .,a-zA-Z0-9\\n\\t?!+=*/]+([.]|[...]|[?]|[!])$";
    private static final String PARAGRAPH_PATTERN = "([ ]{4}|\\t)[ .,a-zA-Z0-9\\t?!+=*/]+([.]|[...]|[?]|[!])$";

    private ChainOfResponsibility chain;

    public Component parse(String text) {
        Component wholeText = new Composite();


        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextChain(ChainOfResponsibility nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void requestProcess(String string) {
        // if matches to pattern request, else chain.requestProcess(String) ...

        if(string.matches(WHOLE_TEXT_PATTERN)){
            Pattern pattertParagraph = Pattern
                    .compile(PARAGRAPH_PATTERN);
//            LeafPart paragraphLeaf = null;
//            String paragraph = "";
            Matcher matcher = pattertParagraph.matcher(string);
            //while(mather.find...){
            //  ChainOfResp. ch = new Chain(string) // like in start
            //}
        }

    }
}
