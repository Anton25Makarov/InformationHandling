package com.epam.infohandling.own;

public class SentenceToLexemeParser implements ChainOfResponsibility {
    ChainOfResponsibility chain;

    @Override
    public void setNextChain(ChainOfResponsibility nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void requestProcess(String string) {

    }
}
