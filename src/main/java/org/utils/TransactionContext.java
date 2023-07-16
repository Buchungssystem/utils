package org.utils;

import java.io.Serializable;
import java.util.Timer;

public class TransactionContext implements Serializable {

    //store current State in the 2PC - like prepare, global commit ...
    private States currentState;

    private boolean carFlag;

    private boolean hotelFlag;

    private int coordinatorPort;

    private boolean answered;

    private SharedRessourcesTimerThread sharedRessourcesTimerThread;

    private Operations decission;

    //constructor for the TravelBroker
    public TransactionContext(States currentState, boolean carFlag, boolean hotelFlag) {
        this.currentState = currentState;
        this.carFlag = carFlag;
        this.hotelFlag = hotelFlag;
    }

    public TransactionContext(States currentState, boolean carFlag, boolean hotelFlag, Operations decission) {
        this.currentState = currentState;
        this.carFlag = carFlag;
        this.hotelFlag = hotelFlag;
        this.decission = decission;
    }

    //constructor for the Hotel and Car service
    public TransactionContext(States currentState, int coordinatorPort, boolean answered, Operations decission) {
        this.currentState = currentState;
        this.coordinatorPort = coordinatorPort;
        this.answered = answered;
        this.decission = decission;
    }

    public TransactionContext(States currentState, int coordinatorPort, boolean answered, Operations decission, SharedRessourcesTimerThread sharedRessourcesTimerThread) {
        this.currentState = currentState;
        this.answered = answered;
        this.coordinatorPort = coordinatorPort;
        this.decission = decission;
        this.sharedRessourcesTimerThread = sharedRessourcesTimerThread;
    }

    //constructor with TimerThread
    public TransactionContext(States currentState, boolean carFlag, boolean hotelFlag, SharedRessourcesTimerThread sharedRessourcesTimerThread) {
        this.currentState = currentState;
        this.carFlag = carFlag;
        this.hotelFlag = hotelFlag;
        this.sharedRessourcesTimerThread = sharedRessourcesTimerThread;
    }

    public States getCurrentState() {
        return currentState;
    }

    public void setCurrentState(States currentState) {
        this.currentState = currentState;
    }

    public boolean isCarFlag() {
        return carFlag;
    }

    public void setCarReceived(boolean carReceived) {
        this.carFlag = carReceived;
    }

    public boolean isHotelFlag() {
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

    public SharedRessourcesTimerThread getSharedRessourcesTimerThread() {
        return sharedRessourcesTimerThread;
    }

    public void setSharedRessourcesTimerThread(SharedRessourcesTimerThread sharedRessourcesTimerThread) {
        this.sharedRessourcesTimerThread = sharedRessourcesTimerThread;
    }

    public Operations getDecission() {
        return decission;
    }

    public void setDecission(Operations decission) {
        this.decission = decission;
    }
}
