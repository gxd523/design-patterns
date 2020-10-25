package com.gxd.design.patterns.chain.event.impl;

import com.gxd.design.patterns.chain.event.Event;
import com.gxd.design.patterns.chain.event.EventHandler;

public class Activity extends EventHandler {
    @Override
    protected boolean consumeEvent(Event event) {
        return false;
    }
}
