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
    private String operation;

    public UDPMessage(UUID pTransaktionNumber, byte[] pData, SendingInformation pSender, String pOperation) {
        this.transaktionNumber = pTransaktionNumber;
        this.data = pData;
        this.sender = pSender;
        this.operation = pOperation;
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

    public String getOperation() {
        return operation;
    }
}
