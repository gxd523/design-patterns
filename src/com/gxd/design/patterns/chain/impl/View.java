package com.gxd.design.patterns.chain.impl;

import com.gxd.design.patterns.chain.Event;
import com.gxd.design.patterns.chain.EventHandler;

public class View extends EventHandler {
    @Override
    protected boolean consumeEvent(Event event) {
        System.out.println("View consume event");
        return true;
    }
}
