package com.epam.infohandling.newchain;

import com.epam.infohandling.classes1.Component;

public abstract class ChainOfParsers {
    protected ChainOfParsers successor;

    public ChainOfParsers(ChainOfParsers successor) {
        this.successor = successor;
    }

    public ChainOfParsers() {
    }

    public abstract Component parse(String text);
}
