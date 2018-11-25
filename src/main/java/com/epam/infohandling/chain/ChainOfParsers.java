package com.epam.infohandling.chain;

import com.epam.infohandling.entities.Component;

public abstract class ChainOfParsers {
    protected ChainOfParsers successor;

    public ChainOfParsers(ChainOfParsers successor) {
        this.successor = successor;
    }

    public ChainOfParsers() {
    }

    public abstract Component parse(String text);
}
