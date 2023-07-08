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

    public UDPMessage(UUID pTransaktionNumber, byte[] pData, SendingInformation pSender, Operations pOperation) {
        this.transaktionNumber = pTransaktionNumber;
        this.data = pData;
        this.sender = pSender;
        this.operation = pOperation;
    }

    public UDPMessage(){

    }

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
}
