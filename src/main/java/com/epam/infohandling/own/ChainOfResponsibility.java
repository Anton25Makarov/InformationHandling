package com.epam.infohandling.own;

public interface ChainOfResponsibility {
    void requestProcess(String string, Component component);

    void setNextChain(ChainOfResponsibility nextChain);

    void setPreviousChain(ChainOfResponsibility previousChain);
}
