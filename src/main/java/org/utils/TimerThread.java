package org.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TimerThread extends Thread implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(TimerThread.class.getName());

    private UUID transactionId;

    private int seconds;

    private int responsePort;

    private boolean travelBrokerStarted;

    private SharedRessourcesTimerThread sharedRessourcesTimerThread;

    public TimerThread(UUID transactionId, int seconds, int responsePort, boolean travelBrokerStarted, SharedRessourcesTimerThread sharedRessourcesTimerThread){
        this.transactionId = transactionId;
        this.seconds = seconds;
        this.responsePort = responsePort;
        this.travelBrokerStarted = travelBrokerStarted;
        this.sharedRessourcesTimerThread = sharedRessourcesTimerThread;
    }

    public void run() {

        ObjectMapper objectMapper = new ObjectMapper();
        if(travelBrokerStarted){
            //if the travelBroker started we need to wait for a response to our Prepare. If one or both didn't answer we have to decide abort

            //set timer
            try {
                LOGGER.log(Level.INFO, "Timer: Timer started");
                TimeUnit.SECONDS.sleep(seconds);

                if(!sharedRessourcesTimerThread.isInterrupt()){
                    LOGGER.log(Level.INFO, "Timer: Abort is beeing send");
                    try(DatagramSocket dgSocket = new DatagramSocket(6666)){
                        UDPMessage message = new UDPMessage(Operations.ABORTFROMTIMER, transactionId);
                        byte[] parsedMessage = objectMapper.writeValueAsBytes(message);
                        DatagramPacket dpMessage = new DatagramPacket(parsedMessage, parsedMessage.length, Participant.localhost, responsePort);

                        dgSocket.send(dpMessage);
                    }catch (Exception e){
                        LOGGER.log(Level.SEVERE, "Timer: Error with the socket");
                    }
                }else{
                    LOGGER.log(Level.INFO, "Timer: No abort request was send, cause both participants answered in time");
                }
            } catch (InterruptedException ie) {

            }
        }else{
            //if the travelBroker didn't start the thread it was one of the participants
            //if the coordinator doesn't answer we need to request the other participant if he knows how the decision already

            //set timer
            LOGGER.log(Level.INFO, "Timer: Timer started");
            try {
                TimeUnit.SECONDS.sleep(seconds);

                if(!sharedRessourcesTimerThread.isInterrupt()){
                    LOGGER.log(Level.INFO, "Timer: Request to ask the other participant for the response is beeing send");
                    try(DatagramSocket dgSocket = new DatagramSocket(6666)){
                        UDPMessage message = new UDPMessage(Operations.COORDINATORDOWN, transactionId);
                        byte[] parsedMessage = objectMapper.writeValueAsBytes(message);
                        DatagramPacket dpMessage = new DatagramPacket(parsedMessage, parsedMessage.length, Participant.localhost, responsePort);

                        dgSocket.send(dpMessage);
                    }catch (Exception e){
                        LOGGER.log(Level.SEVERE, "Timer: Error with the socket");
                    }
                }else {
                    LOGGER.log(Level.INFO, "Timer: No abort request was send, cause both participants answered in time");
                }
            } catch (InterruptedException ie) {

            }


        }
}
}
