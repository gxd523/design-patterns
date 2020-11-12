package com.gxd.design.patterns.state;

public class Context {
    public final static State OPEN_STATE = new OpenState();
    public final static State CLOSE_STATE = new CloseState();
    public final static State RUN_STATE = new RunState();
    public final static State STOP_STATE = new StopState();

    private State currentState;

    public void setCurrentState(State state) {
        currentState = state;
        currentState.setContext(this);
    }

    public void open() {
        currentState.open();
    }

    public void close() {
        currentState.close();
    }

    public void run() {
        currentState.run();
    }

    public void stop() {
        currentState.stop();
    }
}
