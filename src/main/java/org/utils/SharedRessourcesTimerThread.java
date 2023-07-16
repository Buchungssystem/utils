package org.utils;

import java.io.Serializable;

public class SharedRessourcesTimerThread implements Serializable {

    private volatile boolean interrupt;

    public SharedRessourcesTimerThread(boolean interrupt){
        this.interrupt = interrupt;
    }

    public boolean isInterrupt() {
        return interrupt;
    }

    public void setInterrupt(boolean interrupt) {
        this.interrupt = interrupt;
    }
}
