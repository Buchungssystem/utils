package org.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UDPMessage {

    @JsonProperty("transaktionNumber")
    private UUID transaktionNumber;

    @JsonProperty("data")
    private byte[] data;

    @JsonProperty("sender")
    private SendingInformation sender;

    @JsonProperty("operation")
    private Operations operation;

    @JsonProperty("originPort")
    private int originPort;

    @JsonProperty("recovery")
    private boolean recovery;

    public UDPMessage(Operations operation, UUID transaktionId){
        this.operation = operation;
        this.transaktionNumber = transaktionId;
    }

    public UDPMessage(UUID pTransaktionNumber, byte[] pData, SendingInformation pSender, Operations pOperation, int originPort, boolean recovery) {
        this.transaktionNumber = pTransaktionNumber;
        this.data = pData;
        this.sender = pSender;
        this.operation = pOperation;
        this.originPort = originPort;
        this.recovery = recovery;
    }

    //constructor to request for TravelBroker
    public UDPMessage(UUID pTransaktionNumber, byte[] pData, SendingInformation pSender, Operations pOperation, int originPort) {
        this.transaktionNumber = pTransaktionNumber;
        this.data = pData;
        this.sender = pSender;
        this.operation = pOperation;
        this.originPort = originPort;
    }

    //constructor to answer for participants
    public UDPMessage(UUID transaktionNumber, SendingInformation sender, Operations operation, boolean recovery) {
        this.transaktionNumber = transaktionNumber;
        this.sender = sender;
        this.operation = operation;
        this.recovery = recovery;
    }

    public UDPMessage(UUID transaktionNumber, SendingInformation sender, Operations operation) {
        this.transaktionNumber = transaktionNumber;
        this.sender = sender;
        this.operation = operation;
    }

    public UDPMessage(){}

    public UUID getTransaktionNumber() {
        return transaktionNumber;
    }

    public byte[] getData() {
        return data;
    }

    public SendingInformation getSender() {
        return sender;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setTransaktionNumber(UUID transaktionNumber) {
        this.transaktionNumber = transaktionNumber;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setSender(SendingInformation sender) {
        this.sender = sender;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public int getOriginPort() {
        return originPort;
    }

    public void setOriginPort(int originPort) {
        this.originPort = originPort;
    }

    public boolean isRecovery() {
        return recovery;
    }
}
