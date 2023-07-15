package org.utils;

import java.io.Serializable;

public class TransactionContext implements Serializable {

    //store current State in the 2PC - like prepare, global commit ...
    private States currentState;

    private boolean carFlag;

    private boolean hotelFlag;

    private int coordinatorPort;

    private boolean answered;

    public TransactionContext(States currentState, boolean carFlag, boolean hotelFlag) {
        this.currentState = currentState;
        this.carFlag = carFlag;
        this.hotelFlag = hotelFlag;
    }

    public TransactionContext(States currentState, int coordinatorPort, boolean answered) {
        this.currentState = currentState;
        this.answered = answered;
        this.coordinatorPort = coordinatorPort;
    }

    public States getCurrentState() {
        return currentState;
    }

    public void setCurrentState(States currentState) {
        this.currentState = currentState;
    }

    public boolean isCarReceived() {
        return carFlag;
    }

    public void setCarReceived(boolean carReceived) {
        this.carFlag = carReceived;
    }

    public boolean isHotelReceived() {
        return hotelFlag;
    }

    public void setHotelReceived(boolean hotelReceived) {
        this.hotelFlag = hotelReceived;
    }

    public int getCoordinatorPort() {
        return coordinatorPort;
    }

    public void setCoordinatorPort(int coordinatorPort) {
        this.coordinatorPort = coordinatorPort;
    }
}
