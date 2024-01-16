package com.seloger.propertyPart.patterns.chain;

import java.util.List;

public interface Handler <T>{
    boolean handle(T request);
    boolean handleTwo(T request);
}
