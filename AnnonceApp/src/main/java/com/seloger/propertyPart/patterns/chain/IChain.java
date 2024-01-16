package com.seloger.propertyPart.patterns.chain;

public interface IChain <T>{
    void handle(T t);
    void handleTwo(T t);
}
