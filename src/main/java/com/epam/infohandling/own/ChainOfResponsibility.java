package com.epam.infohandling.own;

public interface ChainOfResponsibility {
    void setNextChain(ChainOfResponsibility nextChain);

    void requestProcess(String string);
}
