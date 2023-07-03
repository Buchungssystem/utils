package org.utils;
import java.net.InetAddress;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Participant {

    public static final int travelBrokerPort = 4446;


    public Participant(){
        localhost = InetAddress.getLoopbackAddress();
    }

    public InetAddress localhost;

    public abstract Operations Vote();

    public abstract byte[] book(LocalDate startDate, LocalDate endDate);

    public abstract ArrayList<Object> getAvailableItems(LocalDate startDate, LocalDate endDate);


}
