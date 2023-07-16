package org.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimerThread extends Thread{

    private final static Logger LOGGER = Logger.getLogger(TimerThread.class.getName());

    private UUID transactionId;

    public TimerThread(UUID transactionId){
        this.transactionId = transactionId;
    }

    public void run() {

                ObjectMapper objectMapper = new ObjectMapper();

                //set timer
                try {
                    TimeUnit.MINUTES.sleep(1);

                    if(interrupted()){
                        try(DatagramSocket dgSocket = new DatagramSocket(6666)){
                            UDPMessage message = new UDPMessage(Operations.ABORTFROMTIMER, transactionId);
                            byte[] parsedMessage = objectMapper.writeValueAsBytes(message);
                            DatagramPacket dpMessage = new DatagramPacket(parsedMessage, parsedMessage.length, Participant.localhost, Participant.travelBrokerPort);

                            dgSocket.send(dpMessage);
                        }catch (Exception e){
                            LOGGER.log(Level.SEVERE, "Error with the socket");
                        }
                    }
                    LOGGER.log(Level.INFO, "No abort request was send, cause both OKs were received");
                } catch (InterruptedException ie) {

                }
}

    public void cancel() { interrupt(); }
}
